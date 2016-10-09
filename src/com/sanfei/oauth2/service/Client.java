package com.sanfei.oauth2.service;

import com.datapromise.common.SqlMapWrapper;

public class Client {
	
	
	private long id;
	private String client_id;
	private String client_secret;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public static void addClient(Client client)
	{
		SqlMapWrapper.insert("insertClient",  client);
	}

}
