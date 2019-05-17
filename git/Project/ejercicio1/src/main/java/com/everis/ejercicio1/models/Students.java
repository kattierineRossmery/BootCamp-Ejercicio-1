package com.everis.ejercicio1.models;
 
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Esta clase pertenece a la entidad Students.
 * @author kvilcave
 * @version 15-05-2019 v1
 */
@ApiModel("Model Students")
@Entity
@Data
@Table(name = "Students")
public class Students {

  @Id
  @NotNull
  @ApiModelProperty(value = "the student's id", required = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id")
  private int studentId;

  @NotBlank
  @ApiModelProperty(value = "the gender", required = true)
  private String gender;

  @NotBlank
  @ApiModelProperty(value = "the student first name", required = true)
  @Size(min=3, message = "Primer nombre debe tener minimo 3 caracteres")
  @Column(name = "first_name")
  private String firstName;

  @ApiModelProperty(value = "the student middle name", required = true)
  @Size(min=3, message = "Segundo nombre debe tener minimo 3 caracteres")
  @Column(name = "middle_name")
  private String middleName;

  @NotNull
  @ApiModelProperty(value = "the student's last name", required = true)
  @Size(min=3, message = "Apellido debe tener minimo 3 caracteres")
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Past
  @Temporal(TemporalType.DATE)
  @ApiModelProperty(value = "the student's date of birth", required = true)
  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @ApiModelProperty(value = "the student's details", required = true)
  @Column(name = "other_student_details")
  private String otherStudentDetails;

  /**
   * La entidad Students esta en relacion Uno a muchos a la entidad FamilyMembers.
   * students es referenciado en la entidad FamilyMembers
   */
  @JsonIgnore
  @OneToMany(mappedBy = "students")
  private List<FamilyMembers> listaFamilyMembers;

  /**
   * La entidad Students está en relación muchos a muchos con la entidad Parents.
   * estudiantes es referenciado en la entidad Parents.
   */
  @JsonIgnore
  @ManyToMany(mappedBy = "estudiantes")
  private List<Parents> parentss;

}
