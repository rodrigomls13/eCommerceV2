<%@page import="ecommerce.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="autores" class="java.util.Vector" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Autores</title>
</head>
<body>
	<center>
		<h1>Listagem de Autores</h1>
		<table border="0">
			<tr bgcolor="#BABABA">
				<th align="left">Ação</th>
				<th align="left">Código</th>
				<th align="left">Nome</th>
			</tr>
			<%
				for (int i = 0; i < autores.size(); i++) {
					Autor Autor = (Autor)autores.get(i);
			%>
					<tr bgcolor="#EAEAEA">
						<td>
							<input type="button" value="Alterar" onclick="document.location='AutorController?acao=Alterar&codigo=<%=Autor.getAutor_id() %>'" />
							<input type="button" value="Excluir" onclick="document.location='AutorController?acao=Excluir&codigo=<%=Autor.getAutor_id() %>'" />
						 </td>
						<td align="left"><%=Autor.getAutor_id()%></td>
						<td align="left"><%=Autor.getAutor_nome()%></td>
					</tr>
			<%
				}
			%>
			<tr bgcolor="#BABABA">
			<td colspan="3" align="left">
				 <input type="button" value="Incluir" width="70pt" onclick="document.location='AutorController?acao=Incluir&codigo=<%=0 %>'" />
			</td>
			<td>
				<input type="button" name="Inicio"  width="70pt" value="Inicio" onclick="document.location='index.jsp'">
			</td>
			</table>
	</center>
</body>
</html>
