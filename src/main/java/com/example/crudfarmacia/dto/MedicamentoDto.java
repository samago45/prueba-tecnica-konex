package com.example.crudfarmacia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class MedicamentoDto {

   private Long id;

   @NotBlank(message = "Nombre del Medicamento ")
   @Size(min = 1, max = 50, message = "El  nombre debe tener entre 1 y 50 caracteres")
   @ApiModelProperty(notes = "Medicamento ", example = "Dolanet", required = true)

   private String nombre;

   @NotBlank(message = "Nombre del Laboratorio ")
   @Size(min = 1, max = 50, message = " El nombre debe tener entre 1 y 50 caracteres")
   @ApiModelProperty(notes = "Laboratorio ", example = "Lasca", required = true)

   private String laboratorioDeFabricacion;

//   @NotBlank(message = "Fecha de Fabricacion ")
//   @ApiModelProperty(notes = "Fecha de Fabricacion del Medicamento ", example = "2020-01-02", required = true)

   private Date fechaDeFabricacion;

//   @NotNull(message = "Fecha de Fabricacion ")
//   @DateTimeFormat(pattern = "dd-mm-yyyy")

   private Date fechaDeVencimento;

   @Positive(message = "El stock debe ser mayor a 0")
   @ApiModelProperty(notes = "Stock", example = "1", required = true)

   private int stock;

   private Integer valorUnitario;




   //getter and setter


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getLaboratorioDeFabricacion() {
      return laboratorioDeFabricacion;
   }

   public void setLaboratorioDeFabricacion(String laboratorioDeFabricacion) {
      this.laboratorioDeFabricacion = laboratorioDeFabricacion;
   }

   public Date getFechaDeFabricacion() {
      return fechaDeFabricacion;
   }

   public void setFechaDeFabricacion(Date fechaDeFabricacion) {
      this.fechaDeFabricacion = fechaDeFabricacion;
   }

   public Date getFechaDeVencimento() {
      return fechaDeVencimento;
   }

   public void setFechaDeVencimento(Date fechaDeVencimento) {
      this.fechaDeVencimento = fechaDeVencimento;
   }

   public int getStock() {
      return stock;
   }

   public void setStock(int stock) {
      this.stock = stock;
   }

   public Integer getValorUnitario() {
      return valorUnitario;
   }

   public void setValorUnitario(Integer valorUnitario) {
      this.valorUnitario = valorUnitario;
   }


}
