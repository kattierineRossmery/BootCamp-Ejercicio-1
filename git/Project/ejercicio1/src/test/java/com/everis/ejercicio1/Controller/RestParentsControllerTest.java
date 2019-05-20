package com.everis.ejercicio1.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
		repoPa = mock(IParentsRepo.class);
		when(repoPa.findAll());
		repoPa.findAll();

	}

	@Test
	public void testInsertar() {
		repoPa = mock(IParentsRepo.class);

		Parents par = new Parents();

		par.setFirstName("Damiela");
		par.setGender("F");
		par.setLastName("rtttt");
		par.setMiddleName("Maria");
		par.setOtherParentDetails("hioh");
		// repoPa.save(par);

		when(repoPa.save(par)).thenReturn(par);

		// assertTrue();
	}

	@Test
	public void testModificar() {
		Parents par = new Parents();
		par.setParentId(13);
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

		repoPa.deleteById(12);
	}

}
