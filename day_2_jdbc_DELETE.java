package week_3;

import java.sql.*;

public class day_2_jdbc_DELETE {

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
			
			System.out.println("Before Deletion Records");
			
			String query = "SELECT * FROM Employee";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("E_no") + "\t" + rs.getString("Emp_Name") + "\t" + rs.getString("Emp_Dept") + "\t" + rs.getInt("Emp_Sal"));
			}
			
			query = "DELETE FROM Employee WHERE E_no = 102";
			st.executeUpdate(query);
			System.out.println("Deleted Records of Employee 102\n");
			
			
			query = "SELECT * FROM Employee";
			rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("E_no") + "\t" + rs.getString("Emp_Name") + "\t" + rs.getString("Emp_Dept") + "\t" + rs.getInt("Emp_Sal"));
			}
			
					
		} catch (ClassNotFoundException e) {
			System.out.println("Oops! Connection to DB Failed.");
			e.printStackTrace();
		}
		
		finally {
			
			if(st!=null) {
				try {					
					st.close();
					System.out.println("\n\n-- Statement Bridge Closed!");
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
