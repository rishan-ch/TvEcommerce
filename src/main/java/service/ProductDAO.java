package service;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utils.DbConnectivity;

public class ProductDAO {
	
	private Connection conn;
	private PreparedStatement statement;
	//private boolean productAdded;
	private ResultSet resultSet;
	private static final String productInsert = "insert into product "
	        + "(productName, productDescription, screenSize, quantity, brand, price, productImage, productImageName) "
	        + "values (?, ?, ?, ?, ?, ?, ?, ?)";

	public ProductDAO() {
		conn = DbConnectivity.getDbConnection();
	}
	
	//view all product
	public void viewAllProduct() throws SQLException {
		List<Product> productList = new ArrayList();
		String viewQuery = "selecct * from user";
		statement = conn.prepareStatement(viewQuery);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			Product product = new Product();
			//product.setProductName(resultSet.get);
		}
		
	}
	
	
	public boolean addProduct(Product product) throws SQLException {
		
		int rows = insertProduct(product);
		if (rows>0) {
			return true;
		}
		return false;
//		
//		String query = "select count(*) from product";
//		try {
//			statement = conn.prepareStatement(query);
//			resultSet = statement.executeQuery();
//			if(resultSet.next()) {
//				int rows = insertProduct(product);
//				if(rows>0) {
//					productAdded=true;
//				} 
//			}
//			else {
//				
//			}
//				
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return isSuccess;
		
	}
	
	public int insertProduct(Product product) throws SQLException {
		statement = conn.prepareStatement(productInsert);
		
		statement.setString(1, product.getProductName());
		statement.setString(2, product.getProductDescription());
		statement.setString(3, product.getScreenSize());
		statement.setInt(4, product.getQuantity());
		statement.setString(5, product.getBrand());
		statement.setFloat(6, product.getPrice());
		
		Blob blob = conn.createBlob();
		blob.setBytes(1, product.getProductImage());
		statement.setBlob(7, blob); 
		statement.setString(8, product.getProductImageName());
		
		int rows = statement.executeUpdate();
		
		return rows;
		
	}
	

}
