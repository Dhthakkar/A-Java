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

public class Insert_Query extends HttpServlet 
{
    public void service(HttpServletRequest request,HttpServletResponse response)
    throws IOException, ServletException
    {
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
     try
     {

      Class.forName("com.mysql.jdbc.Driver");
con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/students","root",    "system");
      stmt = con.createStatement();

       out.println("\n\n");	
        String Studname=request.getParameter("Sname");
        String Studaddress=request.getParameter("Sadd");
        String Studphone=request.getParameter("Sph");
	  if(Studname!=null&&Studaddress!=null&Studphone!=null)
	  if(Studname.length()>0)
stmt.executeUpdate("insert into students_table(name,address,phone) values('"+Studname+"','"+Studaddress+"','"+Studphone+"')");
        rs=stmt.executeQuery("select * from students_table");
        out.println("<html>");
        out.println("<body>");
        out.println("<form action='Insert_Query' method='post'>");
        out.println("<strong>Name:  </strong><input name='Sname' type='text'>");
        out.println("<br/>");
        out.println("<strong>Address: </strong><input name='Sadd' type='text'>");
        out.println("<br/>");
        out.println("<strong>Phone: </strong><input name='Sph' type='text'>");
        out.println("<br/><br/>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
	out.println("</body>");
        out.println("</html>");

     }catch (SQLException e)
     {
      throw new ServletException("Servlet Could not display records.", e);
     } 
     catch (ClassNotFoundException e) 
     {
       throw new ServletException("JDBC Driver not found.", e);
    
 }
     finally
     {
        try
        {
          if(rs != null) 
          {
            rs.close();
            rs = null;
          }
          if(stmt != null)  
          {
            stmt.close();
            stmt = null;
          }
          if(con != null) 
          {
            con.close();
            con = null;
          }
        }
        catch (SQLException e) {}
      }//end of finally
      out.close();
    }//end of service function
  } //end of class
