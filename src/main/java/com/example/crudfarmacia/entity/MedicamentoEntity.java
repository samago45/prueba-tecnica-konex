package com.example.crudfarmacia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Medicamento")
public class MedicamentoEntity {
   @Id
   @Column(name = "id", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "nombre", nullable = false)
   private String nombre;

   @Column(name = "laboratorio_de_fabricacion", nullable = false)
   private String laboratorioDeFabricacion;

   @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
   @Column(name = "fecha_de_fabricacion", nullable = false)
   private Date fechaDeFabricacion;

   @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
   @Column(name = "fecha_de_vencimento", nullable = false)
   private Date fechaDeVencimento;

   @Column(name = "stock", nullable = false)
   private int stock;

   @Column(name = "valor_unitario", nullable = false)
   private Double valorUnitario;

   @Column(name = "estado", nullable = false)
   private Boolean estado;


//   /*Relacion con categoriaEntity -> Mapeo BD*/
//   @ManyToOne(fetch = FetchType.EAGER)
//   @JoinColumn(name = "venta_id")
//   private VentaEntity ventaEntity;

   @OneToMany(mappedBy = "medicamentoEntity")
   @ToString.Exclude
   private Set<VentaEntity> ventaEntities;



   //Getter  and setter methods


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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
      MedicamentoEntity that = (MedicamentoEntity) o;
      return id != null && Objects.equals(id, that.id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }



}
