package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deloitte.estore.model.Product;

public class ProductRepoImpl implements ProductRepo{

	//Connection con=null;
	@Override
	public boolean addProduct(Product product) throws Exception {

		 SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 Session ssn=sf.openSession();
		 Transaction tx=ssn.beginTransaction();
		 
		 Product p=new Product();
	     p.setProductId(product.getProductId());
	     p.setProductName(product.getProductName());
	     p.setPrice(product.getPrice());
		
		 ssn.save(p);
		 tx.commit();
		 ssn.close(); 
		 return true;
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		 SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 Session ssn=sf.openSession();
		 Transaction tx=ssn.beginTransaction();
		 Product p=new Product();
		 p.setProductId(product.getProductId());
		 ssn.delete(p);
		 
		 tx.commit();
		 ssn.close();
		 
		 return true;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		 SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 Session ssn=sf.openSession();
		 Transaction tx=ssn.beginTransaction();
		 Product p=new Product();
		 p=ssn.get(Product.class, product.getProductId());
		 p.setProductName(product.getProductName());
		 ssn.update(p);
		 tx.commit();
		 ssn.close();
		 return true;
	}

	@Override
	public Product getProductById(int productId) throws Exception {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 Session ssn=sf.openSession();
		 Transaction tx=ssn.beginTransaction();
		 Product p=new Product();
		 p=ssn.get(Product.class, productId);
		 tx.commit();
		 ssn.close();
		 return p;
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 Session ssn=sf.openSession();
		 Transaction tx=ssn.beginTransaction();
		 Product p=new Product();
		 Query q=ssn.createQuery("from Product");
		 List<Product> prod=q.getResultList();
		return prod;
	}

	@Override
	public Connection getDbConnection() throws Exception {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		return con;
	}

}
