package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CategoriaProdutoDAO;
import org.example.servletbimo.models.CategoriaProduto;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia o servlet para a URL "/buscarNomeCategoriaProduto"
@WebServlet(name = "buscarNomeCategoriaProduto", value = "/buscarNomeCategoriaProduto")
public class BuscarNomeCategoriaProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o nome da categoria de produto da requisição
        String nome = request.getParameter("nome");

        // Cria uma nova instância de CategoriaProduto com o nome fornecido
        CategoriaProduto categoriaProduto = new CategoriaProduto(nome);

        // Cria uma instância do dao para acessar dados da categoria de produto
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();

        // Busca a categoria de produto pelo nome
        ResultSet rs = categoriaProdutoDAO.buscarCategoriaProdutoPorNome(categoriaProduto);
        StringBuilder lista = new StringBuilder();

        try {
                // Estilo para melhorar a aparência da tabela
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

                // Inicia a construção da tabela
                lista.append("<table>");
                lista.append("<tr>")
                        .append("<th>sId</th>")
                        .append("<th>cNome</th>")
                        .append("<th>transaction_made</th>")
                        .append("<th>bIsUpdated</th>")
                        .append("<th>bIsInactive</th>")
                        .append("</tr>");

                // Itera sobre os resultados e popula a tabela
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
                            .append("</tr>");
                }

                lista.append("</table>");
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
