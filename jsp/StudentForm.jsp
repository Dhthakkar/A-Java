<%@ page language="java" import="java.sql.*" %>
<%@ page import="java.io.*" %>
	<%
	Connection conn=null;
	ResultSet rs=null;
	Statement stmt=null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();	
conn=
DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","system");
	out.write("Connected to mysql!!!");
	stmt=conn.createStatement();   
	if(request.getParameter("action") != null)
	{ 
		String Studname=request.getParameter("Studname");
		String Studaddress=request.getParameter("Studaddress");
		String Studphone=request.getParameter("Studphone");
stmt.executeUpdate("insert into students_table(name,address,phone) values
(' "+Studname+" ',' "+Studaddress+" ',' "+Studphone+" ')" );
		rs=stmt.executeQuery("select * from students_table");
	%>
		<html>
		<body>
		<center>
			<h2>Student List</h2>
			<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td><b>Roll No</b></td>
				<td><b>Student Name</b></td>
				<td><b>Address</.b></td>
				<td><b>Phone</.b></td>
			</tr>
			 	<%
				int num=1;
				while(rs.next()){
				%>
				<tr>
				  <td><%=num%></td>
				  <td><%=rs.getString("name")%></td>
				  <td> <%=rs.getString("address")%></td>
				  <td> <%=rs.getString("phone")%></td>
				</tr>
				<%
				num++;
				}
				rs.close();
				stmt.close();
				conn.close();
				%>
			</table>
		</center>
		</body>
		</html>
		<%}else{%>
		<html>
		<head>
		<title>Student Registartion Demo</title>
		<script language="javascript">
		    function validation(Form_obj)
			{
			if(Form_obj.Studname.value.length==0){
			alert("Please,fill up the remaining information!!");							
Form_obj.Studname.focus();
			return false;
			}
			if(Form_obj.Studaddress.value.length==0){
			alert("Please,fill up the remaining information!!");		
Form_obj.Studaddress.focus();
			return false;
			}
			if(Form_obj.Studphone.value.length==0){
			alert("Please,fill up the remaining information!!");
			Form_obj.Studphone.focus();
			return false;
			}
			return true;
			}
			</script>
		</head>
		<body>
			<center>
			<form action="StudentForm.jsp" method="post" 
			name="entry" onSubmit="return validation(this)">
				<input type="hidden" value="list" name="action">
				<table border="3" cellpadding="0" cellspacing="0">
					<tr>
					<td>
					<table>
       					 <tr>
						<td colspan="2" align="center">
						<h2>Student Entry Form</h2></td>
						</tr>
						<tr>
						<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
						<td>Student Name:</td>
						<td><input name="Studname" type= "text" size="50"></td>
						</tr>
						<tr>
						<td>Address:</td>
<td><input name="Studaddress" type="text" size="50"></td>
						</tr>
						
						<td>Phone:</td>
						<td><input name="Studphone" type="text" size="15"></td>
						</tr>
						
						<tr>
						<td colspan="2" align="center">
						<input type="submit" value="Submit"></td>
						</tr>
					</table>
					</td>
					</tr>
				</table>
			</form>
			</center>
		</body>
	</html>
<%}%>
