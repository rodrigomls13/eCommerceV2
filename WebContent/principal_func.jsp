<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal - Funcion�rio</title>
</head>
<body>
<table align="center">
<tr><td><h1>Op��es do Funcion�rio</h1></td></tr>
<tr><td><a href="FuncionarioController?acao=Incluir">Cadastro de Funcion�rio </a> </td></tr>
<tr><td><a href="AutorController?acao=Incluir">Cadastro de Autor</a> </td></tr>
<tr><td><a href="AssuntoController?acao=Incluir">Cadastro de Assunto</a> </td></tr>
<tr><td><a href="LivroController?acao=Incluir">Cadastro de Livros</a> </td></tr>
<tr><td><a href="vincula_livro_autor.jsp">Vincular Autor � Livro</a> </td></tr>

<tr><td><a href="FuncionarioController?acao=Listar">Relat�rio de Funcion�rios </a> </td></tr>
<tr><td><a href="AutorController?acao=Listar">Relat�rio de Autores</a> </td></tr>
<tr><td><a href="AssuntoController?acao=Listar">Relat�rio de Assuntos</a> </td></tr>
<tr><td><a href="LivroController?acao=Listar">Relat�rio de Livros</a> </td></tr>
<tr><td><a href="ClienteController?acao=Listar">Relat�rio de Clientes</a> </td></tr>

</table>
</body>
</html>