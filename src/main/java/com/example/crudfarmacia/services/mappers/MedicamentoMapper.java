package com.example.crudfarmacia.services.mappers;


import com.example.crudfarmacia.dto.MedicamentoDto;
import com.example.crudfarmacia.entity.MedicamentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicamentoMapper {

   MedicamentoDto toMedicamentoDto(final MedicamentoEntity medicamentoEntity);

   List<MedicamentoDto> toMedicamentoDtoList(final List<MedicamentoEntity> medicamentoEntityList);


//   Page<MedicamentoDto> toMedicamentoDtoPage(final Page<MedicamentoEntity> medicamentoEntityList);

   @InheritInverseConfiguration
   MedicamentoEntity toMedicamentoEntity(final MedicamentoDto medicamentoDto);

}
