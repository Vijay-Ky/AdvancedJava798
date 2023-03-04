package com.aptech;
import javax.servlet.*;//servlet api
import javax.servlet.http.*;//servlet api
import java.io.*;//JDK

//HttpServlet is a class
public class HelloAgainServlet extends HttpServlet
{
	//Interface HttpServletRequest, Interface HttpServletResponse
	//ServletException is a checked exception
	//IOException is a Checked Exception
	//service method is available in HttpServlet
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//to write something to the browser
		//PrintWriter is a class, Prints formatted representations of objects to a text-output stream.
		//in the java.io.Writer we have PrintWriter, is a class
		// getWriter() throws IOException Returns a PrintWriter object that can send character text to the client.
		PrintWriter out = response.getWriter();
		out.println("Hello from HelloAgainServlet");
	}
}
/*
to compile all the java files
-----------------
F:\DevelopmentSoftwares\Tomcat9\webapps\app1\WEB-INF\src>javac -d ../classes com/aptech/*.java
if you are making any changes to the WEB-INF folder you must restart the server
in the browser
-------
http://localhost:9090/app1/hello
*/		

                                                                                                        