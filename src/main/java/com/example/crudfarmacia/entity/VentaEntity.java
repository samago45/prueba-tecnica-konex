package com.example.crudfarmacia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ventas")
public class VentaEntity {

   @Id
   @Column(name = "id", unique = true , nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "fecha_venta" , nullable = false)
   private Date fechaVenta;

   @Column(name = "hora_venta" ,  nullable = false)
   private Time horaVenta;

   @Column(name = "cantidad" , nullable = false)
   private int cantidad;

   @Column(name = "valor_unitario" , nullable = false)
   private Double valorUnitario;

   @Column(name = "valor_total" , nullable = false)
   private Double valorTotal;



   /*Relacion con categoriaEntity -> Mapeo BD*/
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "medicamento_id")
   private MedicamentoEntity medicamentoEntity;


   //getter and setter


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

   public MedicamentoEntity getMedicamentoEntity() {
      return medicamentoEntity;
   }

   public void setMedicamentoEntity(MedicamentoEntity medicamentoEntity) {
      this.medicamentoEntity = medicamentoEntity;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
      VentaEntity that = (VentaEntity) o;
      return id != null && Objects.equals(id, that.id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
