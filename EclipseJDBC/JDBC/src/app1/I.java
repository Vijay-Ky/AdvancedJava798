package app1;

import java.sql.*;

public class I
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		String sql1 = "UPDATE PERSON SET ID = 1000 WHERE NAME = 'kumar'";
		
		String sql2 = "DELETE FROM PERSON WHERE ID = 806";
		
		stmt.execute(sql1);
		stmt.execute(sql2);
		
		con.close();
		
		System.out.println("done");
	}
}
