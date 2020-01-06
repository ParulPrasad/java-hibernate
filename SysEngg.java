package com.deloitee.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

@DiscriminatorValue("System Engg.")
public class SysEngg extends Employee {
//	@Id
//	private int seId;
	private String lang;
	private String devProfile;
	
	public SysEngg() {
		// TODO Auto-generated constructor stub
	}

	public SysEngg(int seId, String lang, String devProfile) {
		super();
//		this.seId = seId;
		this.lang = lang;
		this.devProfile = devProfile;
	}

//	public int getSeId() {
//		return seId;
//	}

//	public void setSeId(int seId) {
//		this.seId = seId;
//	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getDevProfile() {
		return devProfile;
	}

	public void setDevProfile(String devProfile) {
		this.devProfile = devProfile;
	}

	@Override
	public String toString() {
		return "SysEngg [lang=" + lang + ", devProfile=" + devProfile + "]";
	}
	
	

}
