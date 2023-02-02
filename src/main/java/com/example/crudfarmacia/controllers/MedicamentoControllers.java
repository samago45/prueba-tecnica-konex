package com.example.crudfarmacia.controllers;

import com.example.crudfarmacia.dto.MedicamentoDto;
import com.example.crudfarmacia.services.MedicamentoServices;
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
@RequestMapping("/api/medicamento")
public class MedicamentoControllers {


   @Autowired
   private MedicamentoServices medicamentoServices;

//Funciona
   @GetMapping("/")
   public ResponseEntity<List<MedicamentoDto>> findAll() {
      return new ResponseEntity<>(medicamentoServices.findAll(), HttpStatus.OK) ;
   }

   @GetMapping("page")
   public ResponseEntity<Page<MedicamentoDto>> findAllpage( final Pageable pageable) {
      return new ResponseEntity<>(medicamentoServices.finaAll( pageable), HttpStatus.OK) ;
   }

//Funciona
   @GetMapping("/buscar/{id}")
   private ResponseEntity<Optional<MedicamentoDto>> get(@PathVariable final Long id)   {
      return  new ResponseEntity<>(medicamentoServices.findById(id) , HttpStatus.OK);
   }

//Funciona
   @PostMapping(value = "guardar")
   public ResponseEntity<MedicamentoDto> create(@Validated @RequestBody MedicamentoDto request)  {
      return new ResponseEntity<>(medicamentoServices.save(request) , HttpStatus.OK);
   }
//No esta funcioando
   @PostMapping("/actualizar/{id}")
   private void update(@PathVariable final Long id, @Validated @RequestBody MedicamentoDto request)  {
       medicamentoServices.update(id, request);
   }

   @DeleteMapping("/deleted/{id}")
   private ResponseEntity<MedicamentoDto> eliminar(@PathVariable final Long id) {
      medicamentoServices.delete(id);
     return new ResponseEntity<>( HttpStatus.OK);

   }
}
