package com.example.crudfarmacia.repository;

import com.example.crudfarmacia.entity.MedicamentoEntity;
import com.example.crudfarmacia.entity.VentaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity , Long> {


   public Optional<VentaEntity> findById(final Long id);


   public Page<VentaEntity> findAll( final Pageable pageable);

//   @Query(value = "SELECT * FROM  MEDICAMENTO WHERE MEDICAMENTO.ID =? ", nativeQuery = true)
//   public Optional<VentaEntity> findById(final Long id);
}
