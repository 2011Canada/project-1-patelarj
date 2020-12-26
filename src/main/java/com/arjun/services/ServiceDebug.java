package com.arjun.services;
import java.time.LocalDateTime;    
import java.sql.Date;
import java.sql.SQLException;

import com.arjun.models.Reimbursements;
import com.arjun.models.Users;

public class ServiceDebug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Users user = new Users();
		UserServices userService = new UserServices();
		Reimbursements reimbursement = new Reimbursements();
		
		
		try {
			user = userService.userLogin("AP", "password");
			
			if(user.getUser_ID()== 0) {
				System.out.println("User Can not found");
			}
			else {
				System.out.println(user.getFirstName());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Date date =new Date(2020, 12, 20);
		reimbursement.setReimbAmount(500.0);
		reimbursement.setReimbSubmitted(date);
		reimbursement.setReimbResolved(date);
		reimbursement.setReimbDescription("this is the test");
		reimbursement.setReimbAuthorID(1);
		reimbursement.setReimbResolverID(2);
		reimbursement.setReimbStatusID(1);
		reimbursement.setReimbTypeID(1);
		
		
		Boolean oen = userService.isClaimReimbursment(reimbursement);
		
		System.out.println(oen);
		
		
		
	}

}
