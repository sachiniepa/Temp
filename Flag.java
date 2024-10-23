package com.example.demo;

public class Flag {
	
	private int flagId;
    private int feedbackId;
    private int userId;
    private String flagReason;
    private String status;
    
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFlagReason() {
		return flagReason;
	}
	public void setFlagReason(String flagReason) {
		this.flagReason = flagReason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
