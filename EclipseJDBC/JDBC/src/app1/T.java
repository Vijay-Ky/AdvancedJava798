package app1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class T
{
	public static void main(String[] args) throws Exception
	{
		String sql = "CREATE TABLE BOOK(ID NUMBER, TITLE VARCHAR2(90), PRICE NUMBER)";
		try(Connection con = Util.getConnection();
				Statement stmt = con.createStatement())
		{
			stmt.execute(sql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
