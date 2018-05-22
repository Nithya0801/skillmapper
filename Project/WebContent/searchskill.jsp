<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="SearchProfile.jsp" %>
<table border="2">
<table border="2">
<thead>
<th>Employee_ID</th>
<th>Employee_Name</th>
<th>Gender</th>
<th>Address</th>
<th>Email</th>
<th>Phone Number</th>
<th>Qualification</th>
<th>DOJ</th>
<th>Designation</th>
<th>Skill</th>
<th>International Certificate</th>
<%
Class.forName("org.h2.Driver");
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
Statement st=con.createStatement();
String search_data=request.getParameter("search_data");
ResultSet reterive_data=st.executeQuery("select emp.eid,emp.ename,emp.gender,emp.address,emp.mail,emp.phno,emp.qua,emp.doj,emp.desgn,s.sknown,s.interexam from emp_register emp inner join skill s where emp.eid=s.eid and lower(s.sknown)='"+search_data.toLowerCase()+"' and s.approve='A'");
while(reterive_data.next())
{
%>
<tr>
<td><%=reterive_data.getInt(1) %></td>
<td><%=reterive_data.getString(2) %></td>
<td><%=reterive_data.getString(3) %></td>
<td><%=reterive_data.getString(4) %></td>
<td><%=reterive_data.getString(5) %></td>
<td><%=reterive_data.getLong(6) %></td>
<td><%=reterive_data.getString(7) %></td>
<td><%=reterive_data.getDate(8) %></td>
<td><%=reterive_data.getString(9) %></td>
<td><%=reterive_data.getString(10) %></td>
<td><%=reterive_data.getString(11) %></td>

</tr>

<%} %>
</table>
</body>
</html>