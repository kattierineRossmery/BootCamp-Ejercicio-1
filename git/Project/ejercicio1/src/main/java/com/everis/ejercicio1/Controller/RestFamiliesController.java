package com.everis.ejercicio1.Controller;

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

import com.everis.ejercicio1.models.Families;
import com.everis.ejercicio1.models.FamilyMembers;
import com.everis.ejercicio1.service.IFamiliesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Api(value = "Servicios de Familia")
@RequestMapping("/api/v1/families")
public class RestFamiliesController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	
  @Autowired
  private IFamiliesService serv;

  /**
   * GET - Lista de Familias.
   * @return lista Families.
   */
  @ApiOperation(value = "Return list of family")
  @GetMapping
  public ResponseEntity<List<Families>> listar() {
	  log.info("lista de familias");
    return new ResponseEntity<List<Families>>(serv.list(), HttpStatus.OK);
    

  }

  /**
   * Lista de miembros de la familia por Id.
   * @param family_id id de familia.
   * @return a lista de miembros de la familia.
   */
  @ApiOperation(value = "Return list of family by id members")
  @GetMapping(value = "/{family_id}/members")
  public ResponseEntity<List<FamilyMembers>> listarMembersId(@PathVariable("family_id") Integer family_id) {
	  log.info("lista de miembros de una familias");
    return new ResponseEntity<List<FamilyMembers>>(serv.findByFamiliesFamily_id(family_id), HttpStatus.OK);

  }

  /**
   * Esta funcion es reposnsable de realizar un registro en
   * familia.
   * @param fam id de familia.
   * @return objeto.
   */
  @ApiOperation(value = "Create new family")
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Families insertar(@RequestBody Families fam) {
	  
    try {
		

       new ResponseEntity<Families>(serv.create(fam), HttpStatus.CREATED);
       log.info("creado con exito" + " a la familia" + fam.getFamilyName());
	} catch (Exception e) {
		log.error("registro no creado");
		new ResponseEntity<Families>(HttpStatus.BAD_REQUEST);

		e.printStackTrace();
	}
    
    return fam;
  }

  /**
   * Esta funcion es responsable de actualizar un registro.
   * @param fam the Families.
   * @return objeto modificado.
   */
  @ApiOperation(value = "Update family")
  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String modificar(@RequestBody Families fam) {

	  String mensaje = "";
		Optional<Families> obj = serv.listId(fam.getFamilyId());

		if (obj.isPresent()) {
			 serv.update(fam);
			mensaje = "Modificado con éxito!! a la familia " + fam.getFamilyName();
			log.info(mensaje);
			new ResponseEntity<Families>(HttpStatus.CREATED);

		} else {
			mensaje = "Families no existe";
			log.error(mensaje);
			new ResponseEntity<Families>(HttpStatus.BAD_REQUEST);
		}

		return mensaje;
  }

  /**
   * Esta funcion es responsable de eliminar un registro.
   * @param id - id dado por el usuario, este tiene que existir.
   */
  @ApiOperation(value = "Delete family by id")
  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable("id") Integer id) {
	  
    serv.delete(id);
    new ResponseEntity<Families>(HttpStatus.OK);

  }
}
