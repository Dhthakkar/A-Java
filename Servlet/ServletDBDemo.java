import java.io.*;
import java.util.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServletDBDemo extends HttpServlet {
  public void service(HttpServletRequest request,HttpServletResponse response)
    throws IOException, ServletException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Servlet Database Connectivity</title></head>");
    out.println("<body>");
    out.println("</body></html>");  
    // connecting to database
    Connection con = null;    
    Statement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/students","root", "system");
      stmt = con.createStatement();
      out.println("Connected to Database..."); 
      out.println("\n\n");	
      rs = stmt.executeQuery("SELECT * FROM students_table");
      // displaying records
      out.print("<center>");	
      out.print("<h2>Students Database</h2>"); 	
      out.print("<table border=3>");
      out.print("<th>Roll</th>");		
      out.print("<th>Name</th>");
      out.print("<th>Address</th>");
      out.print("<th>Phone</th>");
      while(rs.next())
     {
        out.print("<tr>");
	out.print("<td>");
	out.print(rs.getObject(1).toString());
	out.print("</td>");
	out.print("<td>");        
        out.print(rs.getObject(2).toString());
	out.print("</td>");
	out.print("<td>");
	out.print(rs.getObject(3).toString());
	out.print("</td>");
	out.print("<td>");
	out.print(rs.getObject(4).toString());
	out.print("</td>");        
        out.print("</tr>");      
      }
    out.print("</table>");
    out.print("</center>");
    }catch (SQLException e)  {
      throw new ServletException("Servlet Could not display records.", e);
      } catch (ClassNotFoundException e) {
        throw new ServletException("JDBC Driver not found.", e);
      } finally {
        try {
          if(rs != null) {
            rs.close();
            rs = null;
          }
          if(stmt != null) {
            stmt.close();
            stmt = null;
          }
          if(con != null) {
            con.close();
            con = null;
          }
        } catch (SQLException e) {}
      }
      out.close();
    }
  }
