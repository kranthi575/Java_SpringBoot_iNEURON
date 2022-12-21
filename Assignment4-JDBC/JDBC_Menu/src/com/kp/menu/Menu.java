package com.kp.menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kp.JdbcUtil.*;

/*
  Give the menu to the user as the operation listed below on student1 table
			1. Create 2. Read 3. Update 4. Delete 
 */
class Operations
{
	public static void Update() throws SQLException
	{
		//Resources
		Statement statement=null;
		Connection conn=null;
		
		Scanner sc=new Scanner(System.in);
		
		try {
			
		System.out.println("Please Enter SID:");
		String sid=sc.next();
		String header1=null;
		String input1=null;
		String sqlQuery=null;
		System.out.print("User Please select value to update:\n1.SNAME\n2.SDEPT\n");
		int op=sc.nextInt();
		switch(op) {
		
		case 1:header1="SNAME";
				input1=sc.next();
				break;
		case 2:header1="SDEPT";
		       input1=sc.next();
				break;
				default:
			System.out.println("Please select valid  option");
		}
		
	
	sqlQuery = "UPDATE college.student1 set "+header1+"=\""+input1+"\" where SID ="+sid+";";	
	
	conn=JdbcUtil.getJdbcConnection();
	if(conn!=null) {
	statement=conn.createStatement();
	if(statement!=null) {
			
		if(statement.executeUpdate(sqlQuery)==1)
		{
			System.out.println("Row Updated successfully!!");
		}
		else
			System.out.println("Row not updated successfully!\nPlease enter valid details");
						}
					}
	}
		catch(InputMismatchException ime)
		{
			System.out.println("Please enter valid input::");
			
		}
		
	JdbcUtil.closeConnection(conn, statement, null);
	
	}
	
	public static void Delete() throws SQLException
	{
		
		//Resourrces
		Connection conn=null;
		Statement statement=null;
		
		Scanner sc=new Scanner(System.in);
		
		String header1=null;
		String input1=null;
		System.out.print("User, Please select condition :\n1.SID\n2.SNAME\n");
		int op=sc.nextInt();
		switch(op) {
		
		case 1:header1="SID";
				input1=sc.next();
				break;
		case 2:header1="SNAME";
		       //input1=sc.nextInt();
				break;
		
		default:
			System.out.println("Please select valid  option");
		}
		
	
	String sqlQuery = "DELETE FROM college.student1 WHERE "+header1+"=\""+input1+"\";";
	
	conn=JdbcUtil.getJdbcConnection();
	if(conn!=null) {
		statement=conn.createStatement();
		
		if(!statement.execute(sqlQuery));
			System.out.println("Row deleted successfully!!");
	
		}
	
	JdbcUtil.closeConnection(conn, statement, null);
	
	Menu.Read();
	
	}
	
	
}
public class Menu {
	
	public static void Create() throws SQLException
	{
		//Resources
		Connection conn=null;
		Statement statement=null;
		/*
		Table Format
		------------
		SID,SNAME,SDEPT  (* varchar)
		*/
		
		//Reading data from user
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter SID::");
		String sid=sc.next();
		System.out.println("Enter SNAME::");
		String sname=sc.next();
		System.out.println("Enter SDEPT::");
		String sdept=sc.next();
		
		String sqlQuery="insert into college.student1(`SID`,`SNAME`,`SDEPT`) values(\""+sid+"\",\""+sname+"\",\""+sdept+"\");";
		
		
		//Establishing connection
		conn=JdbcUtil.getJdbcConnection();
	try {
		if(conn!=null)
		{
			//creating statement
			statement=conn.createStatement();
			if(statement!=null)
			{
				
				if(!statement.execute(sqlQuery))
					System.out.println("Row created successfully!");
			}
			
		}
	}
	catch(SQLIntegrityConstraintViolationException sce)
	{
		System.out.println("duplicate values detected!! try again::");
	}
		//closing resources
		JdbcUtil.closeConnection(conn, statement, null);
		
		
	}
	
	
	public static void Read() throws SQLException
	{
		//Resources
		Connection conn=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		
		//Establishing connection
		conn=JdbcUtil.getJdbcConnection();
		
		String sqlQuery="select * from college.student1;";
		if(conn!=null)
		{
			statement=conn.createStatement();
			if(statement!=null)
			{
				resultSet=statement.executeQuery(sqlQuery);
				
				if(resultSet!=null)
				{
					System.out.println("SID   SNAME  SDEPT");
					System.out.println("------------------");
					while(resultSet.next())
					{
						System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
					}
				}
			}
			
		}
		
		//closing resources
		JdbcUtil.closeConnection(conn, statement, resultSet);
		
	}
	
	public static void Main() throws SQLException
	{
		System.out.println("Please select one operation:\n1.CREATE\n2.READ\n3.UPDATE\n4.DELETE\n");
		Scanner sc=new Scanner(System.in);
		try {
		int op=sc.nextInt();
		switch(op)
		{
		case 1:Menu.Create();
				break;
		case 2:Menu.Read();
				break;
		case 3:Operations.Update();
				break;
		case 4:Operations.Delete();
				break;
		default:
			System.out.println("Please select valid option!!");
		}
		}
		catch(InputMismatchException ime)
		{
			System.out.println("Enter valid input!!");
		}
		
	}
	

	public static void main(String[] args) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		String val=null;
		do {
		Menu.Main();
		
		System.out.println("Do you want to continue? y/n");
		val=sc.next();
		
		}
		while(val.compareTo("y")==0);
		
		System.out.println("You have exited from application!");
	}

}
