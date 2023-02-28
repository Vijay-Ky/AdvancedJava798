package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Q
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
		ResultSet rs = null;
		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String un = "system";
			String pw = "admin";
			
			con = DriverManager.getConnection(url, un, pw);
			stmt = con.createStatement();
			String sql = "SELECT * FROM PERSON";
			stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i = 1; i <= cols; i++)
			{
				System.out.println(rsmd.getColumnName(i) +"\t" );
			}
			System.out.println();
			System.out.println("------------------------");
			while(rs.next())
			{
				for(int i = 1; i <= cols; i++)
				{
					System.out.println(rs.getString(i) +"\t" );
				}
				System.out.println();
			}
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
