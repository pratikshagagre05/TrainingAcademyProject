package com.model;

public class Student {
	int studId;
	String studName;
	long mobNo;
	String gmail;
	int  batchId;
	

	public Student()
	{
		
	}

	public Student(int studId, String studName, long mobNo, String gmail, int batchId) 
	{
		this.studId = studId;
		this.studName = studName;
		this.mobNo = mobNo;
		this.gmail = gmail;
		this.batchId = batchId;
		
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	

	@Override
	public String toString() {
		return "[stud_id=" + studId + ", stud_name=" + studName + ", mob_no=" + mobNo + ", gmail=" + gmail
				+ ", batch_id=" + batchId + "]";
	}
	
	
	
}
