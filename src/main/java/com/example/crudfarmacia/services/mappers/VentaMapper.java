package com.example.crudfarmacia.services.mappers;


import com.example.crudfarmacia.dto.VentaDto;
import com.example.crudfarmacia.entity.MedicamentoEntity;
import com.example.crudfarmacia.entity.VentaEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {MedicamentoMapper.class})
public interface VentaMapper {

   @Mappings({
            @Mapping(target = "id" , source = "id"),
            @Mapping(target = "fechaVenta" , source = "fechaVenta"),
            @Mapping(target = "horaVenta" , source = "horaVenta"),
            @Mapping(target = "cantidad" , source = "cantidad"),
           @Mapping(target = "valorUnitario" , source = "valorUnitario"),
           @Mapping(target = "valorTotal" , source = "valorTotal"),
           @Mapping(target = "medicamento_id" , source = "medicamentoEntity.id"),
   })

   public List<VentaDto> toVentaDto(List<VentaEntity> ventas);
   public VentaDto toDto(VentaEntity ventaEntity);

   @InheritInverseConfiguration
   public VentaEntity toVentaEntity(VentaDto ventaDto);
}
