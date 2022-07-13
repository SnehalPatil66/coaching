package com.teamD.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InvoiceDetails 
{
@Id
@GeneratedValue
private int id;


@OneToMany(targetEntity = InvoiceSubject.class,cascade = CascadeType.ALL)
@JoinColumn(referencedColumnName = "id")
private List<InvoiceSubject> subjectName;

private double totalAmount;

	
}
