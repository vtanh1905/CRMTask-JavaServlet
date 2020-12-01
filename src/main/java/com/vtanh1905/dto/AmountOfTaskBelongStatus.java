package com.vtanh1905.dto;

public class AmountOfTaskBelongStatus {
	private int status_id;
	private int amount;
	
	public AmountOfTaskBelongStatus(int status_id, int amount) {
		super();
		this.status_id = status_id;
		this.amount = amount;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
}
