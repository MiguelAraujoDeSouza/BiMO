package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.MidiaDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarIdMidia"
@WebServlet(name = "buscarTodosMidia", value = "/buscarTodosMidia")
public class BuscarTodosMidia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MidiaDAO midiaDAO = new MidiaDAO();

        // Realiza a busca pela mídia no banco de dados
        ResultSet rs = midiaDAO.buscarTodosMidia();
        StringBuilder lista = new StringBuilder();

        try {
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

            // Inicia a tabela com o cabeçalho
            lista.append("<table>");
            lista.append("<thead><tr>")
                    .append("<th>sId</th>")
                    .append("<th>idProduto</th>")
                    .append("<th>URL Foto</th>")
                    .append("</tr></thead>");

            lista.append("<tbody>");

            // Itera sobre os resultados do ResultSet e preenche a tabela
            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getInt("IDPRODUTO")).append("</td>")
                        .append("<td>").append(rs.getString("CURLFOTO")).append("</td>")
                        .append("</tr>");
            }
            lista.append("</tbody>");
            lista.append("</table>"); // Fecha a tabela
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
