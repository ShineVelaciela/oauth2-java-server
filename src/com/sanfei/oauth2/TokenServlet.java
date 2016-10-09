package com.sanfei.oauth2;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanfei.oauth2.service.AccessToken;

/**
 * Servlet implementation class TokenServlet
 */
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TokenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		
		String response_type = request.getParameter("response_type");				
		if (response_type.equals("token"))
		{	
			response.getWriter().println("暂不支持Implicit方式");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		// TODO Filter Authorization: Basic base64(appkey:appsecret)		
		
		String grant_type = request.getParameter("grant_type");	
		
		if (grant_type.equals("authorization_code"))
		{			
			response.getWriter().println("暂不支持Authorization Code方式");			
			return ;
		}
		
		if (grant_type.equals("password"))
		{
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String client_id = request.getParameter("client_id");
			
			if (PasswordValidator.Validate(username, password) && ClientIdValidator.Validate(client_id));
			{
				String access_token = UUID.randomUUID().toString();
				String refresh_token = UUID.randomUUID().toString();
				// INSERT INTO access_token VALUES(access_token="", refresh_token="", username="", client_id="");
				
				AccessToken at = new AccessToken();
				at.setAccess_token(access_token);
				at.setRefresh_token(refresh_token);
				at.setUsername(username);
				at.setClient_id(client_id);
				AccessToken.addAccessToken(at);				
				
				response.addHeader("Content-Type", "application/json;charset=UTF-8");
				response.addHeader("Cache-Control", "no-store");
				response.addHeader("Pragma", "no-cache");
				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"access_token\":");
				sb.append("\"" + access_token + "\"");
				sb.append(",\"token_type\":");			
				sb.append(",\"expires_in\":");
				sb.append(3600);			
				sb.append(",\"refresh_token\":");
				sb.append("\"" + refresh_token + "\"");
				sb.append(",\"username\":");
				sb.append("\""+ username + "\"");
				sb.append(",\"client_id\":");
				sb.append("\" "+ client_id + "\"");
				sb.append("}");
				response.getWriter().println(sb.toString());			
				return ;
			}

		}
		
		if (grant_type.equals("client_credentials"))
		{	
			response.getWriter().println("暂不支持Client Credentials方式");			
			return ;
		}
		
		if (grant_type.equals("refresh_token"))
		{	
			String username = request.getParameter("username");
			String refresh_token = request.getParameter("refresh_token");
			String client_id = request.getParameter("client_id");									
			
			if(RefreshTokenValidator.Validate(refresh_token) && ClientIdValidator.Validate(client_id))
			{
				String access_token = UUID.randomUUID().toString();
				String refresh_token2 = UUID.randomUUID().toString();
				// INSERT INTO access_token VALUES(access_token="", refresh_token="", username="", client_id="");			
				
				AccessToken at = new AccessToken();
				at.setAccess_token(access_token);
				at.setRefresh_token(refresh_token2);
				at.setUsername(username);
				at.setClient_id(client_id);
				AccessToken.addAccessToken(at);	
				
				response.addHeader("Content-Type", "application/json;charset=UTF-8");
				response.addHeader("Cache-Control", "no-store");
				response.addHeader("Pragma", "no-cache");
				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"access_token\":");
				sb.append("\"" + access_token + "\"");
				sb.append(",\"token_type\":");			
				sb.append(",\"expires_in\":");
				sb.append(3600);			
				sb.append(",\"refresh_token\":");
				sb.append("\"" + refresh_token2 + "\"");
				sb.append(",\"username\":");
				sb.append("\""+ username + "\"");
				sb.append(",\"client_id\":");
				sb.append("\" "+ client_id + "\"");
				sb.append("}");
				response.getWriter().println(sb.toString());			
				return ;				
			}				
		}
		
	}
}
	

