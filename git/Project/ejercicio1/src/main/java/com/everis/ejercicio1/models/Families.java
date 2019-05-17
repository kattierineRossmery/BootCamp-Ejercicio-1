package com.everis.ejercicio1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Esta clase pertenece a la entidad Families.
 * @version 15-05-2019 V1
 * @author Kattierine Vilca - kvilcave
 *
 */
@ApiModel("Model Families")
@Entity
@Data
@Table(name = "Families")
public class Families {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "the family member id", required = true)
  @Column(name = "family_id")
  private int familyId;

  @NotNull
  @ApiModelProperty(value = "the family member name", required = true)
  @Column(name = "family_name")
  private String familyName;

  /**
   * La entidad Families esta en relacion Many to One con la entidad Parents.
   * "parentsss" con el nombre de la columna "head_of_family_parent_id" es referenciado
   * al id(parent_id) de la entidad Parents.
   */
  @NotNull
  @ApiModelProperty(value = "the family member parent id", required = true)
  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id")
  private Parents parentsss;

  /**
   * La entidad Families esta en relacion One to Many con la entidad FamilyMembers.
   * "families" referencia a la entidad FamilyMembers.
   */
  @JsonIgnore
  @OneToMany(mappedBy = "families")
  private List<FamilyMembers> listaFamilyMembers;

}
