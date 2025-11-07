package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.*;

public class BeerSelect extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws IOException {
		response.setContentType("text/html");
		//System.out.println("generating response ...");
		//PrintWriter out = response.getWriter();
		// java.util.Date today = new java.util.Date();
		/*
		out.append("<html> " +	" <body>" +	"<h2>Beer Seect</h2>");
		if(request.getAttribute("brands") != null) {
			out.append("<h4>Brands found.</h4><ul>");
			List<String> brands_list = (ArrayList<String>)request.getAttribute("brands");
			Iterator<String> it = brands_list.iterator();
			while(it.hasNext()) {
				
				out.append("<li>" + it.next() + "</li>");
			}
		} else {
			
			out.append("<h4>No Brands found.</h4>");
		}
		out.append("</ul><div style=\"margin:100px 0 0;\"><a href=\"form.html\">Back</a></div></body>" + "</html>");
		
		out.close();
		*/
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)	throws IOException {
		BeerExpert beerExpert = new BeerExpert();
		var color = request.getParameter("color");
		List<String> brands = null;
		RequestDispatcher view =null;
		
		if(color != null) {
			brands = beerExpert.getBrands(color.toString());
		}
		
		if(brands != null) {
			request.setAttribute("brands", brands);
			try {
				view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
			} catch(Exception e) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Internal Error!");
				out.close();
			}
			
		}
		//doGet(request, response);
	}
}