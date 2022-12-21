package com.kp.app;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.kp.JdbcUtil.*;

public class retriveOp {
	
	//sqlDate -> sdf -> string -> user
	public static String dateConversion(java.sql.Date sqlDate)
	{
		//long ms=date.getTime();
		
	SimpleDateFormat sdf=new SimpleDateFormat();
	
	String date=sdf.format(sqlDate);
		
	return date;
	}

	public static void main(String[] args) throws SQLException{
		
		//Resources
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		System.out.println("Retriving data from table::");
		String sqlQuery="select * from college.employee;";
		
		conn=JdbcUtil.getJdbcConnection();
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			if(pstmt!=null)
			{
				resultSet=pstmt.executeQuery();
				if(resultSet!=null)
				{
					System.out.println("Name\tDept\tGender\tDOB\tDOJ\tDOM");
					System.out.println("-----------------------------------");
					while(resultSet.next()) {
					//System.out.println(resultSet.getString(1)+":"+resultSet.getString(2)+":"+resultSet.getString(3)+":");
					

					//System.out.println(resultSet.getString(1)+":"+resultSet.getString(2)+":"+resultSet.getString(3)+":"+resultSet.getDate(4)+":"+resultSet.getDate(5)+":"+resultSet.getDate(6));
				
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+(dateConversion(resultSet.getDate(4)))+"\t"+(dateConversion(resultSet.getDate(5)))+"\t"+(dateConversion(resultSet.getDate(6))));
										}
				
				}
			}
		}
	}

}
