package com.arjun.services;


import com.arjun.models.Reimbursements;
import com.arjun.repositories.ReimbursementDAO;

public class FinanceOfficerServices {

 private ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
	
	public boolean updateReimbursement(Reimbursements reimbursements) {
		
		Boolean isUpdated = false; 
				
		   isUpdated = reimbursementDAO.updateReimbursement(reimbursements);		
				
		return isUpdated;
		
		
	}
	
	
}
