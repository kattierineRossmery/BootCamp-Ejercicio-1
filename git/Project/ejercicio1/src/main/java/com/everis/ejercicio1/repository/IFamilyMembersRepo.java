package com.everis.ejercicio1.repository;

import com.everis.ejercicio1.models.FamilyMembers;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IFamilyMembersRepo extends CrudRepository<FamilyMembers, Integer> {


  List<FamilyMembers> findByFamiliesFamilyId(int familyId);
  
}
