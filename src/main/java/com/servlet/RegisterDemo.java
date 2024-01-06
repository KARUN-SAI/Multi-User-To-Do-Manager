package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;
@WebServlet("/Register")
public class RegisterDemo extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String fname=req.getParameter("first Name").toString();
		String lname=req.getParameter("Last Name").toString();
		String uname=req.getParameter("User Name").toString();
		String pass=req.getParameter("Password").toString();
		
		
		try {
			LoginDao l=new LoginDao();
			l.connect();
			
			
			boolean b=l.Add(fname, lname, uname, pass);
		
			if(b==true) {
				 l.CreateTable(uname); 
			
			req.setAttribute("register","User Registered Successfully!"); 
			 
		
			}
			/* res.sendRedirect("Login.jsp"); */
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, res);
	
		
			
			
			
			
		
		
		
	}

}
