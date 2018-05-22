<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page isELIgnored="false" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h3>Employee Registration Page</h3>
<form action="EmployeeRegistration">
<table>

<tr> <th>Name : <th><td><input type="text" name="name" value=""><font color="red">${errobj.name}</font><br><br></td></tr>
 
 <tr> <th>DOB  : <th><td> <input type="date" name="dob" pattern="dd/mm/yyyy" min="1979-02-01" max="2000-01-01" value=""><font color="red">${errobj.dob}</font><br><br></td></tr>
 
 <tr> <th>Gender : <th><td><input type="radio" name="gender" value="m" checked="checked">Male <input type="radio" name="gender" value="f">Female <br><br></td></tr>
 
 <tr> <th>Address : <th><td><input type="text" name="addr" value=""><font color="red">${errobj.addr}</font><br><br></td></tr>
 
 <tr> <th>Email : <th><td><input type="email" name="mail" value=""><font color="red">${errobj.mail}</font><br><br></td></tr>
 
<tr> <th> Password :<th><td> <input type="password" name="pwd" value=""><font color="red">${errobj.password}</font><br><br></td></tr>
 
 <tr> <th>Phone : <th><td> <input type="text" name="ph" value=""><font color="red">${errobj.mobile}</font><br><br></td></tr>
 
 <tr> <th>Qualification :<th><td> <select name="qua">
 <option vaue="be">Engineering</option>
 <option vaue="bsc">Arts and Science</option>
 <option vaue="com">Commerce</option>
 <option value="other">Others</option>
 </select><br><br></td></tr>
 
 <tr> <th>DOJ  : <th><td><input type="date" name="doj" pattern="dd/mm/yyyy" value=""><font color="red">${errobj.doj}</font><br><br> </td></tr>
 

 <tr> <th>Role  :<th><td> <select name="desg">
 <option vaue="hr">HR</option>
 <option vaue="trainer">Trainer</option>
 <option vaue="tl">TL</option>
 <option value="developer">Developer</option>
 </select><br><br></td></tr>
 
<tr><td> <input type="submit" value="Register"></td></tr>
 
 </table>
</form>

</center>
</body>
</html>