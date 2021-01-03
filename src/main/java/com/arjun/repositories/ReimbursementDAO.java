package com.arjun.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arjun.models.Reimbursements;

import com.arjun.util.MyConnectionFactory;

public class ReimbursementDAO {
	
	
	private Statement st;
	private PreparedStatement pst;
	
	private MyConnectionFactory mcf = MyConnectionFactory.getConnectionFactory();
			Connection conn = mcf.getConnection();
			
		
			
			
	// add Reimbursements to data base if success return true else false takes in reimbursement object 		
			public Boolean addReimbursement(Reimbursements reimbursement)  {
				
				Boolean isAdded = false;
				
				String sql = "insert into ers_reimbursement( reimb_amout, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id, reimb_receipt  )"
						+ "values(?,?,?,?,?,?,?) ";
				
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setDouble(1, reimbursement.getReimbAmount());
					pst.setString(2, reimbursement.getReimbDescription());
					pst.setInt(3, reimbursement.getReimbAuthorID());
					pst.setInt(4, reimbursement.getReimbResolverID());
					pst.setInt(5, reimbursement.getReimbStatusID());
					pst.setInt(6, reimbursement.getReimbTypeID());
					pst.setString(7, reimbursement.getImage());
					
					
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
			
			
		// get all the user Reimbursement take is user id and return list of reimbursement 
			
		public List<Reimbursements> getMyReimbursement(int userid) {
				
				
				List<Reimbursements> reimbList = new ArrayList<Reimbursements>();
				try {
				String sql ="";
				if(userid != 0) {
				
				 sql = "select * from ers_reimbursement where reimb_author = ?  ";
				 pst = conn.prepareStatement(sql);
					
					pst.setInt(1, userid);
				
				}
				
				else {
					
					sql = "select * from ers_reimbursement";
					
					pst = conn.prepareStatement(sql);
				}
				
					
					
					ResultSet res = pst.executeQuery();
					while(res.next()) {
						Reimbursements reimbursement = new Reimbursements();
						reimbursement.setReimb_ID(res.getInt(1));
						reimbursement.setReimbAmount(res.getDouble(2));
						reimbursement.setReimbSubmitted(res.getString(3));
						reimbursement.setReimbResolved(res.getString(4));
						reimbursement.setReimbDescription(res.getString(5));
						reimbursement.setImage(res.getString(6));
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
			
			
		
	// this will update the reimbursements status if update successs the returns true else false  takes in reimbursement object 	
			
		public Boolean updateReimbursement(Reimbursements reimbursement) {
				Boolean isDone = false;
				
				String sql = "update ers_reimbursement set reimb_status_id = ?, reimb_resolved = current_timestamp where reimb_id = ?  ";
				
				
				try {
					pst = conn.prepareStatement(sql);
					
					pst.setInt(1, reimbursement.getReimbStatusID());
					pst.setInt(2, reimbursement.getReimb_ID());
					
					
					int result = pst.executeUpdate();
					
					if(result != 0) {
						isDone = true;
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return isDone;
				
			}
			
			
}
