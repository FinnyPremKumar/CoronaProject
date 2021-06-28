package com.virusDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.login.DetailsBO;
import com.login.ResponseBO;


public class CoronaDAO 
{
	
	public void data() throws SQLException
	{
		MyDbConnection.getMyDbConnection();
		java.sql.PreparedStatement prest= MyDbConnection.getMyDbConnection().prepareStatement("select * from coronadetails.coronadata");
		System.out.println(prest);
		java.util.List<DetailsBO> list=new ArrayList<DetailsBO>();
		ResultSet rs=prest.executeQuery();
		ResponseBO responseBO = new ResponseBO();
		while(rs.next()) 
		{
			DetailsBO detailsBo=new DetailsBO();
			detailsBo.setMonth(rs.getString(1));
			detailsBo.setNoOfCases(rs.getInt(2));
			detailsBo.setCountry(rs.getString(3));
			list.add(detailsBo);
		}
		responseBO.setDetailsBOList(list);
	}
}