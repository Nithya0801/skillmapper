<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<form action="SkillUpdation">

Employee ID : <input type="text" name="eid" value="0"/><font color="red">${error.eid}</font><br><br>

Skills Upgrade : <input type="textarea" name="upgrade" value=""/><font color="red">${error.skill}</font><br><br>

No.Of Batch Handled : <input type="text" name="nobatch" value="0" /><font color="red">${error.batch_handle}</font><br><br>

No.of Student Handled : <input type="text" name="nostu" value="0"/><font color="red">${error.student_handle}</font><br><br>

No. Of Student Placed : <input type="text" name="nopla" value="0"/><font color="red">${error.student_placed}</font><br><br>

Proposed Designation : <input type="text" name="desgn" value=""/><font color="red">${error.desgn}</font><br><br>

International Voucher Certification : <input type="radio" name="voucher" value="ocjp">OCJP<input type="radio" name="voucher" value="microsoft">Microsoft
<input type="radio" name="voucher" value="none" checked>None<br><br> 

<input type="submit" value="Update"/>

</form>


</center>
</body>
</html>