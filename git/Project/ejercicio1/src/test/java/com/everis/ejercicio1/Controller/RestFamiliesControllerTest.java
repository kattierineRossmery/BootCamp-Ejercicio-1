package com.everis.ejercicio1.Controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.everis.ejercicio1.models.Families;
import com.everis.ejercicio1.models.Parents;
import com.everis.ejercicio1.repository.IFamiliesRepo;
import com.everis.ejercicio1.repository.IFamilyMembersRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestFamiliesControllerTest {
///////////
	/////////////
	/**
	 * HSFHD
	 */
	@Autowired
	IFamiliesRepo repoFam;
	IFamilyMembersRepo repoMem;
	
	@Test
	public void testListar() {
		repoFam.findAll();
		fail("Not yet implemented");
	}

	@Test
	public void testListarMembersId() {
		
		repoMem.findByFamiliesFamilyId(1);
	}

	@Test
	public void testInsertar() {
		Families fam = new Families();
		fam.setFamilyName("Perez");
		Parents p = new Parents();
		p.setParentId(9);
		fam.setParentsss(p);
		
		assertTrue(true);
		
		fail("Not yet implemented");
	}

	@Test
	public void testModificar() {
		Families fam = new Families();
		fam.setFamilyId(3);
		fam.setFamilyName("Perez");
		Parents p = new Parents();
		p.setParentId(9);
		fam.setParentsss(p);
		
		assertTrue(true);
		
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		repoFam.deleteById(6);
		assertTrue(true);
		fail("Not yet implemented");
	}

}
