<%@page import="ecommerce.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="funcionarios" class="java.util.Vector" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de funcionarios</title>
</head>
<body>
	<center>
		<h1>Listagem de Funcionarios</h1>
		<table border="0">
			<tr bgcolor="#BABABA">
				<th align="left">Ação</th>
				<th align="left">Nome</th>
				<th align="left">Login</th>
				<th align="left">Senha</th>
			</tr>
			<%
				for (int i = 0; i < funcionarios.size(); i++) {
					Funcionario funcionario = (Funcionario)funcionarios.get(i);
			%>
					<tr bgcolor="#EAEAEA">
						<td>
							<input type="button" value="Alterar" onclick="document.location='FuncionarioController?acao=Alterar&codigo=<%=funcionario.getLogin() %>'" />
							<input type="button" value="Excluir" onclick="document.location='FuncionarioController?acao=Excluir&codigo=<%=funcionario.getLogin() %>'" />
						 </td>
						<td align="left"><%=funcionario.getFuncionario_nome()%></td>
						<td align="left"><%=funcionario.getLogin()%></td>					
						<td align="left"><%=funcionario.getSenha()%></td>
						
					</tr>
			<%
				}
			%>
			<tr bgcolor="#BABABA">
			<td colspan="3" align="left">
				 <input type="button" value="Incluir" width="70pt" onclick="document.location='FuncionarioController?acao=Incluir&codigo=<%=0 %>'" />
			</td>
			<td>
				<input type="button" name="Inicio"  width="70pt" value="Inicio" onclick="document.location='index.jsp'">
			</td>
			</table>
	</center>
</body>
</html>
