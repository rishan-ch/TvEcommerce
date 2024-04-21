package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utils.DbConnectivity;

public class UserDAO {
	private Connection conn;
	private PreparedStatement statement;
	private boolean isSuccess;
	private ResultSet resultSet;
	private static final String insert_query = "insert into user "
			+ "(fullName,email,phone,dob,gender,address,password) "
			+ "values(?,?,?,?,?,?,?)";
	
	public UserDAO() {
		conn = DbConnectivity.getDbConnection();
	}
	
	//check conditions an then add user into db
	public boolean addUser(User user) {
		
		String query = "select count(*) from user";
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				
				
				if(checkUser(user)) {
					isSuccess = false;
				}
				else {
					int rows = insertUser(user);
					if(rows>0) {
						isSuccess=true;
					}
				}
				
				
			}
			else {
				int rows = insertUser(user);
				if (rows>0) {//means the data is inserted into database
					isSuccess=true;
				}
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	//method to insert user data into db
	//query is instantiated 
	public int insertUser(User user) throws SQLException{
		
		statement = conn.prepareStatement(insert_query);
		statement.setString(1, user.getFullName());
		statement.setString(2, user.getEmail());
		statement.setLong(3, user.getPhone());
		statement.setDate(4, user.getDob());
		statement.setString(5, user.getGender());
		statement.setString(6, user.getAddress());
		statement.setString(7, user.getPassword());
		
		int rows = statement.executeUpdate();
		
		return rows;
	}
	
	
	//checks if there is an existing user with similar 
	public boolean checkUser(User user) throws SQLException {
		
		boolean isFound = false;
		String query = "select email,phone from user";
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			String emailFromDB = resultSet.getString("email");
			long phoneFromDB = resultSet.getLong("phone");
			
			if(user.getEmail().equals(emailFromDB)) {
				isFound = true;
				break;
			}else if(user.getPhone()==phoneFromDB) {
				isFound = true;
				break;
			}
			
		}
		return isFound;
		
	}
}
