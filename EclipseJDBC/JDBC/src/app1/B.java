package app1;

import java.sql.*;

public class B
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vijay", "root", "admin");
		
		Statement stmt = con.createStatement();
		
		String sql = "INSERT INTO TEST200 VALUES(2000)";
		
		stmt.execute(sql);
		
		con.close();
	}
}

