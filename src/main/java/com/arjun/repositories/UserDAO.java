package com.arjun.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.arjun.models.Users;
import com.arjun.util.MyConnectionFactory;

public class UserDAO {
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
			
			// this method chekes if the user user name and password are valid or not 
			// if valid returns true else false
			
			public Boolean checkLogin(String uname, String upass) {
				
				Boolean isRight = false;
				//int uid = -1; // login is not successfull 
						
				try {
					String sql =  "select * from ers_users " + 
							 "where ers_username = ? and ers_password = ?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, uname);
					pst.setString(2, upass);
								
					ResultSet res = pst.executeQuery();
								
					if(res.next()) {
						isRight = true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					return isRight;
			}
			
			
			
	// this method get the all the user details on the basis of username and password
			
			public Users getUser(String uname, String upass) throws SQLException {
				Users user = new Users();	
				
				String sql =  "select * from ers_users " + 
						 "where ers_username = ? and ers_password = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, uname);
				pst.setString(2, upass);
							
				ResultSet res = pst.executeQuery();
				
				if(res.next()) {
					
					user.setUser_ID(res.getInt(1));
					user.setUserName(res.getString(2));
					user.setFirstName(res.getString(4));
					user.setLastName(res.getString(5));
					user.setEmail(res.getString(6));
					user.setRoleID(res.getInt(7));
					
					
				}
				
				return user;
				
				
			}
	
	

}
