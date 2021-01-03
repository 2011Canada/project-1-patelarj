package com.arjun.controllers;


import java.io.IOException;
import java.net.CookieHandler;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjun.models.Users;
import com.arjun.services.FinanceOfficerServices;
import com.arjun.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthController {
	
	

	
	
	
	public void userLogin(HttpServletRequest request, HttpServletResponse responce) throws IOException, SQLException {
		
		
		ObjectMapper obj = new ObjectMapper();
		 UserServices userServices = new UserServices();
		
		Users user = obj.readValue(request.getInputStream(), Users.class);
		
		
		
		
		Users newUser = userServices.userLogin(user.getUserName(), user.getUserPassword());
		
		System.out.println(newUser.getUser_ID());
		
		if(newUser.getUser_ID() == 0) {
			responce.getWriter().write("User Can not found");
			
			
		}
		else {
			
			
			responce.getWriter().write(obj.writeValueAsString(newUser));
			
		}
		
		
	}
	
	public void addUser(HttpServletRequest request, HttpServletResponse responce) {
		ObjectMapper obj = new ObjectMapper();
		FinanceOfficerServices financeOfficerServices = new FinanceOfficerServices();
		
		
			Users user;
			try {
				user = obj.readValue(request.getInputStream(), Users.class);
				
				System.out.println(user.getFirstName());
				
				if(financeOfficerServices.addUserSuccess(user)) {
					
					String conf = "User added";
					responce.getWriter().write(obj.writeValueAsString(conf));
					System.out.println("user added");
				}
				else {
					
					String conf = "User Can not added Please enter valid inpu";
					responce.getWriter().write(obj.writeValueAsString(conf));
					System.out.println("not add");
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
		
		
	}
	
	

}
