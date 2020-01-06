package com.deloitee.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

@DiscriminatorValue("Testing Engg.")
public class DelConsult extends Employee{
//  @Id
//  private int dcId;
  private String testTech;
  private String testProfile;
  public DelConsult() {
	// TODO Auto-generated constructor stub
}
public DelConsult(int dcId, String testTech, String testProfile) {
	super();
//	this.dcId = dcId;
	this.testTech = testTech;
	this.testProfile = testProfile;
}
//public int getDcId() {
//	return dcId;
//}
//public void setDcId(int dcId) {
//	this.dcId = dcId;
//}
public String getTestTech() {
	return testTech;
}
public void setTestTech(String testTech) {
	this.testTech = testTech;
}
public String getTestProfile() {
	return testProfile;
}
public void setTestProfile(String testProfile) {
	this.testProfile = testProfile;
}
@Override
public String toString() {
	return "DelConsult [testTech=" + testTech + ", testProfile=" + testProfile + "]";
}

  
}
