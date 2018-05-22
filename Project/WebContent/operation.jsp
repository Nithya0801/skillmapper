<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

Class.forName("org.h2.Driver");
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
String mail=request.getParameter("mail");
String pwd=request.getParameter("pwd");
Statement st=con.createStatement();
ResultSet reteriveData=st.executeQuery("select * from emp_register where mail='"+mail+"' and password='"+pwd+"'");
int hr_data=0;
while(reteriveData.next())
{
	if(reteriveData.getString("desgn").equalsIgnoreCase("HR"))
	{
		response.sendRedirect("HR_page.jsp");
		hr_data=1;
	}
	else
	{
		response.sendRedirect("viewSkill.jsp?eid="+reteriveData.getInt(1));
	}
}
if(hr_data==0)
{
	out.println(" Credentials not met....");
	request.getRequestDispatcher("Admin.jsp").include(request,response);
}

%>
</body>
</html>