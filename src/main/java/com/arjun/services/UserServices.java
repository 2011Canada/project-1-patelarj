package com.arjun.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arjun.models.Reimbursements;
import com.arjun.models.Users;
import com.arjun.repositories.ReimbursementDAO;
import com.arjun.repositories.UserDAO;

public class UserServices {
	
	private Users user = new Users();
	
	private UserDAO userDAO = new UserDAO();
	
	private ReimbursementDAO reimbDAO = new ReimbursementDAO();
	
	private Reimbursements reimbursements = new Reimbursements();
	
	// this service checkes if user is valid or not if valid user return with the user object 
	
	public Users userLogin(String userName, String passwored) throws SQLException {

		if(userDAO.checkLogin(userName, passwored)){
			
			user = userDAO.getUser(userName, passwored);
			
		}
		
		return user;
	}
	
	
// this will take reimbursement as the argumet is reimbursements is success returns true else false 	
	
	public Boolean isClaimReimbursment(Reimbursements reimbursement) {
		Boolean isClaimed = false;
		
		// TODO 
		if(reimbDAO.addReimbursement(reimbursement)) {
			
			isClaimed = true;
		}
		
		return isClaimed;
	}
	
	
// takes in userid and return list of reimbursement for the perticuler user 
	
	public List<Reimbursements> getAllReimb(int userid){
		
		List<Reimbursements> reimbList = new ArrayList<Reimbursements>();
		
		reimbList = reimbDAO.getMyReimbursement(userid);
		
		
		return reimbList;
		
	}
	

}
