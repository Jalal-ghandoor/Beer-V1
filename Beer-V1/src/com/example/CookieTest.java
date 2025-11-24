package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieTest extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)	throws IOException {
		response.setContentType("text/html");
		
		String name= request.getParameter("username");
		
		Cookie cookie = new Cookie("username", name);
		
		cookie.setMaxAge(30*60);
		
		response.addCookie(cookie);
		
		try {
			
			RequestDispatcher view = request.getRequestDispatcher("cookieresult.jsp");
			
			view.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println();
			PrintWriter out = response.getWriter();
			out.println("<h3 syle='color:red;'>Enternal Server Error.</h3>");
			out.close();
		}
		
	}
}
