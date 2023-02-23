import java.sql.*;

class B
{
	public static void main(String[] args) throws Exception
	{
		//composing the sql commands
		//String sql1 = "DROP TABLE TEST10";
		String sql2 = "CREATE TABLE TEST200(ID INT)";

		//load and register the driver
		//specify the driver class name
		//raising classnotfound exception
		Class.forName("com.mysql.cj.jdbc.Driver");

		//esta. conn. b/w Java app and the database
		//creating the connection object
		//DriverManager.getConnection is raising sqlexception
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vijay", "root", "admin");
		
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