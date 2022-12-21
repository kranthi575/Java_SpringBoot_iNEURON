package com.kp.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	
	public static Connection getJdbcConnection() throws SQLException
	{
		//::Resources::
		Connection conn=null;
		
		//server details
		//jdbc:mysql://port/?user=USERNAME
		String url="jdbc:mysql://localhost:3306/?user=root";
		String uname="root";
		String pwd="root";
		
		//Establishing the connection
		conn=DriverManager.getConnection(url, uname, pwd);
		
		return conn;
	}
	
	
	public static void closeConnection(Connection conn,Statement stmt,ResultSet resultSet) throws SQLException
	{
		
		//closing connection
		
		if(conn!=null) {
			
			conn.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(resultSet!=null) {
			resultSet.close();
		}
		
		
	}

}
