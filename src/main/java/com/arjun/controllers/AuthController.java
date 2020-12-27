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
		
		//String username = request.getParameter("userName");
		//String password = request.getParameter("userPassword");
		
		System.out.println(user.getUserName());
		
		Users newUser = userServices.userLogin(user.getUserName(), user.getUserPassword());
		//Users newUser = userServices.userLogin(username, password);
		
		//HttpSession sess = request.getSession();
		
		
		
		if(newUser.getUser_ID() == 0) {
			responce.getWriter().write("User Can not found");
			
			//responce.sendRedirect("/home.html");
		}
		else {
			
			//sess.setAttribute("UserRoal", newUser.getRoleID());
			//sess.setAttribute("name", newUser.getFirstName());
			responce.getWriter().write(obj.writeValueAsString(newUser));
			//responce.addCookie(cookie);
			//responce.sendRedirect("./webpage/home.html");
		}
		
		
	}

}
