package app1;

import java.sql.*;
import java.util.Scanner;

public class F
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter ID");
		String id = sc.next();
		
		System.out.println("Please enter Name");
		String name = sc.next();
		
		System.out.println("Please enter Age");
		String age = sc.next();
		
		String sql = "INSERT INTO PERSON VALUES(" + id + ", '" + name + "'," + age + ")";
		             // "INSERT INTO PERSON VALUES(" + id + ", '" + name + "', 22)";
		
	//"insert into person values(100, 'vijay', 22)";
		
		stmt.execute(sql);
		
		con.close();
		
		System.out.println("done");
	}
}
