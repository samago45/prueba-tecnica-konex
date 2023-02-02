package com.example.crudfarmacia.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MedicamentoDto {

   private Long id;

   private String nombre;

   private String laboratorioDeFabricacion;

   private Date fechaDeFabricacion;

   private Date fechaDeVencimento;

   private int stock;

   private Double valorUnitario;

   private Boolean estado =Boolean.FALSE;


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

   public Double getValorUnitario() {
      return valorUnitario;
   }

   public void setValorUnitario(Double valorUnitario) {
      this.valorUnitario = valorUnitario;
   }

   public Boolean getEstado() {
      return estado;
   }

   public void setEstado(Boolean estado) {
      this.estado = estado;
   }
}
