package com.teamD.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Coaching {
 @Id
 private int id;

 private String coachingName;
   
 @OneToMany(targetEntity = StudentDetails.class,cascade = CascadeType.ALL)
 @JoinColumn(referencedColumnName = "id")
private List<StudentDetails> courseList;

}
