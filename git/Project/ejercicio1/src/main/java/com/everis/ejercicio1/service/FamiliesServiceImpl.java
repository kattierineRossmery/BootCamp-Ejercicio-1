package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.ejercicio1.models.Families;
import com.everis.ejercicio1.models.FamilyMembers;
import com.everis.ejercicio1.repository.IFamiliesRepo;
import com.everis.ejercicio1.repository.IFamilyMembersRepo;

@Service
public class FamiliesServiceImpl implements IFamiliesService {

  @Autowired
  private IFamiliesRepo repo;
  
  @Autowired
  private IFamilyMembersRepo repofamilyMembers;
  
 // @Autowired
 // private IParentsRepo repoParents;
  
  /**
   * this function is responsible for making a record of a family.
   * @return object.
   */
  @Override
  public Families create(Families families) {
    return repo.save(families);
  }

  /**
   * this function is responsible for updating an existing record.
   */
  @Override
  public void update(Families families) {
 
	  if(repo.findById(families.getFamilyId()).isPresent()) {
		  repo.save(families);
			new ResponseEntity<Families>(HttpStatus.CREATED);
	  }
	  else {
			new ResponseEntity<Families>(HttpStatus.BAD_REQUEST);

	  }
	  
    
    
    
  
  }

  /**
   * this function is responsible for deleting an existing record.
   */
  @Override
  public void delete(int id) {
    
    repo.findById(id).ifPresent((f) -> {
      
      repo.deleteById(id);
     
      
    });
  }

  /**
   * this function is responsible for listing a record by id.
   * @return a object 
   */
  @Override
  public Optional<Families> listId(int id) {
    return repo.findById(id);
  }

  /**
   * this function is responsible for listing all the records of the Families entity.
   */
  @Override
  public List<Families> list() {
    return (List<Families>) repo.findAll();
  }

  /**
   * this function is responsible for listing all
   *  the family members of a family by the id of the family entity.
   */
  @Override
  public List<FamilyMembers> findByFamiliesFamily_id(int familyId) {
    

    return repofamilyMembers.findByFamiliesFamilyId(familyId);
     
  }


}
