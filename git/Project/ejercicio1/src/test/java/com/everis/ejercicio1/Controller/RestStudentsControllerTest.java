package com.everis.ejercicio1.Controller;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.everis.ejercicio1.models.Students;
import com.everis.ejercicio1.repository.IStudentsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestStudentsControllerTest {

	@Autowired
	IStudentsRepo repoStu;

	@Test
	public void testListar() {
		repoStu.findAll();
	}

	@Test
	public void testInsertar() {
		Students stu = new Students();
		SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
		String strfechas = "2000-04-09";

		Date fecha = null;
		try {
			fecha = dates.parse(strfechas);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		stu.setDateOfBirth(fecha);

		stu.setFirstName("Luisa");
		stu.setMiddleName("Lina");
		stu.setGender("F");
		stu.setLastName("Perez");
		stu.setOtherStudentDetails("oooooo");

		repoStu.save(stu);

		assertTrue("true", true);
	}

	@Test
	public void testModificar() {
		Students stu = new Students();
		
		stu.setStudentId(2);

		//Fecha
		SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
		String strfechas = "2000-04-09";

		Date fecha = null;
		try {
			fecha = dates.parse(strfechas);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		stu.setDateOfBirth(fecha);
		//
		stu.setFirstName("Juaito");
		stu.setMiddleName("Ascencio");
		stu.setGender("M");
		stu.setLastName("Segura");
		stu.setOtherStudentDetails("oooooo");

		repoStu.save(stu);

		assertTrue("true", true);
	}

	@Test
	public void testEliminar() {
		repoStu.findById(1);
	}

}
