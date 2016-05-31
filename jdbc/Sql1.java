import java.sql.*;  
class Sql1{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/emp","root","");  
  
//here sonoo is database name, root is username and password  
  

con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}  