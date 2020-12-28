package com.arjun.controllers;


import java.io.IOException;
import java.net.CookieHandler;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjun.models.Users;
import com.arjun.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthController {
	
	

	
	
	
	public void userLogin(HttpServletRequest request, HttpServletResponse responce) throws IOException, SQLException {
		
		
		ObjectMapper obj = new ObjectMapper();
		 UserServices userServices = new UserServices();
		
		Users user = obj.readValue(request.getInputStream(), Users.class);
		
		
		//System.out.println(user.getUserName());
		
		Users newUser = userServices.userLogin(user.getUserName(), user.getUserPassword());
		//Users newUser = userServices.userLogin(username, password);
		
		HttpSession sess = request.getSession();
		
		sess.setAttribute("userID", newUser.getUser_ID());
		System.out.println(newUser.getUser_ID());
		
		if(newUser.getUser_ID() == 0) {
			responce.getWriter().write("User Can not found");
			
			//responce.sendRedirect("/home.html");
		}
		else {
			
			String userid = String.valueOf(newUser.getUser_ID());
			Cookie one = new Cookie("userID", userid );
			responce.getWriter().write(obj.writeValueAsString(newUser));
			responce.addCookie(one);
			//responce.sendRedirect("./webpage/home.html");
		}
		
		
	}

}
