package com.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;
@WebServlet("/Update")
public class Updatetodo extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) {
		int id=Integer.parseInt(req.getParameter("id"));
		String tname=req.getParameter("tname");
		String tdes=req.getParameter("tdes");
		String tstatus=req.getParameter("tstatus");
		String uname=req.getParameter("uname");
		LoginDao l=new LoginDao();
		try {
			l.connect();
		
		if(l.Update(uname,id, tname, tdes,tstatus)) {
		
		RequestDispatcher r=req.getRequestDispatcher("TodoHome.jsp");
		r.forward(req, res);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}


