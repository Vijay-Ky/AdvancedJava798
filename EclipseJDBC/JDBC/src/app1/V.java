package app1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class V
{
	public static void main(String[] args) throws Exception
	{
		String sql = "UPDATE BOOK SET ID = 2 WHERE TITLE = 'JAVA'";
		try(Connection con = Util.getConnection();
				Statement stmt = con.createStatement())
		{
			int i = stmt.executeUpdate(sql);
			System.out.println("Records updated: " + i);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
