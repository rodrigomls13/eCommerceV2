<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
 String url = request.getAttribute("url").toString();
if (url == null) url = "/index.jsp";
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="3;url=<%= url %>">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1> Opera��o concluida</h1>
	<h2> Aguarde ...</h2>
	</center>
</body>
</html>