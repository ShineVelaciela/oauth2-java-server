package com.sanfei.oauth2;

import com.datapromise.common.SqlMapWrapper;
import com.sanfei.oauth2.service.AccessToken;

public class AccessTokenValidator {
	
	public static boolean Validate(String access_token)
	{
		AccessToken at = (AccessToken)SqlMapWrapper.queryForObject("getAccessTokenByaccess_token", access_token);
				
		if(at != null)
		{
			return true;
		}
		else
		{
			return false;
		}					 
	}

}
