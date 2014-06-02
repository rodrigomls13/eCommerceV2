<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Autor</title>
	
	
</head>
<jsp:useBean id="autor" class="ecommerce.Autor" scope="request"></jsp:useBean>
<jsp:useBean id="acao" class="java.lang.String" scope="request"></jsp:useBean>
<%
	String readOnly = (request.getAttribute("readOnly") == null) ? ""
			: "readonly=\"readonly\"";
%>

<body>
	<form action="AutorController" method="post">
		<center>
			<h1><%=acao%> Autor </h1>
		</center>
		<table align="center">
			<tr bgcolor="#BABABA">
				<td colspan="2">Autor</td>
			</tr>
			<tr bgcolor="#EAEAEA">
				<td>Código</td>
				<td><input type="text" value="<%=autor.getAutor_id() %>" name="codigo" size="50" maxlength="50" readonly="readonly">
				</td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Nome</td>
				<td><input type="text" value="<%=autor.getAutor_nome() %>" name="nome" size="50" maxlength="50" <%=readOnly%>>
				</td>
			</tr>
			
			<tr bgcolor="#BABABA">
				<td colspan="2" align="center">
					<input type="hidden" name="acao" value="Gravar<%=acao %>" /> 
					<input type="submit" name="gravar" value="Confirmar" /> 
					<input type="button" name="Voltar" value="Voltar" onclick="javascript:history.go(-1)">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>