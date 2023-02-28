package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class R
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String un = "system";
		String pw = "admin";
		String sql = "SELECT * FROM PERSON";
		
		try(Connection con = DriverManager.getConnection(url, un, pw);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql))//jdk 1.7 auto-close resouce
		{
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i = 1; i <= cols; i++)
			{
				System.out.print(rsmd.getColumnName(i) +"\t" );
			}
			System.out.println();
			System.out.println("------------------------");
			while(rs.next())
			{
				for(int i = 1; i <= cols; i++)
				{
					System.out.print(rs.getString(i) +"\t" );
				}
				System.out.println();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
