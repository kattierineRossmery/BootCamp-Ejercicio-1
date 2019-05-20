package com.everis.ejercicio1.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Esta clase pertenece a la entidad Parents.
 * @version 15-05-2019 v1
 * @author kvilcave
 *
 */
@ApiModel("Model Parent")
@Entity
@Data
@Table(name = "Parents")
public class Parents {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "Id de Parents", required = true)
  @Column(name = "parent_id")
  private int parentId;

  @NotNull @NotBlank
  @ApiModelProperty(value = "Genero", required = true)
  private String gender;

  @NotNull @NotBlank
  @ApiModelProperty(value = "Primer nombre debe tener minimo 3 caracteres", required = true)
  @Size(min=3, max =70, message = "Primer nombre debe tener minimo 3 caracteres")
  @Column(name = "first_name")
  private String firstName;

  @ApiModelProperty(value = "Segundo nombre debe tener minimo 3 caracteres", required = true)
  @Size(min=3, max=70, message = "Segundo nombre debe tener minimo 3 caracteres")
  @Column(name = "middle_name")
  private String middleName;

  @NotBlank
  @ApiModelProperty(value = "Apellido debe tener minimo 3 caracteres", required = true)
  @Size(min=3,max=70, message = "Apellido debe tener minimo 3 caracteres")
  @Column(name = "last_name")
  private String lastName;

  @ApiModelProperty(value = "the parent's details", required = true)
  @Column(name = "other_parent_details", length = 180)
  private String otherParentDetails;

  /**
   * La entidad Parents está en relación One to Many a la entidad Families.
   * "parentsss" referncia a la entidad Families.
   */
  @JsonIgnore
  @OneToMany(mappedBy = "parentsss", cascade = {CascadeType.PERSIST,CascadeType.MERGE,
		  CascadeType.REMOVE},fetch = FetchType.LAZY,orphanRemoval = true)
  private List<Families> listaFamilias;

  /**
   * La entidad Parents está en relación One to Many a la entidad FamilyMembers.
   * "parents" referencia a la entidad FamilyMembers.
   */
  @JsonIgnore
  @OneToMany(mappedBy = "parents", cascade = {CascadeType.PERSIST,CascadeType.MERGE,
		  CascadeType.REMOVE},fetch = FetchType.LAZY,orphanRemoval = true)
  private List<FamilyMembers> listaFamilyMembers;

  /**
   * studentsParents es la nueva tabla creada en 
   * relación de muchos a muchos entre las entidades 
   * parents y students.
   * 
   * FK_Students es el nombre de la columna que referencia a student_id.
   * FK_Parents es el nombre de la columna que referencia a parent_id.
   * 
   * estudiantes reference to the entity Students.
   */
  @JsonIgnore
  @JoinTable(name = "studentsParents", joinColumns = @JoinColumn(name = "FK_Parents", 
      referencedColumnName = "parent_id"), inverseJoinColumns = @JoinColumn(name = "FK_Students", 
      referencedColumnName = "student_id"))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Students> estudiantes;

}
