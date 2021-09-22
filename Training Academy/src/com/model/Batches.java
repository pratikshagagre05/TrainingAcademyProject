package com.model;

public class Batches {
	private int batchId;
	private String batchName;
	public Batches()
	{
		
	}
	public Batches(int batchId, String batchName) {
		this.batchId = batchId;
		this.batchName = batchName;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	

}
