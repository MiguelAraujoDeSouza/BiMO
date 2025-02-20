<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>BiMO - Remoções</title>
	<link rel="stylesheet" href="../styles/funcoes.css">
	<link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="inicio">
	<div class="iniciobimo">
		<h1>Remoção</h1>
		<br>
		<h2>Remova administradores, categorias e planos com rapidez e segurança. Simplifique a gestão do BiMO!</h2>
	</div>
	<div id="divimginicio">
		<img src="../image/imagem.png" id="imginicio">
	</div>
	<div id="quadrado"></div>
</div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=REMOVER-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="funcoes">
	<br>
	<div class="cardfuncao">
		<input type="checkbox" id="remover-adm" class="toggle">
		<label for="remover-adm" class="label-toggle">
			<h2>Administrador</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerAdm" method="post">
				<label for="id-adm"><h3>ID</h3></label>
				<input type="number" id="id-adm" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-plano" class="toggle">
		<label for="remover-plano" class="label-toggle">
			<h2>Plano</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerPlano" method="post">
				<label for="id-plano"><h3>ID</h3></label>
				<input type="number" id="id-plano" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-categoria-curso" class="toggle">
		<label for="remover-categoria-curso" class="label-toggle">
			<h2>Categoria de Curso</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerCategoriaCurso" method="post">
				<label for="id-categoria-curso"><h3>ID</h3></label>
				<input type="number" id="id-categoria-curso" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-categoria-produto" class="toggle">
		<label for="remover-categoria-produto" class="label-toggle">
			<h2>Categoria de Produto</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerCategoriaProduto" method="post">
				<label for="id-categoria-produto"><h3>ID</h3></label>
				<input type="number" id="id-categoria-produto" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-usuario" class="toggle">
		<label for="remover-usuario" class="label-toggle">
			<h2>Usuário</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerUsuario" method="post">
				<label for="id-usuario"><h3>ID</h3></label>
				<input type="number" id="id-usuario" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-produto" class="toggle">
		<label for="remover-produto" class="label-toggle">
			<h2>Produto</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerProduto" method="post">
				<label for="id-produto"><h3>ID</h3></label>
				<input type="number" id="id-produto" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-curso" class="toggle">
		<label for="remover-curso" class="label-toggle">
			<h2>Curso</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerCurso" method="post">
				<label for="id-curso"><h3>ID</h3></label>
				<input type="number" id="id-curso" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-midia" class="toggle">
		<label for="remover-midia" class="label-toggle">
			<h2>Mídia</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerMidia" method="post">
				<label for="id-midia"><h3>ID</h3></label>
				<input type="number" id="id-midia" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>

	<div class="cardfuncao">
		<input type="checkbox" id="remover-midia-curso" class="toggle">
		<label for="remover-midia-curso" class="label-toggle">
			<h2>Mídia - Curso</h2>
		</label>
		<div class="form-content">
			<form action="${pageContext.request.contextPath}/removerMidiaCurso" method="post">
				<label for="id-midia-curso"><h3>ID</h3></label>
				<input type="number" id="id-midia-curso" name="id" required>

				<button type="submit"><h3>Remover</h3></button>
			</form>
		</div>
	</div>
</div>
<br><br><br>
</body>
</html>