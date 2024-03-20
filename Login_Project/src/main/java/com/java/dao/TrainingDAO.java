package com.java.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.Training;

import jakarta.servlet.ServletException;



public class TrainingDAO {
	
	private Connection conn;
	
	public TrainingDAO(Connection conn)
	{    super();
		this.conn=conn;
	}
	
	
	public boolean addTraining(Training training) throws SQLException
	{
		boolean f=false;
		try {
			String sql="insert into training(TrainingName,StartDate,EndDate,TrainingMode,BusinisessUnit,ContactpersonID) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, training.getTrainingName());
			ps.setString(2, training.getStartDate());
			ps.setString(3,training.getEndDate() );
			ps.setString(4,training.getTrainingMode() );
			ps.setString(5,training.getBusinisessUnit() );
			ps.setString(6,training.getContactpersonID() );
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		return f;
	}
	
	
	public List<Training> getAllTraining() throws SQLException
	{
		List<Training>list=new ArrayList<Training>();
		Training t=null;
		try {
			String sql="select * from training ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				t=new Training();
				t.setTrainingID(rs.getInt(1));
				t.setTrainingName(rs.getString(2));
				t.setStartDate(rs.getString(3));
				t.setEndDate(rs.getString(4));
				t.setTrainingMode(rs.getString(5));
				t.setBusinisessUnit(rs.getString(6));
				t.setContactpersonID(rs.getString(7));
				list.add(t);
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		
		return list;
	}
	
	public Training getTrainingById(int trainingID) throws SQLException
	{
		Training t=null;
		try {
			String sql="select * from training where TrainingID =?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, trainingID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				t=new Training();
				t.setTrainingID(rs.getInt(1));
				t.setTrainingName(rs.getString(2));
				t.setStartDate(rs.getString(3));
				t.setEndDate(rs.getString(4));
				t.setTrainingMode(rs.getString(5));
				t.setBusinisessUnit(rs.getString(6));
				t.setContactpersonID(rs.getString(7));
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		return t;
	}
	
	
	public boolean updateTraining(Training training) throws SQLException , ServletException,IOException
	{
		boolean f=false;
		try {
			String sql="update training set TrainingName=?,StartDate=?,EndDate=?,TrainingMode=?,BusinisessUnit=?,ContactpersonID=? where TrainingID =?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, training.getTrainingName());
			ps.setString(2, training.getStartDate());
			ps.setString(3,training.getEndDate() );
			ps.setString(4,training.getTrainingMode() );
			ps.setString(5,training.getBusinisessUnit() );
			ps.setString(6,training.getContactpersonID() );
			ps.setInt(7, training.getTrainingID());
			int i=ps.executeUpdate();
			
			if (i==1) {
				f=true;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		return f;
	}
	
	
	public boolean deleteTraining(int trainingID) throws SQLException ,IOException
	{
		boolean f=false;
		try {
			String sql="delete from training where trainingID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, trainingID);
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
		} catch (SQLException e) {
			printSQLException(e);
		
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return f;
	}
	

	private void printSQLException(SQLException ex) {
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
	}
	
	
	
	
	
}
