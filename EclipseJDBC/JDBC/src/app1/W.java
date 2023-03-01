package app1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class W
{
	public static void main(String[] args) throws Exception
	{
		String sql1 = "INSERT INTO BOOK VALUES(2, 'SPRING', 600)";
		String sql2 = "INSERT INTO BOOK VALUES(3, 'PYTHON', 800)";
		String sql3 = "INSERT INTO BOOK VALUES(4, 'HADOOP', 700)";
		String sql4 = "INSERT INTO BOOK VALUES(5, C++', 300)";
		
		try(Connection con = Util.getConnection();
				Statement stmt = con.createStatement())
		{
			stmt.executeUpdate(sql1);
			System.out.println("successful");
			stmt.executeUpdate(sql2);
			System.out.println("successful");
			stmt.executeUpdate(sql3);
			System.out.println("successful");
			stmt.executeUpdate(sql4);
			System.out.println("successful");
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
