<%@page import="ecommerce.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="clientes" class="java.util.Vector" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de clientes</title>
</head>
<body>
	<center>
		<h1>Listagem de Clientes</h1>
		<table border="0">
			<tr bgcolor="#BABABA">
				<th align="left">Ação</th>
				<th align="left">Código</th>
				<th align="left">Nome</th>
				<th align="left">E-mail</th>
				<th align="left">Senha</th>
			</tr>
			<%
				for (int i = 0; i < clientes.size(); i++) {
					Cliente cliente = (Cliente)clientes.get(i);
			%>
					<tr bgcolor="#EAEAEA">
						<td>
							<input type="button" value="Alterar" onclick="document.location='ClienteController?acao=Alterar&codigo=<%=cliente.getCliente_id() %>'" />
							<input type="button" value="Excluir" onclick="document.location='ClienteController?acao=Excluir&codigo=<%=cliente.getCliente_id() %>'" />
						 </td>
						<td align="left"><%=cliente.getCliente_id()%></td>
						<td align="left"><%=cliente.getCliente_nome()%></td>
						<td align="left"><%=cliente.getEmail()%></td>
						<td align="left"><%=cliente.getSenha()%></td>
					</tr>
			<%
				}
			%>
			<tr bgcolor="#BABABA">
			<td colspan="3" align="left">
				 <input type="button" value="Incluir" width="70pt" onclick="document.location='ClienteController?acao=Incluir&codigo=<%=0 %>'" />
			</td>
			<td>
				<input type="button" name="Inicio"  width="70pt" value="Inicio" onclick="document.location='index.jsp'">
			</td>
			</table>
	</center>
</body>
</html>
