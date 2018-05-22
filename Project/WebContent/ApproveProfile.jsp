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
<form action="ApprovedProfile">
<table border="2">
<thead>
<th>SkillId</th>
<th>SkillKnown</th>
<th>International Certificate</th>
<th>Employee Id</th>
<th>Batch Handle</th>
<th>Student Handle</th>
<th>Student Placed</th>
<th>Proposed Designation</th>
<th>Approve</th>

</thead>
<%
Class.forName("org.h2.Driver");
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
Statement st=con.createStatement();
ResultSet reteriveSkill=st.executeQuery("select skill.sid,skill.sknown,skill.interexam,skill.eid,skill.approve,sm.nobatch,sm.nostu,sm.nostuplace,sm.proposedesg from  skill inner join skill_master sm where skill.eid=sm.eid");
//ResultSet reteriveSkillmaster=st.executeQuery(")
while(reteriveSkill.next())
{
	if(reteriveSkill.getString(5)==null)
	{
%>
<tbody>
<tr><td><%=reteriveSkill.getInt(1) %></td>
<td><%=reteriveSkill.getString(2) %></td>
<td><%=reteriveSkill.getString(3) %></td>
<td><%=reteriveSkill.getInt(4) %></td>
<td><%=reteriveSkill.getInt(6) %></td>
<td><%=reteriveSkill.getInt(7) %></td>
<td><%=reteriveSkill.getInt(8) %></td>
<td><%=reteriveSkill.getString(9) %></td>
<td><input type="checkbox" name="approve" value="<%=reteriveSkill.getInt(1) %>"></td>
</tr>
</tbody>
<%}}
%>

</table>

<input type="submit" value="SaveRecord">

<a href="HR_page.jsp">Home</a>
</form>
</body>
</html>