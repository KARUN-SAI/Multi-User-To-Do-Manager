package com.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;
@WebServlet("/Addtodo")
public class Addtodo extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res ) {
		String tname=req.getParameter("tname");
		String tdes=req.getParameter("tdes");
		String tstatus=req.getParameter("tstatus");
		
		req.setAttribute("tname", tname);
		req.setAttribute("tdes", tdes);
		req.setAttribute("tstatus", tstatus);
		String uname=req.getParameter("uname").toString();
		
			try {
				if(tname!=null) {
					LoginDao l=new LoginDao();
				l.connect();
				if(l.Addtodo(uname,tname, tdes, tstatus)) {
				
				RequestDispatcher r=req.getRequestDispatcher("TodoHome.jsp");
				r.forward(req, res);
				}
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	


