package app1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
public class H
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
					
		Statement stmt = con.createStatement();
		
		FileReader fin = new FileReader("src/app1/data.txt");
		BufferedReader bin = new BufferedReader(fin);
		
		String record = bin.readLine();
		
		String id, name, age, sql, data[];
		
		while(record != null)
		{
			data = record.split(";");
			id = data[0];
			name = data[1];
			age = data[2];
			sql = "INSERT INTO PERSON VALUES(" + id + ",'" + name + "'," + age + ")";
			stmt.execute(sql);
			
			record = bin.readLine();
		}
		System.out.println("done");
	}
}
