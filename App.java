package com.deloitee.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deloitte.Prod;
import com.deloitte.Seller;

public class App {
 
	public static void main(String[] args) {
		 SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class).addAnnotatedClass(SysEngg.class)
				 .addAnnotatedClass(DelConsult.class).buildSessionFactory();
		SysEngg se=new SysEngg();
		se.setEmpId(102);
		se.setDevProfile("Web Dev");
		se.setEmpName("manish");
		se.setLang("java");
		
		DelConsult dc=new DelConsult();
		dc.setEmpId(502);
		dc.setTestProfile("Sys Testing");
		dc.setEmpName("rohan");
		dc.setTestTech("Selenium");
		
		Session ssn=sf.openSession();
		Transaction tx=ssn.beginTransaction();
		ssn.save(se);
		ssn.save(dc);
		tx.commit();
		ssn.close();
	}

}
