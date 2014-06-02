<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal - Funcionário</title>
</head>
<body>
<table align="center">
<tr><td><h1>Opções do Funcionário</h1></td></tr>
<tr><td><a href="FuncionarioController?acao=Incluir">Cadastro de Funcionário </a> </td></tr>
<tr><td><a href="AutorController?acao=Incluir">Cadastro de Autor</a> </td></tr>
<tr><td><a href="AssuntoController?acao=Incluir">Cadastro de Assunto</a> </td></tr>
<tr><td><a href="LivroController?acao=Incluir">Cadastro de Livros</a> </td></tr>
<tr><td><a href="vincula_livro_autor.jsp">Vincular Autor à Livro</a> </td></tr>

<tr><td><a href="FuncionarioController?acao=Listar">Relatório de Funcionários </a> </td></tr>
<tr><td><a href="AutorController?acao=Listar">Relatório de Autores</a> </td></tr>
<tr><td><a href="AssuntoController?acao=Listar">Relatório de Assuntos</a> </td></tr>
<tr><td><a href="LivroController?acao=Listar">Relatório de Livros</a> </td></tr>
<tr><td><a href="ClienteController?acao=Listar">Relatório de Clientes</a> </td></tr>

</table>
</body>
</html>