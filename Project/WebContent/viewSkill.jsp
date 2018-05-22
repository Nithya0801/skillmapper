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
<%
Class.forName("org.h2.Driver");
Connection db_connect=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
Statement statement=db_connect.createStatement();
int emp_id=Integer.parseInt(request.getParameter("eid"));
ResultSet retrieveData=statement.executeQuery("select em.ename,em.mail,em.desgn,s.sknown,s.interexam from emp_register em inner join skill s where em.eid="+emp_id +"and s.eid="+emp_id);
String employee_name="",employee_mail="",employee_desgn="",employee_skill="",employee_Inter_exam="";
//out.println(retrieveData.getFetchSize());
//String employee_skill[]=new String[retrieveData.getFetchSize()];
while(retrieveData.next())
{
	employee_name=retrieveData.getString(1);
	employee_mail=retrieveData.getString(2);
	employee_desgn=retrieveData.getString(3);
		employee_skill=employee_skill+","+retrieveData.getString(4);
	employee_Inter_exam=retrieveData.getString(5);
			
}
%>

<table>

<tr><td>Name : <%=employee_name %></td></tr>
<tr><td>Mail : <%=employee_mail %></td></tr>
<tr><td>Designation : <%=employee_desgn %></td></tr>
<tr><td>Skills : <%=employee_skill %></td></tr>
<tr><td>International Voucher : <%=employee_Inter_exam %></td></tr>


</table>

<a href="SkillUpdate.jsp">Update Skill</a>
<a href="logout.jsp">Logout</a>
</body>
</html>