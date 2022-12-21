package in.kp.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcUtil {
	
	public static Connection getJdbcConnection() throws SQLException
	{
		//Resources
		Connection conn=null;
		
		//server details
		//root@localhost:3306
		//jdbc:mysql://localhost:3306/?user=root
		
		String url="jdbc:mysql://localhost:3306/?user=root";
		String uname="root";
		String pwd="root";
		
		//Loading driver
		Driver driver=new Driver();
		//register the driver
		DriverManager.registerDriver(driver);
		
		conn=DriverManager.getConnection(url,uname,pwd);
		
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
