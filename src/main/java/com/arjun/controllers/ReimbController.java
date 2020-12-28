package com.arjun.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjun.models.Reimbursements;
import com.arjun.models.Users;
import com.arjun.services.UserServices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbController {

	private ObjectMapper obj = new ObjectMapper();
	
	private UserServices userService = new UserServices();
	
	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		
		
			Reimbursements reimbursements = obj.readValue(request.getInputStream(), Reimbursements.class);
			
		
		
			if(userService.isClaimReimbursment(reimbursements)) {
				
				response.getWriter().write("your claim is added");
				
			}
			else {
				
				response.getWriter().write("your claim is added please try again");
			}
			
			
		
		
	}
	
	public void getAllReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//HttpSession sess = request.getSession();
		Users user = obj.readValue(request.getInputStream(), Users.class);
		//int one = (int) sess.getAttribute("userID");
		System.out.println(user.getUser_ID());
		List<Reimbursements> reimbList = userService.getAllReimb(user.getUser_ID());
		
		if(reimbList.isEmpty()) {
			response.getWriter().write("you do not have any application ");
		}
		else {
			
		//	for(int i = 0; i<reimbList.size(); i++ ) {
			
			
			String reimblist = obj.writeValueAsString(reimbList);
				System.out.println(reimblist);
				response.getWriter().write(reimblist);
			//}
			
		}
		
		
		
		
		
	}
	
	
}
