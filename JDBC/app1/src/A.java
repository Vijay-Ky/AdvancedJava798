import java.sql.*;

class A
{
	public static void main(String[] args) throws Exception
	{
		//composing the sql commands
		//String sql1 = "DROP TABLE TEST10";
		String sql2 = "CREATE TABLE TEST10(ID NUMBER)";
		
		//load and register the driver
		//specify the driver class name
		//raising classnotfound exception
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//esta. conn. b/w Java app and the database
		//creating the connection object
		//DriverManager.getConnection is raising sqlexception
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		//creating the statement object
		Statement stmt = con.createStatement();

		//send and execute the query in the database
		//stmt.execute(sql1);
		stmt.execute(sql2);

		//close the connection
		con.close();

		System.out.println("done");
	}
}