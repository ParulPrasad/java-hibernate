package com.deloitte.estore.application;
import java.util.*;
  

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.omg.Messaging.SyncScopeHelper;


import com.deloitte.estore.model.Product;
import com.deloitte.estore.repo.ProductRepoImpl;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

public class DeloitteEStoreApp {

	public static void main(String[] args) throws Exception {
		
		 //SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 //Product product=new Product(1265,"tv",50000);
		 //Session ssn=sf.openSession();
         //Transaction tx=ssn.beginTransaction();
       //  Product product=ssn.get(Product.class,9 );
       //  System.out.println(product);
        // Query q=ssn.createQuery("from Product");
        // List<Product> prod=q.getResultList();
         //prod.forEach(System.out::println);
         //tx.commit();
		 //ssn.close();
		ProductRepoImpl repo=new ProductRepoImpl();
		Product p=new Product(1,"xy",400);
		System.out.println("1->Add Product\n2->Delete Product\n3->Update Product\n4->Get Prod By ID\n5->Get All Prod");
		Scanner in=new Scanner(System.in);
		int c=in.nextInt();
		switch(c) {
		case 1:{
		p=new Product(10,"cpu",4000);
		if(repo.addProduct(p))
			System.out.println("done");
		else
			System.out.println("not done");
		break;
		}	
		case 2:{
		   p.setProductId(10);
		   if(repo.deleteProduct(p))
			   System.out.println("deleted");
		   else
			   System.out.println("not deleted");
		   break;
		}
		case 3:{
			p.setProductId(9);
			p.setProductName("Mobile");
			if(repo.updateProduct(p))
				System.out.println("updated");
			else
				System.out.println("not updated");
			break;
		}
		case 4:{
			p=repo.getProductById(9);
				System.out.println(p);
				break;
		}
		case 5:{
			System.out.println(repo.getAllProducts());
		}
		}
	}

}
