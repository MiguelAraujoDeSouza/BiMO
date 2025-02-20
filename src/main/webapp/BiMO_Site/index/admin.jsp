<!DOCTYPE html>
<html lang="pt-br">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Object logado = request.getSession().getAttribute("logado");

	if (logado == null) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}%>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1, width=device-width">
	<title>Admin BiMO</title>
	<link rel="stylesheet" href="./BiMO_Site/styles/admin.css">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
	<link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
</head>
<body>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INICIO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="inicio">
	<div class="iniciobimo">
		<h1>Bem Vindo(a)!</h1>
		<br>
		<h2>Controle e gerencie tudo para promover uma experiência única ao usuário.</h2>
	</div>
	<div id="divimginicio">
		<img src="./BiMO_Site/image/imagem.png" id="imginicio">
	</div>
	<div id="quadrado"></div>
</div>

<div class="container">
	<h1>O que você fará hoje?</h1>

	<div class="opcoes">
		<a href="./BiMO_Site/index/cadastro.jsp">Cadastrar</a>
		<a href="./BiMO_Site/index/remocao.jsp">Remover</a>
		<a href="./BiMO_Site/index/alteracao.jsp">Alterar</a>
		<a href="./BiMO_Site/index/busca.jsp">Buscar</a>
		<a href="https://restrictedareaweb.onrender.com">Dashboard de BI</a>
	</div>
</div>

<br><br><br><br><br>


</body>
</html>
