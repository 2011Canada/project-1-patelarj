package com.arjun.services;


import com.arjun.models.Reimbursements;
import com.arjun.models.Users;
import com.arjun.repositories.ReimbursementDAO;
import com.arjun.repositories.UserDAO;

public class FinanceOfficerServices {

 private ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
 
 private UserDAO userDAO = new UserDAO();
	
	public boolean updateReimbursement(Reimbursements reimbursements) {
		
		Boolean isUpdated = false; 
				
		   isUpdated = reimbursementDAO.updateReimbursement(reimbursements);		
				
		return isUpdated;
		
		
	}
	
	
	private boolean isUserIsUnique(Users user) {
		boolean isUnique = false;
		
		if(userDAO.isUserUnique(user)) {
			if(userDAO.addUser(user)) {
			isUnique = true;
			}
		}
		
		return isUnique;
		
	}
	
	public boolean addUserSuccess(Users user) {
		boolean success = false;
		
		if(isUserIsUnique(user)) {
			
			
			success = true;
			
		}
		
		return success;
		
	}
	
	
	
	
}
