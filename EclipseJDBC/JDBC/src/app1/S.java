package app1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class S
{
	public static void main(String[] args)
	{
		Properties pr = new Properties();
		try(FileReader fin = new FileReader("src/app1/db.properties"))
		{
			pr.load(fin);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		String driver = pr.getProperty("driverClassName");
		String url = pr.getProperty("url");
		String un = pr.getProperty("username");
		String pw = pr.getProperty("password");
		
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
