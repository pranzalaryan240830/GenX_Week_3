package week_3;

import java.sql.*;

public class day_2_jdbc_CREATE {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		Statement st = null;
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Started !");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?user=root&password=root");
			System.out.println("Successfully Connected to Database!");
			st = con.createStatement();
			System.out.println("Statement setup finished!\n\n");
			
			String query = "CREATE TABLE Employee(E_no int NOT NULL, Emp_Name varchar(255) NOT NULL, Emp_Dept varchar(255), Emp_Sal int, PRIMARY KEY(E_no))";
			st.executeUpdate(query);
			System.out.println("Created Employee Table");					
			
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
