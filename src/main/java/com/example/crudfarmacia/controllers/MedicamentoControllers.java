package com.example.crudfarmacia.controllers;

import com.example.crudfarmacia.dto.MedicamentoDto;
import com.example.crudfarmacia.services.MedicamentoServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MedicamentoControllers {


   @Autowired
   private MedicamentoServices medicamentoServices;


   @GetMapping("/medicamento")
   @ApiOperation(value = "Obtener todos los medicamentos, permite paginacion y filtrado")
   public ResponseEntity<Page<MedicamentoDto>> findAll( final Pageable pageable) {
      return new ResponseEntity<>(medicamentoServices.finaAll( pageable), HttpStatus.OK) ;
   }


   @GetMapping("/medicamento/{id}")
   @ApiOperation(value = "Obtener un medicamento por id")
   private ResponseEntity<Optional<MedicamentoDto>> get(@PathVariable final Long id)   {
      return new ResponseEntity<>(medicamentoServices.findById(id) , HttpStatus.OK);
   }


   @PostMapping(value = "/medicamento")
   @ApiOperation(value = "Permite crear un  nuevo medicamento")
   public ResponseEntity<MedicamentoDto> create(@Validated @RequestBody MedicamentoDto request)  {
      return new ResponseEntity<>(medicamentoServices.save(request) , HttpStatus.CREATED);
   }
//No esta funcioando
   @PostMapping("/medicamento/{id}")
   @ApiOperation(value = "Permite actualizar un medicamento por id")
   private ResponseEntity<?> update( @PathVariable final Long id, @Validated @RequestBody MedicamentoDto request)  {
       medicamentoServices.update(id, request);
   return new ResponseEntity<>("Se actualizo correctamente",HttpStatus.OK);
   }

   @DeleteMapping("/deleted/{id}")
   private ResponseEntity<?> eliminar(@PathVariable final Long id) {
      medicamentoServices.delete(id);
     return new ResponseEntity<>( "Se alimino correctamente el medicamento",HttpStatus.OK);

   }
}
