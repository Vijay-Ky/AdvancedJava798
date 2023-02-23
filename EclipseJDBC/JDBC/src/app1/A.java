package app1;

import java.sql.*;

public class A
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		String sql = "INSERT INTO TEST20 VALUES(1000)";
		
		stmt.execute(sql);
		
		con.close();
	}
}
