<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BiMO - Cadastros</title>
    <link rel="stylesheet" href="../styles/funcoes.css">
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INICIO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="inicio">
    <div class="iniciobimo">
        <h1>Cadastro</h1>
        <br>
        <h2>Cadastre novos admins, categorias e planos de forma rápida e prática. Gerencie tudo em um só lugar!</h2>
    </div>
    <div id="divimginicio">
        <img src="../image/imagem.png" id="imginicio">
    </div>
    <div id="quadrado"></div>
</div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CADASTRAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="cardfuncao">
    <input type="checkbox" id="cadastrar-adm" class="toggle">
    <label for="cadastrar-adm" class="label-toggle">
        <h2>Novo Administrador</h2>
    </label>
    <div class="form-content">
        <form action="${pageContext.request.contextPath}/cadastrarAdm" method="post">
            <label for="nome-adm"><h3>Nome</h3></label>
            <input type="text" id="nome-adm" name="nome" required>

            <label for="email-adm"><h3>Email</h3></label>
            <input type="email" id="email-adm" name="email" required>

            <label for="senha-adm"><h3>Senha</h3></label>
            <input type="password" id="senha-adm" name="senha" minlength="8" required>

            <p>${resultado}</p>

            <button type="submit"><h3>Cadastrar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="cadastrar-plano" class="toggle">
    <label for="cadastrar-plano" class="label-toggle">
        <h2>Novo Plano</h2>
    </label>
    <div class="form-content">
        <form action="${pageContext.request.contextPath}/cadastrarPlano" method="post">
            <label for="nome-plano"><h3>Nome</h3></label>
            <input type="text" id="nome-plano" name="nome" required>

            <label for="valor-plano"><h3>Valor</h3></label>
            <input type="number" id="valor-plano" name="valor" step="0.01" required>

            <label for="descricao-plano"><h3>Descrição</h3></label>
            <input type="text" id="descricao-plano" name="descricao" required>

            <button type="submit"><h3>Cadastrar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="cadastrar-categoria-curso" class="toggle">
    <label for="cadastrar-categoria-curso" class="label-toggle">
        <h2>Nova Categoria de Curso</h2>
    </label>
    <div class="form-content">
        <form action="${pageContext.request.contextPath}/cadastrarCategoriaCurso" method="post">
            <label for="nome-categoria-curso"><h3>Nome</h3></label>
            <input type="text" id="nome-categoria-curso" name="nome" required>

            <button type="submit"><h3>Cadastrar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="cadastrar-categoria-produto" class="toggle">
    <label for="cadastrar-categoria-produto" class="label-toggle">
        <h2>Nova Categoria de Produto</h2>
    </label>
    <div class="form-content">
        <form action="${pageContext.request.contextPath}/cadastrarCategoriaProduto" method="post">
            <label for="nome-categoria-produto"><h3>Nome</h3></label>
            <input type="text" id="nome-categoria-produto" name="nome" required>

            <button type="submit"><h3>Cadastrar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="cadastrar-curso" class="toggle">
    <label for="cadastrar-curso" class="label-toggle">
        <h2>Novo Curso</h2>
    </label>
    <div class="form-content">
        <form action="${pageContext.request.contextPath}/cadastrarCurso" method="post">
            <label for="nome-curso"><h3>Nome</h3></label>
            <input type="text" id="nome-curso" name="nome" required>

            <label for="descricao-curso"><h3>Descrição</h3></label>
            <input type="text" id="descricao-curso" name="descricao" required>

            <label for="numero-inscricao-curso"><h3>Número de Inscrição</h3></label>
            <input type="number" id="numero-inscricao-curso" name="num-inscricao" required>

            <label for="valor-curso"><h3>Valor</h3></label>
            <input type="number" id="valor-curso" name="valor" step="0.01" required>

            <label><h3>Status do Curso</h3></label>
            <div class="status-curso">
                <div class="radio">
                    <input type="radio" name="status" id="status-curso-true" value="true" required>
                    <label for="status-curso-true">true</label>
                </div>
                <div class="radio">
                    <input type="radio" name="status" id="status-curso-false" value="false">
                    <label for="status-curso-false">false</label>
                </div>
            </div>

            <label for="duracao-curso"><h3>Duração do Curso</h3></label>
            <input type="text" id="duracao-curso" name="duracao" required>

            <label for="certificacao-curso"><h3>Certificação do Curso</h3></label>
            <input type="text" id="certificacao-curso" name="certificacao" required>

            <label for="id-categoria"><h3>ID da Categoria</h3></label>
            <input type="number" id="id-categoria" name="id-categoria" required>

            <p>${resultado}</p>
            <button type="submit"><h3>Cadastrar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="cadastrar-midia-curso" class="toggle">
    <label for="cadastrar-midia-curso" class="label-toggle">
        <h2>Nova Mídia de Curso</h2>
    </label>
    <div class="form-content">
        <form action="${pageContext.request.contextPath}/cadastrarMidiaCurso" method="post">
            <label for="id-curso"><h3>ID Curso</h3></label>
            <input type="number" id="id-curso" name="id" required>

            <label for="url-foto"><h3>URL - Foto</h3></label>
            <input type="text" id="url-foto" name="url" required>

            <button type="submit"><h3>Cadastrar</h3></button>
        </form>
    </div>
</div>

<br><br><br>
</body>
</html>