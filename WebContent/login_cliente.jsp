<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login do Cliente</title>
	
	
</head>

<jsp:useBean id="acao" class="java.lang.String" scope="request"></jsp:useBean>

<body>
	<form action="ClienteController" method="post">
		<center>
			<h1>Login Cliente </h1>
		</center>
		<table align="center">
			<tr bgcolor="#BABABA">
				<td colspan="2">Cliente</td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>E-mail</td>
				<td><input type="text" value="" name="email" size="50" maxlength="50"></td>
			</tr>
			<tr bgcolor="#EAEAEA">
				<td>Senha</td>
				<td><input type="password" value="" name="senha" size="15" maxlength="15"></td>
			</tr>
			<tr bgcolor="#BABABA">
				<td colspan="2" align="center">
					<input type="hidden" name="acao" value="GravarLogar" /> 
					<input type="submit" name="Gravarlogar" value="Logar" /> 
					<input type="button" name="Voltar" value="Voltar" onclick="javascript:history.go(-1)">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>