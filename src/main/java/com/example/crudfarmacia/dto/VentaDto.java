package com.example.crudfarmacia.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class VentaDto {

   private Long id;

   private Date fechaVenta;

   private Time horaVenta;

   private int cantidad;

   private Double valorUnitario;

   private Double valorTotal;

   private Long medicamento_id;


   //Getters y Setters


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getFechaVenta() {
      return fechaVenta;
   }

   public void setFechaVenta(Date fechaVenta) {
      this.fechaVenta = fechaVenta;
   }

   public Time getHoraVenta() {
      return horaVenta;
   }

   public void setHoraVenta(Time horaVenta) {
      this.horaVenta = horaVenta;
   }

   public int getCantidad() {
      return cantidad;
   }

   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }

   public Double getValorUnitario() {
      return valorUnitario;
   }

   public void setValorUnitario(Double valorUnitario) {
      this.valorUnitario = valorUnitario;
   }

   public Double getValorTotal() {
      return valorTotal;
   }

   public void setValorTotal(Double valorTotal) {
      this.valorTotal = valorTotal;
   }

   public Long getMedicamento_id() {
      return medicamento_id;
   }

   public void setMedicamento_id(Long medicamento_id) {
      this.medicamento_id = medicamento_id;
   }
}
