package com.arjun.services;


import com.arjun.models.Reimbursements;
import com.arjun.models.Users;
import com.arjun.repositories.ReimbursementDAO;
import com.arjun.repositories.UserDAO;

public class FinanceOfficerServices {

 private ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
 
 private UserDAO userDAO = new UserDAO();
	
 
 
 // this will update the status of the reimbursements by calling DAO methods returs true if success else false 
	public boolean updateReimbursement(Reimbursements reimbursements) {
		
		Boolean isUpdated = false; 
				
		   isUpdated = reimbursementDAO.updateReimbursement(reimbursements);		
				
		return isUpdated;
		
		
	}
	
// checks if user is unique 	
	
	private boolean isUserIsUnique(Users user) {
		boolean isUnique = false;
		
		if(userDAO.isUserUnique(user)) {
			if(userDAO.addUser(user)) {
			isUnique = true;
			}
		}
		
		System.out.println("is user unique" + isUnique );
		return isUnique;
		
	}
	
// add new user if true success else false 
	
	public boolean addUserSuccess(Users user) {
		boolean success = false;
		
		if(isUserIsUnique(user)) {
			
			
			success = true;
			
		}
		
		System.out.println("add user" + success);
		return success;
		
	}
	
	
	
	
}
