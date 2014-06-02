<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vincular Autor no Livro</title>
	
	
</head>

<jsp:useBean id="acao" class="java.lang.String" scope="request"></jsp:useBean>

<body>
	<form action="LivroAutorController" method="post">
		<center>
			<h1>Livro - Autor </h1>
		</center>
		<table align="center">
			<tr bgcolor="#BABABA">
				<td colspan="2">Livro - Autor</td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Livro_ID</td>
				<td><input type="text" value="" name="livro_id" size="10" maxlength="10"></td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Autor_ID</td>
				<td><input type="text" value="" name="autor_id" size="10" maxlength="10"></td>
			</tr>
			
			
			<tr bgcolor="#BABABA">
				<td colspan="2" align="center">
					<input type="hidden" name="acao" value="GravarIncluir" /> 
					<input type="submit" name="GravarIncluir" value="Gravar" /> 
					<input type="button" name="Voltar" value="Voltar" onclick="javascript:history.go(-1)">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>