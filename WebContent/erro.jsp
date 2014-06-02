<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="erro" class="java.lang.Exception" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String tipo = "", mensagem = "";
	if (erro != null) {
		tipo = erro.getClass().toString();
		tipo = tipo.substring(tipo.lastIndexOf(" ")+1, tipo.length());
		
		mensagem = erro.getMessage();
		
		if (tipo.equals("java.lang.NumberFormatException"))
			mensagem  = "Numero invalido informado";
	}
%>

<table border="1" align="center" cellpadding="3">
<tr><td colspan="2"> ERRO OCORRIDO  </td> </tr>
<tr><td> Tipo:</td> <td><b> <%=tipo %></b> </td> </tr>
<tr><td> Mensagem:</td> <td><b> <%=mensagem %></b> </td> </tr>
<tr><td colspan="2" align="center"><input type="button"  value="Inicio" onclick="javascript:document.location='index.jsp'"/>
</table>
</body>
</html>