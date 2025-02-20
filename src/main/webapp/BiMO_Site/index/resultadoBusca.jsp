<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado - Busca</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <title>Admin BiMO</title>
    <link rel="stylesheet" href="./BiMO_Site/styles/resultadoBusca.css">
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        #seta{
            font-size: 300%;
            padding: 0.5%;
            color: #23C2FF;
        }
    </style>
</head>
<body>
<div id="pagelogin">
    <a href="./busca.jsp" id="seta"><p>⬅️</p></a>
</div>
<h1>Resultado da Busca</h1>
<div class="resultado">
    ${resultado}
</div>
</body>
</html>
