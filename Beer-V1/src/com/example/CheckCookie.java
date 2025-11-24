package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				Cookie cookie = cookies[i];
				
				if(cookie.getName() .equals("username")) {
					String userName = cookie.getValue();
					out.println("Hello, " + userName);
					out.println("<br><br><br><div><a href='/Beer-V1'>Back</a></div>");
					break;
				}
			}
		}
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			doGet(request, response);
	}*/
}
