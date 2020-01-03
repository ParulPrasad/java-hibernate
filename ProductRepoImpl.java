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

import com.deloitte.estore.model.Product;

public class ProductRepoImpl implements ProductRepo{

	Connection con=null;
	@Override
	public boolean addProduct(Product product) throws Exception {
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?)");
		ps.setInt(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setFloat(3, product.getPrice());
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("delete from product where product_id=?");
		ps.setInt(1,product.getProductId());
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("update product set product_name=? where product_id=?");
		ps.setString(1, product.getProductName());
		ps.setInt(2, product.getProductId());
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}

	@Override
	public Product getProductById(int productId) throws Exception {
		Connection con=getDbConnection();
		Statement st=con.createStatement();
	
		ResultSet rs=st.executeQuery("select product_id,product_name,price from product where product_id="+productId);
	    Product prod=new Product();
	    if(rs.next()) {
	    prod.setProductId(rs.getInt(1));
	    prod.setProductName(rs.getString(2));
	    prod.setPrice(rs.getFloat(3));
	    return prod;
	    }
	    return null;
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		Connection con=getDbConnection();
		PreparedStatement pst=con.prepareStatement("select * from product");
		ResultSet rs=pst.executeQuery();
		List<Product> prodList=new ArrayList<>();
		while(rs.next())
		{
			Product p=new Product();
			p.setProductId(rs.getInt("product_id"));
			p.setProductName(rs.getString("product_name"));
			p.setPrice(rs.getFloat("price"));
			prodList.add(p);
		}
		
		
		return prodList;
	}

	@Override
	public Connection getDbConnection() throws Exception {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		return con;
	}

}
