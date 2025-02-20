<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BiMO - Alterações</title>
    <link rel="stylesheet" href="../styles/funcoes.css">
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="inicio">
    <div class="iniciobimo">
        <h1>Alteração</h1>
        <br>
        <h2>Altere administradores, categorias e planos facilmente. Mantenha tudo atualizado no BiMO!</h2>
    </div>
    <div id="divimginicio">
        <img src="../image/imagem.png" id="imginicio">
    </div>
    <div id="quadrado"></div>
</div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<br>
<div class="funcoes">
    <!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR ADM-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
    <div class="funcao-hr">
        <h1 class="funcao-title">Administrador</h1>
    </div>
    <br>
    <div class="cardfuncao">
        <input type="checkbox" id="alterar-nome-adm" class="toggle">
        <label for="alterar-nome-adm" class="label-toggle">
            <h2>Nome - Administrador</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarNomeAdm" method="post">
                <label for="id-adm"><h3>ID</h3></label>
                <input type="number" id="id-adm" name="id" required>

                <label for="nome-adm"><h3>Novo Nome</h3></label>
                <input type="text" id="nome-adm" name="nome" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-email-adm" class="toggle">
        <label for="alterar-email-adm" class="label-toggle">
            <h2>Email - Administrador</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarEmailAdm" method="post">
                <label for="id-adm"><h3>ID</h3></label>
                <input type="number" id="id-adm" name="id" required>

                <label for="email-adm"><h3>Email</h3></label>
                <input type="email" id="email-adm" name="email" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-senha-adm" class="toggle">
        <label for="alterar-senha-adm" class="label-toggle">
            <h2>Senha - Administrador</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarSenhaAdm" method="post">
                <label for="id-adm"><h3>ID</h3></label>
                <input type="number" id="id-adm" name="id" required>

                <label for="nome-adm"><h3>Senha</h3></label>
                <input type="password" id="senha-adm" name="senha" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>
    <br>
    <!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR PLANO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
    <div class="funcao-hr">
        <h1 class="funcao-title">Plano</h1>
    </div>
    <br>
    <div class="cardfuncao">
        <input type="checkbox" id="alterar-nome-plano" class="toggle">
        <label for="alterar-nome-plano" class="label-toggle">
            <h2>Nome - Plano</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarNomePlano" method="post">
                <label for="id-plano"><h3>ID</h3></label>
                <input type="number" id="id-plano" name="id" required>

                <label for="nome-plano"><h3>Nome</h3></label>
                <input type="text" id="nome-plano" name="nome" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-valor-plano" class="toggle">
        <label for="alterar-valor-plano" class="label-toggle">
            <h2>Valor - Plano</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarValorPlano" method="post">
                <label for="id-plano"><h3>ID</h3></label>
                <input type="number" id="id-plano" name="id" required>

                <label for="Valor-plano"><h3>Valor</h3></label>
                <input type="number" id="valor-plano" name="valor" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-descricao-plano" class="toggle">
        <label for="alterar-descricao-plano" class="label-toggle">
            <h2>Descrição - Plano</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarDescricaoPlano" method="post">
                <label for="id-plano"><h3>ID</h3></label>
                <input type="number" id="id-plano" name="id" required>

                <label for="descricao-plano"><h3>Descrição</h3></label>
                <input type="text" id="descricao-plano" name="descricao" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>
    <br>
    <!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR CATEGORIA CURSO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
    <div class="funcao-hr">
        <h1 class="funcao-title">Categoria - Curso</h1>
    </div>
    <br>
    <div class="cardfuncao">
        <input type="checkbox" id="alterar-nome-categoria-curso" class="toggle">
        <label for="alterar-nome-categoria-curso" class="label-toggle">
            <h2>Nome - Categoria de Curso</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarNomeCategoriaCurso" method="post">
                <label for="id-categoria-curso"><h3>ID</h3></label>
                <input type="number" id="id-categoria-curso" name="id" required>

                <label for="nome-categoria-curso"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-curso" name="nome" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>
    <br>
    <!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR CATEGORIA PRODUTO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
    <div class="funcao-hr">
        <h1 class="funcao-title">Categoria - Produto</h1>
    </div>
    <br>
    <div class="cardfuncao">
        <input type="checkbox" id="alterar-nome-categoria-produto" class="toggle">
        <label for="alterar-nome-categoria-produto" class="label-toggle">
            <h2>Nome - Categoria de Produto</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarNomeCategoriaProduto" method="post">
                <label for="id-categoria-produto"><h3>ID</h3></label>
                <input type="number" id="id-categoria-produto" name="id" required>

                <label for="nome-categoria-produto"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-produto" name="nome" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>
    <br>
    <!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR MIDIA CURSO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
    <div class="funcao-hr">
        <h1 class="funcao-title">Midia Curso</h1>
    </div>
    <br>
    <div class="cardfuncao">
        <input type="checkbox" id="alterar-id-curso-midia-curso" class="toggle">
        <label for="alterar-id-curso-midia-curso" class="label-toggle">
            <h2>ID Curso - Mídia Curso</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarIdCurso" method="post">
                <label for="id-midia-curso"><h3>ID</h3></label>
                <input type="number" id="id-midia-curso" name="id" required>

                <label for="id-curso"><h3>ID - Curso</h3></label>
                <input type="number" id="id-curso" name="id-curso" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-url-midia-curso" class="toggle">
        <label for="alterar-url-midia-curso" class="label-toggle">
            <h2>URL - Midia Curso</h2>
        </label>
        <div class="form-content">
            <form action="${pageContext.request.contextPath}/alterarUrlMidiaCurso" method="post">
                <label for="id-midia-curso"><h3>ID</h3></label>
                <input type="number" id="id-midia-curso" name="id" required>

                <label for="url-midia-curso"><h3>Valor</h3></label>
                <input type="text" id="url-midia-curso" name="url" required>

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>
</div>
<br><br><br>
</body>
</html>