package com.example.crudfarmacia.repository;

import com.example.crudfarmacia.entity.MedicamentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity , Long> {


   @Query(value = "SELECT * FROM  MEDICAMENTO  WHERE MEDICAMENTO .ESTADO =?  ", nativeQuery = true)
   public List<MedicamentoEntity> finAllMedicamentoEntityAndEstado(final boolean estado);

   public Page<MedicamentoEntity> findAllByEstado(final boolean deleted, final Pageable pageable);


   @Query(value = "SELECT * FROM  MEDICAMENTO WHERE MEDICAMENTO.ID =? AND MEDICAMENTO.ESTADO =?", nativeQuery = true)
   public Optional<MedicamentoEntity> findByIdAndEstado(final Long id, final boolean estado);

   public Optional<MedicamentoEntity> findById(final Long id);

   @Query(value = "UPDATE MEDICAMENTO SET MEDICAMENTO.ESTADO = ? WHERE MEDICAMENTO.ID = ?", nativeQuery = true)
   void updateEstado(final boolean estado,final Long id);

   public boolean existsByIdAndEstado(final Long id, final boolean deleted);
}

