package com.teamD.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject
{
@Id
private int id;

private String subjectName;

private double SubjectFess;

private String subjectDuration;

}
