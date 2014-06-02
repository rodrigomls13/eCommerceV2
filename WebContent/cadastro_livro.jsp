<%@page import="ecommerce.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Livros</title>
	
	
</head>
<jsp:useBean id="assuntos" class="java.util.Vector" scope="request"></jsp:useBean>
<jsp:useBean id="livro" class="ecommerce.Livro" scope="request"></jsp:useBean>
<jsp:useBean id="acao" class="java.lang.String" scope="request"></jsp:useBean>
<%
	String readOnly = (request.getAttribute("readOnly") == null) ? ""
			: "readonly=\"readonly\"";
%>
<body>
	<form action="LivroController" method="post">
		<center>
			<h1><%=acao%> Livro </h1>
		</center>
		<table align="center">
			<tr bgcolor="#BABABA">
				<td colspan="2">Livro</td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Código</td>
				<td><input type="text" value="<%=livro.getLivro_id()%>" name="codigo" size="100" maxlength="100" <%=readOnly%>></td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Título</td>
				<td><input type="text" value="<%=livro.getTitulo()%>" name="titulo" size="100" maxlength="100" <%=readOnly%>></td>
			</tr>
			<tr bgcolor="#EAEAEA">
				<td>Preço</td>
				<td><input type="text" value="<%=livro.getPreco()%>" name="preco" size="10" maxlength="10" <%=readOnly%>></td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Ano</td>
				<td><input type="text" value="<%=livro.getAno()%>" name="ano" size="4" maxlength="4" <%=readOnly%>></td>
			</tr>
			
			<tr bgcolor="#EAEAEA">
				<td>Páginas</td>
				<td><input type="text" value="<%=livro.getPaginas()%>" name="paginas" size="5" maxlength="5" <%=readOnly%>></td>
			</tr>
			<tr bgcolor="#EAEAEA">
				<td>Assunto</td>
				<td>
					<select name="assunto"> 
					<%
						for (int i = 0; i < assuntos.size(); i++) {
							Assunto Assunto = (Assunto)assuntos.get(i);
					%>
		            		<option value="<%=Integer.toString(Assunto.getAssunto_id())%>"> <%=Assunto.getAssunto_nome() %> </option>  
					<% 
					
						}
					%>
					</select>  
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