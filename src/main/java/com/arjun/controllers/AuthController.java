package com.arjun.controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjun.models.Users;
import com.arjun.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthController {
	
	
	private ObjectMapper obj = new ObjectMapper();
	
	private UserServices userServices = new UserServices();
	
	
	
	public void userLogin(HttpServletRequest request, HttpServletResponse responce) throws IOException, SQLException {
		
		Users user = obj.readValue(request.getInputStream(), Users.class);
		
		
		
		Users newUser = userServices.userLogin(user.getUserName(), user.getUserPassword());
		
		HttpSession sess = request.getSession();
		
		
		
		if(newUser.getUser_ID() == 0) {
			responce.getWriter().write("User Can not found");
		}
		else {
			
			sess.setAttribute("UserRoal", newUser.getRoleID());
			responce.getWriter().write(obj.writeValueAsString(newUser));
		}
		
		
	}

}
