package app1;

import java.sql.*;

public class D
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		String sql1 = "INSERT INTO PERSON VALUES(1, 'ABC', 23)";
		String sql2 = "INSERT INTO PERSON VALUES(2, 'A', 24)";
		String sql3 = "INSERT INTO PERSON VALUES(3, 'AC', 25)";
		String sql4 = "INSERT INTO PERSON VALUES(4, 'BC', 27)";
		String sql5 = "INSERT INTO PERSON VALUES(5, 'AC', 24)";
		String sql6 = "INSERT INTO PERSON VALUES(6, 'C', 26)";
		String sql7 = "INSERT INTO PERSON VALUES(7, 'AB', 24)";
		String sql8 = "INSERT INTO PERSON VALUES(8, 'AA', 23)";
		
		
		stmt.execute(sql1);
		stmt.execute(sql2);
		stmt.execute(sql3);
		stmt.execute(sql4);
		stmt.execute(sql5);
		stmt.execute(sql6);
		stmt.execute(sql7);
		stmt.execute(sql8);
		
		con.close();
		
		System.out.println("done");
	}
}
