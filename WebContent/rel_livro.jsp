<%@page import="ecommerce.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="livros" class="java.util.Vector" scope="request"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Livros</title>
</head>
<body>
	<center>
		<h1>Listagem de Livros</h1>
		<table border="0">
			<tr bgcolor="#BABABA">
				<th align="left">Ação</th>
				<th align="left">Codigo</th>
				<th align="left">Titulo</th>
				<th align="left">Preço</th>
				<th align="left">Ano</th>
				<th align="left">Páginas</th>
				<th align="left">Assunto</th>
			</tr>
			<%
				for (int i = 0; i < livros.size(); i++) {
					Livro livro = (Livro)livros.get(i);
				
			%>
					<tr bgcolor="#EAEAEA">
						<td>
							<input type="button" value="Alterar" onclick="document.location='LivroController?acao=Alterar&codigo=<%=livro.getLivro_id() %>'" />
							<input type="button" value="Excluir" onclick="document.location='LivroController?acao=Excluir&codigo=<%=livro.getLivro_id() %>'" />
						 </td>
						<td align="left"><%=livro.getLivro_id()%></td>
						<td align="left"><%=livro.getTitulo()%></td>					
						<td align="left"><%=livro.getPreco()%></td>
						<td align="left"><%=livro.getAno()%></td>
						<td align="left"><%=livro.getPaginas()%></td>
						<td align="left"><%=AssuntoADO.getById2(livro.getAssunto_id())%></td>
		
					</tr>
			<%
				}
			%>
			<tr bgcolor="#BABABA">
			<td colspan="3" align="left">
				 <input type="button" value="Incluir" width="70pt" onclick="document.location='LivroController?acao=Incluir&codigo=<%=0 %>'" />
			</td>
			<td>
				<input type="button" name="Inicio"  width="70pt" value="Inicio" onclick="document.location='index.jsp'">
			</td>
			</table>
	</center>
</body>
</html>
