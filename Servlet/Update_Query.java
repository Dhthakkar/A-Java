import java.io.*;
import java.lang.*;
import java.util.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Query extends HttpServlet 
{
    public void service(HttpServletRequest request,HttpServletResponse response)
    throws IOException, ServletException,NumberFormatException
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
      con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/students","root", "system");
      stmt = con.createStatement();
      out.println("\n\n");	
      String Studroll=request.getParameter("SRoll");
      String Studadd=request.getParameter("Sadd");
        if(Studroll==null)//this parsing is done to 
	 Studroll="0";//avoid NumberFormatException
	int n=Integer.parseInt(Studroll);//converting text to int
	stmt.executeUpdate("update students_table set address='"+Studadd+"' where Roll_no="+n);
        rs=stmt.executeQuery("select * from students_table");
        out.println("<html>");
        out.println("<body>");
        out.println("<form action='Update_Query' method='post'>");
        out.println("<strong>Enter Roll Number for updation : </strong>");
        out.print("<br/>");
	out.print("<input name='SRoll' type='text'>");
        out.print("<br/>");     
        out.println("<strong>Enter new address : </strong>");
        out.print("<br/>");
	out.print("<input name='Sadd' type='text'>");

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
