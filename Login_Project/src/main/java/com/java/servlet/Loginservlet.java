package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Loginservlet extends HttpServlet{

	//  JDBC database URL, user_name, and password
    
	private  String DB_URL = "jdbc:mysql://localhost:3306/login";
    private  String DB_USER = "root";
    private  String DB_PASSWORD = "12345";
	
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    	 // Get user inputs
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        // JDBC variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL query
            String sql = "SELECT usertype FROM User WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            HttpSession session = req.getSession();
            // Execute the query
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Valid login, get user type
                String userType = rs.getString("usertype");

                // Set user type in session for future use
               
                session.setAttribute("userType", userType);
               

                // Redirect to appropriate home page
                if ("A".equals(userType)) {
                	session.setAttribute("Aname", rs.getString(1));
                	
                    resp.sendRedirect("index.jsp");
                } else if ("E".equals(userType)) {
                	session.setAttribute("Ename", rs.getString(1));
                	
                    resp.sendRedirect("employeeHomePage.jsp");
                }
            } else {
                // Invalid login, redirect to error page
            	session.setAttribute("errorMsg", "Invalid Username And Password...");
                resp.sendRedirect("login.jsp");
            }
        } catch (SQLException ex) {
        	
        	for (Throwable e : ex) {
    			if (e instanceof SQLException) {
    				e.printStackTrace(System.err);
    				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
    				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
    				System.err.println("Message: " + e.getMessage());
    				Throwable t = ex.getCause();
    				while (t != null) {
    					System.out.println("Cause: " + t);
    					t = t.getCause();
    				}
    			}
        	}
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("login.jsp");
		}
        
        	
         finally {
            // Close JDBC resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle errors appropriately in a real application
            }
        }
    

    }
}
    
		
	
	
	
	


