package com.sanfei.oauth2;

import com.datapromise.common.SqlMapWrapper;
import com.sanfei.oauth2.service.AccessToken;

public class RefreshTokenValidator {
	

	public static boolean Validate(String refresh_token)
	{
		AccessToken at =(AccessToken)SqlMapWrapper.queryForObject("getAccessTokenByrefresh_token", refresh_token);
		
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
