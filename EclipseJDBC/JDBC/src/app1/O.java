package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class O
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "admin");
		
		Statement stmt = con.createStatement();
		
		String sql = "SELECT ID AS P_ID, AGE AS PERSON_AGE FROM PERSON";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(1));
		System.out.println(rsmd.getColumnName(2));
		
		while(rs.next())
		{
			System.out.print(rs.getString(1) + ", ");
			System.out.print(rs.getString(2) + ", ");
			System.out.println();
			
		}
		System.out.println("done");	
	}
}
