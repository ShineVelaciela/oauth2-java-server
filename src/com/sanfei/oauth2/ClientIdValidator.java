package com.sanfei.oauth2;

import com.datapromise.common.SqlMapWrapper;
import com.sanfei.oauth2.service.Client;

public class ClientIdValidator {
	
	public static boolean Validate(String client_id)
	{
		Client client = (Client)SqlMapWrapper.queryForObject("getClient", client_id);
		
		if(client != null)
		{
			return true;
		}
		else
		{
			return false;
		}					 
	}


}
