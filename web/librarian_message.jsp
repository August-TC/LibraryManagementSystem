<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>getback</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>

<p style="font-size:24px">
    &nbsp;&nbsp;&nbsp;&nbsp;Dear user:</br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(String)request.getAttribute("message")%>
    <!--Your password recovery request has been submitted, the email has been sent to you rmailbox, you can change the password by clicking on the link in the mail.After changing your password, you can log in again.-->
</p>
<a href="librarian_index.jsp"><button>BACK</button></a>
</body>
</html>
