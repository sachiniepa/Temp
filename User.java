package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("userId")
	private Long userId;
	private String username;
	private String password;
	private String name;
	private String college;
	@JsonProperty("is_edited")
	private boolean isEdited;
	@JsonProperty("isDeleted")
	private boolean isDeleted;
	@JsonProperty("userTypeId")
	private int userTypeId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(String username) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public boolean isEdited() {
		return isEdited;
	}
	public void setEdited(boolean isEdited) {
		this.isEdited = isEdited;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	
}
