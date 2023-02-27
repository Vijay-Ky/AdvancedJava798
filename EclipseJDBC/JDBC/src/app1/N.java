package app1;

import java.sql.*;
import java.io.*;
import java.util.*;

public class  N
{
	Connection con;
	PreparedStatement ps;

    public static void main(String args[])  throws Exception
    {
       String filename = "src/app1/students.csv";
       N obj = new N();
       obj.processFile(filename);
       System.out.println("done");
    }

    public void processFile(String filename) throws Exception
    {
       // open file
       FileReader fr = new FileReader(filename);
       BufferedReader br = new BufferedReader(fr);

       // connect to Oracle
       Class.forName("oracle.jdbc.driver.OracleDriver");
       con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
       ps = con.prepareStatement("INSERT INTO PERSON (ID, NAME, AGE) VALUES(?,?,?)");

       String line, columns[];

       // headings line. Ignore it
       line = br.readLine();
       Vector v;
       while( (line = br.readLine())!= null)
       {
		   v = getColumns(line);
		   Enumeration e = v.elements();
           int i = 1;
           while (e.hasMoreElements())
           {
			    ps.setString(i, e.nextElement().toString());
			    i++;
	       }
	       // insert into table after values for parameters are set
	       ps.executeUpdate();

       }

       fr.close();

       ps.close();
       con.close();
    }

    public  Vector getColumns(String line)
    {
	  Vector v = new Vector();
	  StringBuffer bf = new StringBuffer();

      boolean  instring = false;  // indicates whether we are in string

	  for (int i = 0 ; i < line.length(); i ++)
	  {
	      if (line.charAt(i) == ',')
	      {
			   if (!instring)  // if not already in string.
			   {
				   v.add(new String(bf));  // add buffer to vector
				   bf = new StringBuffer();  // reset buffer
		       } // end of if
		       else
		           bf.append(",");  // add comma also to string as we are in string
	      } // end of if
	      else
	      if (line.charAt(i) == '"')  // toggle instring flag when " encountered
	      {
	        if (instring)
	              instring = false;
    		else
		          instring = true;
		  }
		  else
		      bf.append( line.charAt(i));

      } // end of for

      v.add(new String(bf));  // add value at the end as column

      return v;
  }
}
