package com.Todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;
@WebServlet("/Delete")
public class Delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		int i=Integer.parseInt(req.getParameter("id"));
		String uname=req.getParameter("uname");
		LoginDao l=new LoginDao();
		try {
			l.connect();
			if(l.Delete(i,uname)) {
				RequestDispatcher r=req.getRequestDispatcher("TodoHome.jsp");
				r.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
