import java.sql.*;

public class C
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		
		if(args.length < 3)
		{
			System.out.println("Please supply 3 arguments!!");
			return;
		}
		
		String id = args[0];
		String name = args[1];
		String age = args[2];
		
		String sql = "INSERT INTO PERSON VALUES(" + id + ", '" + name + "'," + age + ")";
		
		stmt.execute(sql);
		
		con.close();
		
		System.out.println("done");
	}
}
