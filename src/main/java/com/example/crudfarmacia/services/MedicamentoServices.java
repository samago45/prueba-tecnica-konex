package com.example.crudfarmacia.services;

import com.example.crudfarmacia.dto.MedicamentoDto;
import com.example.crudfarmacia.entity.MedicamentoEntity;
import com.example.crudfarmacia.exception.ControllerResquestException;
import com.example.crudfarmacia.repository.MedicamentoRepository;
import com.example.crudfarmacia.repository.VentaRepository;
import com.example.crudfarmacia.services.mappers.MedicamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServices implements BaseServices<MedicamentoDto> {

   @Autowired
   private MedicamentoRepository medicamentoRepository;

   @Autowired
   private MedicamentoMapper medicamentoMapper;
   @Autowired
   private VentaRepository ventaRepository;

   @Override
   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public List<MedicamentoDto> findAll()  {
      List<MedicamentoEntity> medicamentoEntity = medicamentoRepository.finAllMedicamentoEntityAndEstado(false);
      return medicamentoMapper.toMedicamentoDtoList(medicamentoEntity);
   }

   @Override
   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public Page<MedicamentoDto> finaAll(final Pageable pageable)  {
      return  medicamentoRepository.findAllByEstado(false ,pageable)
              .map(medicamentoMapper :: toMedicamentoDto);

   }

   @Override
   @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
   public Optional<MedicamentoDto> findById(final  Long id)  {
      return Optional.ofNullable(medicamentoRepository.findByIdAndEstado(id, false)
              .map(medicamentoMapper::toMedicamentoDto)
              .orElseThrow(() -> new ControllerResquestException("No existe el medicamento ")));
   }

   @Override
   @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
   public MedicamentoDto save( final MedicamentoDto Dto)  {
      MedicamentoEntity entity = medicamentoMapper.toMedicamentoEntity(Dto);
      return medicamentoMapper.toMedicamentoDto(medicamentoRepository.save(entity));
   }

   @Override
   @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
   public MedicamentoDto update(Long id, MedicamentoDto medicamentoDto) {
      MedicamentoEntity medicamentoEntity = this.medicamentoRepository.findByIdAndEstado(id, false)
      .orElseThrow(() -> new ControllerResquestException("No se pudo actualizar"));
      medicamentoEntity.setNombre(medicamentoDto.getNombre());
      medicamentoEntity.setLaboratorioDeFabricacion(medicamentoDto.getLaboratorioDeFabricacion());
      medicamentoEntity.setFechaDeFabricacion(medicamentoDto.getFechaDeFabricacion());
      medicamentoEntity.setFechaDeVencimento(medicamentoDto.getFechaDeVencimento());
      medicamentoEntity.setStock(medicamentoDto.getStock());
      medicamentoEntity.setValorUnitario(medicamentoDto.getValorUnitario());
        return this.medicamentoMapper.toMedicamentoDto(this.medicamentoRepository.save(medicamentoEntity));
   }


   @Override
   @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
   public void delete(final Long id) {
       if(!medicamentoRepository.existsByIdAndEstado(id, false)){
          throw new ControllerResquestException("No se pudo eliminar");
       }
      MedicamentoEntity medicamentoEntity = this.medicamentoRepository.findById(id).get();
      medicamentoEntity.setEstado(true);
      medicamentoRepository.save(medicamentoEntity);

   }

}
