package com.sanfei.oauth2.service;

import com.datapromise.common.SqlMapWrapper;

public class User {
	
	
	private long uid;
	private String username;
	private String password;
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
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

	
	public static void addUser(User user)
	{
		SqlMapWrapper.insert("insertUser", user);
	}

}
