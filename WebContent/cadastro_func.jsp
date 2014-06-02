<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Funcionário</title>
	
	
</head>

<jsp:useBean id="acao" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="funcionario" class="ecommerce.Funcionario" scope="request"></jsp:useBean>

<%
	String readOnly = (request.getAttribute("readOnly") == null) ? ""
			: "readonly=\"readonly\"";
%>
<body>
	<form action="FuncionarioController" method="post">
		<center>
			<h1><%=acao%> Funcionário</h1>
		</center>
		<table align="center">
			<tr bgcolor="#BABABA">
				<td colspan="2">Funcionário</td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Nome</td>
				<td><input type="text" value="<%=funcionario.getFuncionario_nome()%>" name="funcionario_nome" size="50" maxlength="50" <%=readOnly%>></td>
			</tr>
			<tr bgcolor="#EAEAEA">
				<td>Login</td>
				<td><input type="text" value="<%=funcionario.getLogin() %>" name="login" size="20" maxlength="20" <%=readOnly%>></td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Senha</td>
				<td><input type="password" value="<%=funcionario.getSenha() %>" name="senha" size="20" maxlength="20" <%=readOnly%>></td>
			</tr>
			
			<tr bgcolor="#BABABA">
				<td colspan="2" align="center">
					<input type="hidden" name="acao" value="Gravar<%=acao%>" /> 
					<input type="submit" name="grava" value="Confirmar" />  
					<input type="button" name="Voltar" value="Voltar" onclick="javascript:history.go(-1)">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>