package com.java.servlet;

import java.io.IOException;

import com.java.conn.DBConnect;
import com.java.dao.TrainingDAO;
import com.java.entity.Training;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String TrainingName =req.getParameter("trainingname");
		String StartDate  =req.getParameter("startdate");
		String EndDate  =req.getParameter("enddate");
		String TrainingMode  =req.getParameter("trainingmode");
		String BusinisessUnit  =req.getParameter("businisessunit");
		String ContactpersonID  =req.getParameter("contactpersonid");
		int trainingID=Integer.parseInt(req.getParameter("id"));
		Training training=new Training(trainingID,TrainingName,StartDate,EndDate,TrainingMode,BusinisessUnit,ContactpersonID);
        TrainingDAO trainingDAO=new TrainingDAO(DBConnect.getConn());
        HttpSession session=req.getSession();
		try {
			boolean f=trainingDAO.updateTraining(training);
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
