package com.deloitte.estore.application;
import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

public class DeloitteEStoreApp {

	public static void main(String[] args) {
		ProductService service=new ProductServiceImpl();
		Product p=new Product();
		System.out.println("1->Add Product\n2->Delete Product\n3->Update Product\n4->Get Prod By ID\n5->Get All Prod");
		Scanner in=new Scanner(System.in);
		int c=in.nextInt();
		switch(c) {
		case 1:{
		try {
			System.out.println("enter product_id,product_name,price:");
			int r=in.nextInt();
			String str=in.next();
			float pr=in.nextFloat();
			p.setProductId(r);
			p.setProductName(str);
			p.setPrice(pr);
			if(service.addProduct(p))
				System.out.println("product added...");
			else
				System.out.println("not added...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		break;
		}
		case 2:{
		System.out.println("enter product_id to be deleted:");
		int r=in.nextInt();
		p.setProductId(r);
		try {
			if(service.deleteProduct(p))
				System.out.println("deleted...");
			else
				System.out.println("not deleted...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		break;
		}
		case 3:{
			try {
				System.out.println("enter product_id:");
				int r=in.nextInt();
				System.out.println("enter new product_name:");
				String str=in.next();
				p.setProductName(str);
				p.setProductId(r);
				if(service.updateProduct(p))
					System.out.println("updated...");
				else
					System.out.println("not updated...");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}
		case 4:{
			try {
				System.out.println("enter product_id:");
				int r=in.nextInt();
				Product rslt=service.getProductById(r);
				System.out.println("product_name:"+rslt.getProductName()+" price:"+rslt.getPrice());
				
			}
			catch(Exception e){e.printStackTrace();}
			break;
		}
		case 5:{
			try {
				List<Product> pList=new ArrayList<>();
				pList=service.getAllProducts();
				//System.out.println(pList);
				pList.forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}
		default:System.out.println("invalid input");
		}

	}

}
