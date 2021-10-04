package com.demo.book.entity;

import lombok.Data;

public class CategoryErrorResponse {
	
    private int status;
	
	private String message;
	
	private long timeStamp;
	

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}


}
