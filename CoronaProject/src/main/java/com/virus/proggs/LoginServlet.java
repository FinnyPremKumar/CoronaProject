package com.virus.proggs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virus.BO.SignUpBO;
import com.virus.DAO.loginDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		SignUpBO login=new SignUpBO();
		login.setUsername(user);
		login.setPassword(pass);
		loginDAO loginDao=new loginDAO();
		try {
			if(loginDao.validataData(login))
			{
				System.out.println("logged");
				
				res.sendRedirect("homepage.html");
			}
			else if(user==null || pass==null)
			{
				System.out.println("User is not registered");
				res.sendRedirect("signip.html");
			}
			else
			{

				res.sendRedirect("login.html");
				System.out.println("The username/Password is incorrect");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}