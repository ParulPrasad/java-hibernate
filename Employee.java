package com.deloitee.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
@DiscriminatorColumn(name="Job_Role")
public class Employee {
 @Id
 private int empId;
 private String empName;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
 public Employee() {
	// TODO Auto-generated constructor stub
}
public Employee(int empId, String empName) {
	super();
	this.empId = empId;
	this.empName = empName;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + "]";
}
 
}
