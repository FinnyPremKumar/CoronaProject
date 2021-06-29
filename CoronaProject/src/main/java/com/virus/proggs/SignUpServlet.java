package com.virus.proggs;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virus.BO.SignUpBO;
import com.virus.DAO.SignUpDAO;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String username=req.getParameter("username");
		String emailid=req.getParameter("mail");
		String mobileno=req.getParameter("phone");
		String password=req.getParameter("pass");
		String confirmPassword=req.getParameter("confirm");
		SignUpBO signUp=new SignUpBO();
		signUp.setUsername(username);;
		signUp.setEmailId(emailid);
		signUp.setMobileNo(mobileno);
		signUp.setPassword(password);
		signUp.setConfirmPassword(confirmPassword);
		SignUpDAO signdao=new SignUpDAO();
			try {
				if(0<signdao.signUpNow(signUp))
				{
					res.sendRedirect("login.html");
				}
				else
				{
					res.sendRedirect("signip.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
