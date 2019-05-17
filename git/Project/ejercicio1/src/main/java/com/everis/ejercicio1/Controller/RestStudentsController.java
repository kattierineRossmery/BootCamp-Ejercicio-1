package com.everis.ejercicio1.Controller;

import com.everis.ejercicio1.models.Students;
import com.everis.ejercicio1.service.IStudentsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Api(value = "Servicios de Student")
@RequestMapping("/api/v1/students")
public class RestStudentsController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStudentsService serv;

	/**
	 * List of the Students.
	 * 
	 * @return list Students.
	 */
	@ApiOperation(value = "Return list of family")
	@GetMapping
	public ResponseEntity<List<Students>> listar() {

		log.info("lista ok");
		return new ResponseEntity<List<Students>>(serv.list(), HttpStatus.OK);

	}

	/**
	 * this function is responsible for making a record of a family.
	 * 
	 * @param stu - stu almacena el registro.
	 */
	@ApiOperation(value = "Create new students")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertar(@RequestBody Students stu) {
		try {
			serv.create(stu);
			log.info("Se registro a"+ stu.getFirstName()+" "+ stu.getLastName());
			new ResponseEntity<Students>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("registro no creado");
			new ResponseEntity<Students>(HttpStatus.BAD_REQUEST);

		}
	}

	/**
	 * this function is responsible for updating an existing record.
	 * 
	 * @param stu stu.
	 * @return obj
	 */
	@ApiOperation(value = "Update students")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String modificar(@RequestBody Students stu) {
		String mensaje = "";
		Optional<Students> obj = serv.listId(stu.getStudentId());

		if (obj.isPresent()) {
			serv.update(stu);
			mensaje = "Modificado con éxito!! ";
			new ResponseEntity<Students>(HttpStatus.CREATED);

			log.info(mensaje + stu.getStudentId());
		} else {
			mensaje = "Pariente no existe";
			log.error(mensaje);
			new ResponseEntity<Students>(HttpStatus.BAD_REQUEST);

		}

		return mensaje;
	}

	/**
	 * this function is responsible for deleting an existing record.
	 * 
	 * @param id - id de Estudiante existente.
	 */
	@ApiOperation(value = "Delete students by id")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		try {
			serv.delete(id);
			log.info("registro eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("id no existe");
			new ResponseEntity<Students>(HttpStatus.BAD_REQUEST);
		}

	}
}
