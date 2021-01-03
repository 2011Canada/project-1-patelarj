package com.arjun.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjun.models.Reimbursements;
import com.arjun.models.Users;
import com.arjun.services.FinanceOfficerServices;
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
		
		
		Users user = obj.readValue(request.getInputStream(), Users.class);
		
		
		
		
		if(user.getRoleID()== 1) {
		
		List<Reimbursements> reimbList = userService.getAllReimb(user.getUser_ID());
		
		if(reimbList.isEmpty()) {
			response.getWriter().write("you do not have any application ");
		}
		else {
			
		
			
			
			String reimblist = obj.writeValueAsString(reimbList);
				System.out.println(reimblist);
				response.getWriter().write(reimblist);
			
			
		}
		}
		else {
			
			
			List<Reimbursements> reimbList = userService.getAllReimb(0);
			
			if(reimbList.isEmpty()) {
				response.getWriter().write("you do not have any application ");
			}
			else {
				
			
				
				
				String reimblist = obj.writeValueAsString(reimbList);
					System.out.println(reimblist);
					response.getWriter().write(reimblist);
				
				
			}
			
			
		}
		
		
		
		
	}
	
	
	public void updateReimb(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		Reimbursements reimbursements = obj.readValue(request.getInputStream(), Reimbursements.class);
		
		System.out.println(reimbursements.getReimb_ID());
		
		FinanceOfficerServices financeOfficerServices = new FinanceOfficerServices();
		if(financeOfficerServices.updateReimbursement(reimbursements)) {
			response.getWriter().write("Status has been chaged");
			System.out.println("upeated");
		}
		
		
	}
	
	
	
}
