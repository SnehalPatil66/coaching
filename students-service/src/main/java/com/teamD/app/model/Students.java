package com.teamD.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {
@Id
@GeneratedValue
	private int studentId;
@Column
	private String studentName;

	private int mobileNumber;
	
	private String email;
	
	private String gender;
}
