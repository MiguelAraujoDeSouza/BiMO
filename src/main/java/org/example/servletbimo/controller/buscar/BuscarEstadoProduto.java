package org.example.servletbimo.controller.buscar;

// Importações necessárias
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.ProdutoDAO;
import org.example.servletbimo.models.Produto;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet, mapeado para a URL "/buscarEstadoProduto"
@WebServlet(name = "buscarEstadoProduto", value = "/buscarEstadoProduto")
public class BuscarEstadoProduto extends HttpServlet {

    // Método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o estado do produto informado pelo usuário a partir dos parâmetros da requisição
        String estado = request.getParameter("estado");

        // Cria um objeto Produto utilizando o estado fornecido
        Produto produto = new Produto(estado, 2);

        // Instancia o dao de produto para interagir com o banco de dados
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Realiza a busca dos produtos pelo estado no banco de dados
        ResultSet rs = produtoDAO.buscarProdutoPorEstado(produto);

        // StringBuilder para construir o HTML com os dados do produto
        StringBuilder lista = new StringBuilder();

        try {
            // Adiciona o estilo inline para a tabela
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

            // Monta a lista de resultados em uma tabela HTML
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>cNome</th><th>fValor</th><th>cEstado</th><th>cDescrição</th><th>dDataCriação</th><th>idUsuario</th><th>idCategoriaProduto</th></tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                        .append("<td>").append(rs.getString("CESTADO")).append("</td>")
                        .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                        .append("<td>").append(rs.getDate("DDATACRIACAO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDUSUARIO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDCATEGORIAPRODUTO")).append("</td>")
                        .append("</tr>");
            }

            lista.append("</table>");  // Fecha a tabela
        } catch (SQLException sqle) {
            // Em caso de erro na consulta, adiciona a mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        // Define o resultado da consulta como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP "resultadoBusca.jsp" para exibir o resultado
    }
}
