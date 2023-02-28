package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P
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
		Connection con = null;
		Statement stmt = null;
		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String un = "system";
			String pw = "admin";
			
			con = DriverManager.getConnection(url, un, pw);
			stmt = con.createStatement();
			String sql = "INSERT INTO PERSON VALUES(21, 'MANOHAR', 35)";
			stmt.execute(sql);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
				{
					stmt.close();
					stmt = null;
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			try
			{
				if(con != null)
				{
					con.close();
					con = null;
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		System.out.println("done");
	}
}
