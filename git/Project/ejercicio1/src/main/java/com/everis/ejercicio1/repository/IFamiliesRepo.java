package com.everis.ejercicio1.repository;

import org.springframework.data.repository.CrudRepository;

import com.everis.ejercicio1.models.Families;

public interface IFamiliesRepo extends CrudRepository<Families, Integer> {
  
  

}
