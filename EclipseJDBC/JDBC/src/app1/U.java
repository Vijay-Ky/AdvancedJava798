package app1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class U
{
	public static void main(String[] args) throws Exception
	{
		String sql = "INSERT INTO BOOK VALUES(1, 'JAVA', 1000)";
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
