package com.everis.ejercicio1.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * This class belongs to the entity FamilyMembers.
 * @version 15-05-2019 v1
 * @author kvilcave
 *
 */
@Entity
@Getter
@Setter
@ApiModel("Model Family")
@Table(name = "FamilyMembers")
public class FamilyMembers {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "the family's id", required = true)
  @Column(name = "family_member_id")
  private int familyMemberId;

  @ApiModelProperty(value = "Parent or student", required = true)
  @Column(name = "parent_or_student_members")
  private String parentOrStudentMembers;

  /**
   * The entity FamilyMembers is relation Many to One to the entity Families.
   * "families" is referenced to the id(familyId) of entity Families.
   */
  @ManyToOne
  @ApiModelProperty(value = "the family's id", required = true)
  @JoinColumn(name = "family_id")
  private Families families;

  /**
   * The entity FamilyMembers is relation Many to One to the entity Parents.
   * "parents" is referenced to the id(parentId) in the entity Parents.
   */
  @ManyToOne
  @ApiModelProperty(value = "the parent's id", required = true)
  @JoinColumn(name = "parent_id")
  private Parents parents;

  /**
   * The entity FamilyMembers is relation Many to One to the entity Students.
   * "students" is referenced to the id(studentId) in the entity Students.
   */
  @ManyToOne
  @ApiModelProperty(value = "the student's id", required = true)
  @JoinColumn(name = "student_id")
  private Students students;

}
