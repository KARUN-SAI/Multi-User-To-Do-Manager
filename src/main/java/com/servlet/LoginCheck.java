package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.LoginDao;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String uname=req.getParameter("User Name").toString();
		String upaas=req.getParameter("Password").toString();
		HttpSession s=req.getSession();
		s.setAttribute("uname", uname);
		try {
				LoginDao l = new LoginDao();
				boolean b=false,k=false;
				l.connect();
				b = l.check(uname, upaas);
				if(b) {
					k=l.opentable(uname);
					if(k) {
						/*
						 * RequestDispatcher r=req.getRequestDispatcher("TodoHome.jsp"); r.forward(req,
						 * res);
						 */
					 res.sendRedirect("TodoHome.jsp");
			    	 
			    	 
			    	 
			     }else {
						/*
						 * RequestDispatcher r=req.getRequestDispatcher("Login.jsp"); r.forward(req,
						 * res);
						 */
						res.sendRedirect("Login.jsp"); 
			     }
					}else {
						/*
						 * RequestDispatcher r=req.getRequestDispatcher("Login.jsp"); r.forward(req,
						 * res);
						 */
						res.sendRedirect("Login.jsp"); 
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		
		
  
		
	}

}
