package in.scalive.empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	
	static {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "javabked" ,"students");
		}catch(SQLException ex) {
			System.out.println("Error in opening connection : ");
			System.exit(1);
			
		}
	}
	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		}catch(SQLException ex) {
			System.out.println("error in closing the connection : ");
		}
	}
}






