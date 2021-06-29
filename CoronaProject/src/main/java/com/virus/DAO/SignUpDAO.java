package com.virus.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.virus.BO.SignUpBO;

public class SignUpDAO 
{
	public int signUpNow(SignUpBO signup) throws SQLException
	{
		MyDbConnection.getMyDbConnection();
		PreparedStatement prest=MyDbConnection.getMyDbConnection().prepareStatement("insert into coronacredentials.entiredata values(?,?,?,?,?)");
		prest.setString(1, signup.getUsername());
		prest.setString(2, signup.getEmailId());
		prest.setString(3, signup.getMobileNo());
		prest.setString(4, signup.getPassword());
		prest.setString(5, signup.getConfirmPassword());
		
		
		int rs=prest.executeUpdate();
		
		return rs;
	}
}
