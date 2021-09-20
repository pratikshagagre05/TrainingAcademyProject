package com.model;

public class Result {
	private int studId;
	private int test1;
	private int test2;
	private int test3;
	private int totalMarks;
	private int percent;
	
	
	
	public Result(int studId, int test1, int test2, int test3, int totalMarks, int percent) 
	{
		this.studId = studId;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
		this.totalMarks = totalMarks;
		this.percent = percent;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public int getTest1() {
		return test1;
	}
	public void setTest1(int test1) {
		this.test1 = test1;
	}
	public int getTest2() {
		return test2;
	}
	public void setTest2(int test2) {
		this.test2 = test2;
	}
	public int getTest3() {
		return test3;
	}
	public void setTest3(int test3) {
		this.test3 = test3;
	}
	@Override
	public String toString() {
		return "Student Id=" + studId + ", Test1=" + test1 + ", Test2=" + test2 + ", Test3=" + test3
				+ ", Total Marks=" + totalMarks + ", Percentage=" + percent + "]";
	}
	
	
	
	

}
