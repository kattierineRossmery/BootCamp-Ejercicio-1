package com.everis.ejercicio1.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This class belongs to the entity Parents.
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
  @ApiModelProperty(value = "the parent's id", required = true)
  @Column(name = "parent_id")
  private int parentId;

  @NotNull @NotBlank
  @ApiModelProperty(value = "the gender", required = true)
  private String gender;

  @NotNull @NotBlank
  @ApiModelProperty(value = "the parent's first name", required = true)
  @Column(name = "first_name")
  private String firstName;

  @ApiModelProperty(value = "the parent's middle name", required = true)
  @Column(name = "middle_name")
  private String middleName;

  @NotBlank
  @ApiModelProperty(value = "the parent's last name", required = true)
  @Column(name = "last_name")
  private String lastName;

  @ApiModelProperty(value = "the parent's details", required = true)
  @Column(name = "other_parent_details")
  private String otherParentDetails;

  /**
   * The entity Parents is relation One to Many to the entity Families.
   * "parentsss" reference to the entity Families.
   */
  @JsonIgnore
  @OneToMany(mappedBy = "parentsss")
  private List<Families> listaFamilias;

  /**
   * The entity Parents is relation One to Many to the entity FamilyMembers.
   * "parents" reference to the entity FamilyMembers.
   */
  @JsonIgnore
  @OneToMany(mappedBy = "parents")
  private List<FamilyMembers> listaFamilyMembers;

  /**
   * studentsParents is the new table created in 
   * relation of many to many between 
   * parents and students entities.
   * 
   * FK_Students is name the column.
   * FK_Parents is name the column.
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
