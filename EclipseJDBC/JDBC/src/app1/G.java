package app1;

import java.sql.*;
import java.util.Scanner;

public class G
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("Please enter ID");
			String id = sc.next();
			
			System.out.println("Please enter Name");
			String name = sc.next();
			
			System.out.println("Please enter Age");
			String age = sc.next();
			
			String sql = "INSERT INTO PERSON VALUES(" + id + ", '" + name + "'," + age + ")";
			
		stmt.execute(sql);
		System.out.println("Successfull!\ndo you want to insert one more record?");
		}
		while("y".equalsIgnoreCase(sc.next()));
		
		con.close();
		
		System.out.println("done");
	}
}
