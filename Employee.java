    
package com.deloitee.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance                                                //....used for table per hierarchy
// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)    ....used for table per class inheritance and will give as many tables as are classes i.e 2 tables
// @Inheritance(strategy=InheritanceType.JOINED)             ....used for table with joined strategy and gives 3 tables,1 for mapping and the other 2 for classes
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
