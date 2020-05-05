package Guru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TC_002_DataBaseTesting {

	public static void main(String[] args) throws SQLException {
		//step 1 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");
		//step 2
		Statement stmt=con.createStatement();
		
		//Step 3 Excute SQL statment
		String query="Select  *from employees where employee_id>130";
		ResultSet rs=stmt.executeQuery(query);
		System.out.println("FirstName			LastName			Email			Employee_id");
		while(rs.next())
		{
			String username=rs.getString("first_name");
			String UserLastName=rs.getString("last_name");
			String email=rs.getString("email");
			String Employee_id=rs.getString("Employee_id");
			System.out.println(username + "				" + UserLastName + "				" +email +"			"+Employee_id);
			//System.out.println(UserLastName);x
		}
		
		//step 4 Close connection
		
		con.close();
		
		System.out.println("program exute");
		

	}

}
