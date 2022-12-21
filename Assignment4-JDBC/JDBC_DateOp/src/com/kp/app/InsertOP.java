package com.kp.app;

import java.sql.Connection;
import com.kp.app.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.kp.JdbcUtil.*;

public class InsertOP {
	
	//User -> String -> SimpleDateFormat -> UtilDate -> SqlDate
	public static java.sql.Date dateConversion(String date) throws ParseException
	{
	
		SimpleDateFormat sdf=new SimpleDateFormat("MM-DD-YYYY");
		
		Date utilDate=sdf.parse(date);
		
		long milliseconds=utilDate.getTime();
		
		java.sql.Date sqlDate=new java.sql.Date(milliseconds);
		
		return sqlDate;
		
		
	}

	public static void main(String[] args) throws SQLException,ParseException{
		
		
		//Resources
		Connection conn=null;
		PreparedStatement pstmt=null;
		Scanner sc=new Scanner(System.in);
		//schema of table
		/*
		 |Name | Dept | Gender | DOB | DOJ | DOM |
		 */
		/*
		DOB => dd-MM-yyyy
		DOJ => MM-dd-yyyy
		DOM => yyyy-MM-dd
		*/
		//variables
		
		String name=null;
		String dept=null;
		String gender=null;
		String dob=null;
		String doj=null;
		String dom=null;
		
		System.out.println("To performing insertion operation. Pls enter following details::");
		
		System.out.println("Enter Emp Name::");
		name=sc.next();
		System.out.println("Enter Emp dept::");
		dept=sc.next();
		System.out.println("Enter Emp Gender::");
		gender=sc.next();
		
		System.out.println("Enter Emp DOB::(MM-DD-YYYY)");
		dob=sc.next();
		System.out.println("Enter Emp DOJ::(MM-DD-YYYY)");
		doj=sc.next();
		System.out.println("Enter Emp DOM::(MM-DD-YYYY)");
		dom=sc.next();
		
		java.sql.Date sqlDob=dateConversion(dob);
		java.sql.Date sqlDoj=dateConversion(doj);
		java.sql.Date sqlDom=dateConversion(dom);
		
		String sqlQuery="insert into college.employee(`Name`,`Dept`,`Gender`,`DOB`,`DOJ`,`DOM`) values(?,?,?,?,?,?);";
		
		//Establishing connection
		conn=JdbcUtil.getJdbcConnection();
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			
			if(pstmt!=null)
			{
				pstmt.setString(1, name);
				pstmt.setString(2, dept);
				pstmt.setString(3, gender);
				pstmt.setDate(4, sqlDob);
				pstmt.setDate(5, sqlDoj);
				pstmt.setDate(6, sqlDom);
				
				int noOfRowsEffected=pstmt.executeUpdate();
				if(noOfRowsEffected==1)
				{
					System.out.println("Row inserted successfully!!");
				}
			}
		}
		
		JdbcUtil.closeConnection(conn, pstmt, null);
		
		

	}

}
