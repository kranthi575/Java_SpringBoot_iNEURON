package in.kp.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.kp.JdbcUtil.*;

import in.kp.JdbcUtil.*;
class Menu
{
	public static void Create() throws SQLException{
		//Resources
				Connection conn=null;
				PreparedStatement pstmt=null;
				Scanner sc=new Scanner(System.in);
				
				String sqlQuery="insert into college.student(`SID`,`SNAME`,`SDEPT`) values(?,?,?);";
				
				conn=JdbcUtil.getJdbcConnection();
				
				if(conn!=null)
				{
					pstmt=conn.prepareStatement(sqlQuery);
					if(pstmt!=null)
					{
						System.out.println("Enter SID::");
						pstmt.setString(1,sc.next());
						//String sid=sc.next();
						System.out.println("Enter SNAME::");
						pstmt.setString(2,sc.next());
						//String sname=sc.next();
						System.out.println("Enter SDEPT::");
						pstmt.setString(3,sc.next());
						
						if(!pstmt.execute())
						{
						System.out.println("row updated successfuly");	
						}
						
					}
				}
				
				JdbcUtil.closeConnection(conn, pstmt, null);
				
		
		
	}
	
	public static void Read() throws SQLException {
		
		//Resources
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		String sqlQuery="select * from college.student;";
		
		conn=JdbcUtil.getJdbcConnection();
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			if(pstmt!=null)
			{
				resultSet=pstmt.executeQuery();
				if(resultSet!=null)
				{
					System.out.println("SID\tSNAME\tSDEPT");
					System.out.println("------------------");
					while(resultSet.next())
					{
						System.out.println(resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4));

					}
				}
			}
			
		}
		
		JdbcUtil.closeConnection(conn, pstmt, resultSet);

		
		
	}
	
	public static void Update() throws SQLException{
		
		//Resources
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		Scanner sc=new Scanner(System.in);
				
		
					
				System.out.println("Please Enter SID:");
				String sid=sc.next();
				String header1=null;
				String input1=null;
				String sqlQuery=null;
				System.out.print("Please select value to update:\n1.SNAME\n2.SDEPT\n");
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
				
			
			sqlQuery = "UPDATE college.Student set "+header1+"=? where SID=?;";	
			
			conn=JdbcUtil.getJdbcConnection();
			if(conn!=null)
			{
				pstmt=conn.prepareStatement(sqlQuery);
				if(pstmt!=null)
				{
					pstmt.setString(1,input1);
					pstmt.setString(2, sid);
					if(pstmt.executeUpdate()==1)
					{
						System.out.println("Row updated successfuly!");
					}
					else
					{
						System.out.println("failed!!");
					}
				}
			}
		
		
		
	}
	
	public static void Delete() throws SQLException {
		
		//Resourrces
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		Scanner sc=new Scanner(System.in);
		
		String header1=null;
		String input1=null;
		System.out.print("Please select SID to perform delete::");
		String sid=sc.next();
		/*switch(op) {
		
		case 1:header1="SID";
				input1=sc.next();
				break;
		case 2:header1="SNAME";
		       //input1=sc.nextInt();
				break;
		
		default:
			System.out.println("Please select valid  option");
		}*/
		
	
	//String sqlQuery = "DELETE FROM college.Student WHERE "+header1+"=\""+input1+"\";";
	
	String sqlQuery = "DELETE FROM college.student WHERE SID=\""+sid+"\";";
		
	conn=JdbcUtil.getJdbcConnection();
	if(conn!=null) {
		pstmt=conn.prepareStatement(sqlQuery);
		
		if(!pstmt.execute());
			System.out.println("Row deleted successfully!!");
	
		}
	
	JdbcUtil.closeConnection(conn, pstmt, null);
	}
	
	
}

public class App {

	public static void Main() throws SQLException
	{
		System.out.println("Please select one operation:\n1.CREATE\n2.READ\n3.UPDATE\n4.DELETE\n");
		Scanner sc=new Scanner(System.in);
		int op=sc.nextInt();
		switch(op)
		{
		case 1:Menu.Create();
				break;
		case 2:Menu.Read();
				break;
		case 3:Menu.Update();
				break;
		case 4:Menu.Delete();
				break;
		default:
			System.out.println("Please select valid option!!");
		}
		
		
	}
	public static void main(String[] args) throws SQLException{
		
		Scanner sc=new Scanner(System.in);
		String val=null;
		do {
		App.Main();
		
		System.out.println("Do you want to continue? y/n");
		val=sc.next();
		
		}
		while(val.compareTo("y")==0);
		
		System.out.println("You have exited from application!");
		
		
		
	}

}
