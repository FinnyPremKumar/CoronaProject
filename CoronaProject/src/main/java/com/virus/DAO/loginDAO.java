package com.virus.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virus.BO.SignUpBO;

public class loginDAO 
{
	public boolean validataData(SignUpBO sign) throws SQLException
	{
		boolean status=false;
		
			MyDbConnection.getMyDbConnection();
			System.out.println("Connection Successfull");
			String sql = "select * from coronacredentials.entiredata where username=? and password=?";
			PreparedStatement prest=MyDbConnection.getMyDbConnection().prepareStatement(sql);
			prest.setString(1,sign.getUsername());
			prest.setString(2, sign.getPassword());
			System.out.println(sql);
			System.out.println(sign.getUsername()+"===="+sign.getPassword());
			ResultSet rs = prest.executeQuery();
			status = rs.next();
		
		return status;
	}
}
