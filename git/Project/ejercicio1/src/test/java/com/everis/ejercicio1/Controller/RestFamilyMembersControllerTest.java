package com.everis.ejercicio1.Controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.everis.ejercicio1.models.Families;
import com.everis.ejercicio1.models.FamilyMembers;
import com.everis.ejercicio1.models.Parents;
import com.everis.ejercicio1.models.Students;
import com.everis.ejercicio1.repository.IFamilyMembersRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestFamilyMembersControllerTest {

	@Autowired
	IFamilyMembersRepo repoMem;
	
	@Test
	public void testListar() {
		repoMem.findAll();
		fail("Not yet implemented");
	}

	@Test
	public void testInsertar() {
		
		FamilyMembers fm = new FamilyMembers();
		
		fm.setParentOrStudentMembers("PADRE");
		Families fam = new Families();
		fam.setFamilyId(1);
		Parents par = new Parents();
		par.setParentId(9);
		
		Students stu = new Students();
		stu.setStudentId(1);
		
		fail("Not yet implemented");
	}

	@Test
	public void testModificar() {
FamilyMembers fm = new FamilyMembers();

		fm.setFamilyMemberId(1);
		fm.setParentOrStudentMembers("S");
		Families fam = new Families();
		fam.setFamilyId(1);
		Parents par = new Parents();
		par.setParentId(9);
		
		Students stu = new Students();
		stu.setStudentId(1);
		
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		repoMem.deleteById(1);
		assertTrue(true);
		fail("Not yet implemented");
	}

}
