package com.arjun.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arjun.models.Reimbursements;
import com.arjun.models.ReimbursementsTest;
import com.arjun.util.MyConnectionFactory;

public class ReimbursementDAO {
	
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
			
			public Boolean addReimbursement(Reimbursements reimbursement)  {
				
				Boolean isAdded = false;
				
				String sql = "insert into ers_reimbursement( reimb_amout, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id )"
						+ "values(?,?,?,?,?,?) ";
				
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setDouble(1, reimbursement.getReimbAmount());
					pst.setString(2, reimbursement.getReimbDescription());
					pst.setInt(3, reimbursement.getReimbAuthorID());
					pst.setInt(4, reimbursement.getReimbResolverID());
					pst.setInt(5, reimbursement.getReimbStatusID());
					pst.setInt(6, reimbursement.getReimbTypeID());
					
					
					int res = pst.executeUpdate();
					if(res!=0) {
						
						isAdded = true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return isAdded;
				
				
			}
			
			public List<Reimbursements> getMyReimbursement(int userid) {
				
				Reimbursements reimbursement = new Reimbursements();
				List<Reimbursements> reimbList = new ArrayList<Reimbursements>();
				
				String sql = "select * from ers_reimbursement where reimb_author = ?  ";
				
				try {
					pst = conn.prepareStatement(sql);
					
					pst.setInt(1, userid);
					
					ResultSet res = pst.executeQuery();
					while(res.next()) {
						reimbursement.setReimb_ID(res.getInt(1));
						reimbursement.setReimbAmount(res.getDouble(2));
						reimbursement.setReimbSubmitted(res.getDate(3));
						reimbursement.setReimbResolved(res.getDate(4));
						reimbursement.setReimbDescription(res.getString(5));
						reimbursement.setReimbAuthorID(res.getInt(7));
						reimbursement.setReimbResolverID(res.getInt(8));
						reimbursement.setReimbStatusID(res.getInt(9));
						reimbursement.setReimbTypeID(res.getInt(10));
						
						reimbList.add(reimbursement);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return reimbList;
						
				
			}
			
			/*

			public List<ReimbursementsTest> getMyReimbursementTest(int userid){
			
			
				ReimbursementsTest reimbursement = new ReimbursementsTest();
				List<ReimbursementsTest> reimbList = new ArrayList<ReimbursementsTest>();
			
			String sql = "select reimb_id, reimb_amout, reimb_submitted, reimb_resolved, reimb_description, ert.reimb_type ,ers.reimb_status, eu.user_first_name" + 
						 "from ers_reimbursement er inner join ers_users eu on er.reimb_author = eu.ers_users_id" + 
						 "inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id"+ 
						 "inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id "+
						 "where er.reimb_author = ?";
			
			
			try {
				pst = conn.prepareStatement(sql);
				
				pst.setInt(1, userid);
				
				ResultSet res = pst.executeQuery();
				
				while(res.next()) {
					reimbursement.setReimb_ID(res.getInt(1));
					reimbursement.setReimbAmount(res.getDouble(2));
					reimbursement.setReimbSubmitted(res.getDate(3));
					reimbursement.setReimbResolved(res.getDate(4));
					reimbursement.setReimbDescription(res.getString(5));
					reimbursement.setReimbType(res.getString(6));
					reimbursement.setReimbStatus(res.getString(7));					
					reimbursement.setReimbAuthor(res.getString(8));
					reimbList.add(reimbursement);
					
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return  reimbList;
			
			}
			*/
}
