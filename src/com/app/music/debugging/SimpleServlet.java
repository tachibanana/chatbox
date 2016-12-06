package com.app.music.debugging;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SimpleServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		final HttpSession sc = request.getSession();
		
		if(sc.isNew()){
			out.println("This is a new session.<br />");
		}else{
			out.println("Welcome back!<br />");
		}
		
		synchronized(sc){
		sc.setAttribute("boy", 
				(int) (sc.getAttribute("boy") == null ? 2 : (int) sc.getAttribute("boy")) + 2);
		sc.setAttribute("girl",
				(int) (sc.getAttribute("girl") == null ? 4 : (int) sc.getAttribute("girl")) + 2);
		
		out.println("Boy: " + sc.getAttribute("boy") + 
				"<br />Girl: " + sc.getAttribute("girl"));	
		
		
		}
	}

}
