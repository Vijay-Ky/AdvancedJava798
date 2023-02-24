package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class J
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		String sql = "SELECT * FROM PERSON";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.print(rs.getInt("id") + ", ");
			System.out.print(rs.getString("name") + ", ");
			System.out.print(rs.getInt("age") + ", ");
			
			System.out.println();
		}
		System.out.println("done");
	}
}
