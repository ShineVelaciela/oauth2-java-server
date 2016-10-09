package com.sanfei.oauth2;

import org.apache.catalina.User;

import com.datapromise.common.SqlMapWrapper;

public class PasswordValidator {

	public static boolean Validate(String username, String password)
	{
		
		User user = (User)SqlMapWrapper.queryForObject("getUser", username);
		
		if(user.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}					 
	}

}
