package com.everis.ejercicio1.Controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.everis.ejercicio1.models.Parents;
import com.everis.ejercicio1.repository.IParentsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestParentsControllerTest {

	@Autowired
	IParentsRepo repoPa;
	
	@Test
	public void testListar() {
		repoPa.findAll();
	}

	@Test
	public void testInsertar() {
		Parents par = new Parents();
		//par.setParentId();
		par.setFirstName("Damiela");
		par.setGender("F");
		par.setLastName("Perez");
		par.setMiddleName("Maria");
		par.setOtherParentDetails("hioh");	
		repoPa.save(par);
		
		assertTrue("true", true);
	}

	@Test
	public void testModificar() {
		Parents par = new Parents();
		par.setParentId(4);
		par.setFirstName("juan");
		par.setGender("M");
		par.setLastName("Rosales");
		par.setMiddleName("Pedro");
		par.setOtherParentDetails("eeeee");	
		repoPa.save(par);
		
		assertTrue("true", true);
	}

	@Test
	public void testEliminar() {
		
		repoPa.deleteById(8);
	}

}
