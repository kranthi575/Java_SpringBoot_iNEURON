import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.*;
/*
 * STEPS TO FOLLOW FOR JDBC CONNECTION
 * -----------------------------------
 * 
 * step1: Load the drivers
 * step2: create the connection
 * step3: create statement
 * step4: execute the query
 * step5: close the connection
 */

public class Test_conn {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/?user=root";
		String uname="root";
		String pwd="root";
		
		Connection conn=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		//String query="select * from college.Student; ";
		String query="create table college.Test(ID int);";
		conn=DriverManager.getConnection(url,uname,pwd);
		
		
		if(conn!=null) {
			System.out.println("connection established");
		
			statement=conn.createStatement();
			
			if(statement.execute(query))
			{
				System.out.println("table created successfull");
			}
			System.out.println("table created successfully");
			
			
			if(resultSet!=null)
			{
				while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+":"+resultSet.getString(2)+":"+resultSet.getString(3)+":"+resultSet.getString(4)+":");
				
				System.out.println();
				
				}
			}
				
		
		
		}
	}

}
