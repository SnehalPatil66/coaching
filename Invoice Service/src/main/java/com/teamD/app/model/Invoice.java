package com.teamD.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice 
{

private int invoiceId;

private String studentName;

private String subjectName;

private double fees;

}
