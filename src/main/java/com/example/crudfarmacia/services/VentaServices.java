package com.example.crudfarmacia.services;


import com.example.crudfarmacia.dto.VentaDto;
import com.example.crudfarmacia.entity.MedicamentoEntity;
import com.example.crudfarmacia.entity.VentaEntity;
import com.example.crudfarmacia.exception.ControllerResquestException;
import com.example.crudfarmacia.repository.MedicamentoRepository;
import com.example.crudfarmacia.repository.VentaRepository;
import com.example.crudfarmacia.services.mappers.MedicamentoMapper;
import com.example.crudfarmacia.services.mappers.VentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServices {

   @Autowired
   private MedicamentoServices medicamentoServices;

   @Autowired
   private VentaMapper ventaMapper;

   @Autowired
   private MedicamentoMapper medicamentoMapper;

   @Autowired
   private VentaRepository ventaRepository;

   @Autowired
   private MedicamentoRepository medicamentoRepository;

/*Lista todas las ventas*/
   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public List<VentaDto> findAll()  {
      List<VentaEntity> ventaEntity = ventaRepository.findAll();
      return ventaMapper.toVentaDto(ventaEntity);
   }


   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public Page<VentaDto> finaAll(final Pageable pageable)  {
      return  ventaRepository.findAll(pageable)
              .map(ventaMapper :: toDto);

   }

   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public Optional<VentaDto> findById(final  Long id)  {
      return Optional.ofNullable(ventaRepository.findById(id)
              .map(ventaMapper::toDto)
              .orElseThrow(() -> new ControllerResquestException("No sea registrado ninguna venta con el Id: " + id)));
   }


   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public VentaDto nuevaVenta(final VentaDto ventaDto) {
      VentaEntity ventaEntity = ventaMapper.toVentaEntity(ventaDto);
      if(!medicamentoRepository.existsByIdAndEstado(ventaDto.getMedicamento_id(), false)){
         throw new ControllerResquestException("El medicamento no se ecuentra en stock");
      }
      MedicamentoEntity medicamentoEntity = this.medicamentoRepository.findById(ventaDto.getMedicamento_id()).get();
       int stock_entity = medicamentoEntity.getStock();
      if(ventaDto.getCantidad() <= 0 || ventaDto.getCantidad() <= stock_entity){
         throw new ControllerResquestException("Ingrese una catidad valida");
      }
      medicamentoEntity.setStock(stock_entity - ventaDto.getCantidad());
      medicamentoServices.update(ventaDto.getMedicamento_id() , medicamentoMapper.toMedicamentoDto(medicamentoEntity));
      return ventaMapper.toDto(ventaEntity);
   }







}
