package week_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class day_1_jdbc_Connection {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		Statement st = null;
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Started !");

			// Creating Statement
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Successfully Connected to Database!");
			
			// Creating Statement
			
			st = con.createStatement();
			System.out.println("Statement setup finished!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Oops! Connection to DB Failed.");
			e.printStackTrace();
		}
		
		finally {
			
			if(st!=null) {
				try {					
					st.close();
					System.out.println("-- Statement Bridge Closed!");
				}catch(SQLException e) {
					System.out.println("-- Error closing Statement Bridge !");
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {					
					con.close();
					System.out.println("-- Disconnected from DB!");
				}catch(SQLException e) {
					System.out.println("-- Error disconnecting !");
					e.printStackTrace();
				}
			}
		}
	}

}
