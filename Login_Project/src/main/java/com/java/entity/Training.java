package com.java.entity;

public class Training {
	
	private int trainingID;
	private String TrainingName; 
	private String StartDate; 
	private String EndDate;
	private String TrainingMode; 
	private String BusinisessUnit;
	private String ContactpersonID;
	
	public int getTrainingID() {
		return trainingID;
	}
	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
	public String getTrainingName() {
		return TrainingName;
	}
	public void setTrainingName(String trainingName) {
		TrainingName = trainingName;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getTrainingMode() {
		return TrainingMode;
	}
	public void setTrainingMode(String trainingMode) {
		TrainingMode = trainingMode;
	}
	public String getBusinisessUnit() {
		return BusinisessUnit;
	}
	public void setBusinisessUnit(String businisessUnit) {
		BusinisessUnit = businisessUnit;
	}
	public String getContactpersonID() {
		return ContactpersonID;
	}
	public void setContactpersonID(String contactpersonID) {
		ContactpersonID = contactpersonID;
	}
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training(String trainingName, String startDate, String endDate, String trainingMode, String businisessUnit,
			String contactpersonID) {
		super();
		TrainingName = trainingName;
		StartDate = startDate;
		EndDate = endDate;
		TrainingMode = trainingMode;
		BusinisessUnit = businisessUnit;
		ContactpersonID = contactpersonID;
	}
	public Training(int trainingID, String trainingName, String startDate, String endDate, String trainingMode,
			String businisessUnit, String contactpersonID) {
		super();
		this.trainingID = trainingID;
		TrainingName = trainingName;
		StartDate = startDate;
		EndDate = endDate;
		TrainingMode = trainingMode;
		BusinisessUnit = businisessUnit;
		ContactpersonID = contactpersonID;
	}
	
	
	
	
	
	
	
	
	

}
