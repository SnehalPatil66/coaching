package com.teamD.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentDetails {
@Id	
 private int studentId;
 private String studentName;
//private List<String> subjectList;
 private double totalFees;
 
 @OneToMany(targetEntity = Subject.class,cascade = CascadeType.ALL)
 @JoinColumn(referencedColumnName = "studentId")
 private List<Subject> subjectList;

 //@ManyToOne
 //private Coaching coaching;
 
}
