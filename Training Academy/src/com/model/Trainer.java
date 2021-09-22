package com.model;

public class Trainer {
	private int trainerId;
	private String trainerName;
	private int batchId;
	
	public Trainer() {}
	public Trainer(int trainerId, String trainerName, int batchId) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.batchId = batchId;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	
	
	

}
