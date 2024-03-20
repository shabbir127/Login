package com.java.servlet;

import java.io.IOException;

import com.java.conn.DBConnect;
import com.java.dao.TrainingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		int trainingID=Integer.parseInt(req.getParameter("trainingID"));
		TrainingDAO dao=new TrainingDAO(DBConnect.getConn());
		try {
			boolean f=dao.deleteTraining(trainingID);
			HttpSession session=req.getSession();
			if (f) {
				
				session.setAttribute("succMsg","student Detail submit sucessfully...");
				resp.sendRedirect("index.jsp");
				
			}else {
				session.setAttribute("errorMsg","student Detail not submitted");
				resp.sendRedirect("index.jsp");
				
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}
        
		
	}
	
	

}
