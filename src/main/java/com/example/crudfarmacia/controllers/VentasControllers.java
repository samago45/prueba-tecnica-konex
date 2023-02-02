package com.example.crudfarmacia.controllers;

import com.example.crudfarmacia.dto.MedicamentoDto;
import com.example.crudfarmacia.dto.VentaDto;
import com.example.crudfarmacia.services.VentaServices;
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
@RequestMapping("/api/venta")
public class VentasControllers {

   @Autowired
   private VentaServices ventaServices;

   @GetMapping("/")
   public ResponseEntity<List<VentaDto>> findAll() {
      return new ResponseEntity<>(ventaServices.findAll(), HttpStatus.OK) ;
   }

   @GetMapping("/page")
   public ResponseEntity<Page<VentaDto>> findAllpage(final Pageable pageable) {
      return new ResponseEntity<>(ventaServices.finaAll( pageable), HttpStatus.OK) ;
   }

   @PostMapping("/buscar/{id}")
   private ResponseEntity<Optional<VentaDto>> getById(@PathVariable final Long id)   {
      return  new ResponseEntity<>(ventaServices.findById(id) , HttpStatus.OK);
   }


   @PostMapping("/crear-venta")
   private ResponseEntity<VentaDto> creaVenta(@Validated @RequestBody VentaDto request)   {
      return  new ResponseEntity<>(ventaServices.nuevaVenta(request) , HttpStatus.OK);
   }

}
