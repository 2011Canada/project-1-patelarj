package com.arjun.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arjun.controllers.AuthController;
import com.arjun.controllers.ReimbController;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	private AuthController authController = new AuthController();
	
	private ReimbController reimbController = new ReimbController();
	
	protected void mainServletController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String URI = request.getRequestURI().substring(request.getContextPath().length(), 
				request.getRequestURI().length());
		System.out.println(URI);
		if(URI.equals("/login") ) 
			{
				switch (request.getMethod()) {
					case "GET":{
						
						response.setStatus(400);
						response.getWriter().write("Method Not Supported");
						
						break;
					}
					case "POST":{
						
						System.out.println("reached to post");
						try {
							authController.userLogin(request, response);
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case "PUT":{
					
						response.setStatus(400);
						response.getWriter().write("Method Not Supported");
						
						break;
					}
					case "DELETE":{
						response.setStatus(400);
						response.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						response.setStatus(400);
						response.getWriter().write("Method Not Supported");
						break;
					}
				
			}
	
				
				
			
			}
		else if(URI.equals("/home") ) 
		{
			switch (request.getMethod()) {
				case "GET":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					
					
					break;
				}
				case "POST":{
					try {
						
						
						System.out.println("reached to the home post");
						reimbController.getAllReimbursement(request, response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case "PUT":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					
					break;
				}
				case "DELETE":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
			
		}

			
			
		
		}
		else if(URI.equals("/add") ) 
		{
			switch (request.getMethod()) {
				case "GET":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					
					
					break;
				}
				case "POST":{
					try {
						
						System.out.println("reached to the post");
						
						try {
							reimbController.addReimbursement(request, response);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case "PUT":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
			
		}

			
			
		
		}
		
		else if(URI.equals("/status") ) 
		{
			switch (request.getMethod()) {
				case "GET":{
					
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					
					
					break;
				}
				case "POST":{
					try {
						
						System.out.println("reached to the post");
						
						reimbController.updateReimb(request, response);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case "PUT":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
			
		}

			
			
		
		}
		
		
		else if(URI.equals("/adduser") ) 
		{
			switch (request.getMethod()) {
				case "GET":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					
					
					break;
				}
				case "POST":{
					
					System.out.println("reached to the add user post");
					
					authController.addUser(request, response);
					break;
				}
				case "PUT":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					response.setStatus(400);
					response.getWriter().write("Method Not Supported");
					break;
				}
			
		}

			
			
		
		}
		
		
		
	}
	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mainServletController(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		mainServletController(request, response);
	}

}
