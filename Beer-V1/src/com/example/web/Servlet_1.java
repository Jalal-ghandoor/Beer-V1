package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Servlet_1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		java.util.Date today = new java.util.Date();
		out.println("<html> " +	" <body>" +	"<h2>Servlet 1</h2></body>" + "</html>");
		
		out.close();
	}
}