package com.example.crudfarmacia.services;

import com.example.crudfarmacia.dto.MedicamentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseServices  <E>{

   public List<E> findAll() ;

   public Page<E> finaAll(Pageable pageable) ;

   public Optional<E> findById(final Long id) ;

   public E save(final E Dto) ;

   public void delete(final Long id) ;

   public  E update(final Long id, final E DTO)  ;
}
