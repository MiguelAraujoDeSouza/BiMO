package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CategoriaCursoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarNomeCategoriaCurso"
@WebServlet(name = "buscarTodosCategoriaCurso", value = "/buscarTodosCategoriaCurso")
public class BuscarTodosCategoriaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cria uma instância do dao para acessar dados da categoria de curso
        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();

        // Busca a categoria de curso pelo nome
        ResultSet rs = categoriaCursoDAO.buscarTodosCategoriaCurso();
        StringBuilder lista = new StringBuilder();

        // Estilo CSS para a tabela

        try {
            // Verifica se o ResultSet contém dados
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

                // Cria a estrutura da tabela
                lista.append("<table>");
                lista.append("<thead><tr>")
                        .append("<th>sId</th>")
                        .append("<th>cNome</th>")
                        .append("<th>transaction_made</th>")
                        .append("<th>bIsUpdated</th>")
                        .append("<th>bIsInactive</th>")
                        .append("</tr></thead>");

                lista.append("<tbody>");

                // Itera sobre os resultados retornados e cria uma linha para cada registro
                while (rs.next()) {
                    lista.append("<tr>");
                    lista.append("<td>").append(rs.getInt("SID")).append("</td>");
                    lista.append("<td>").append(rs.getString("CNOME")).append("</td>");

                    // Para os campos booleanos, podemos exibir "Sim" ou "Não"
                    lista.append("<td>").append(rs.getBoolean("TRANSACTION_MADE") ? "Sim" : "Não").append("</td>");
                    lista.append("<td>").append(rs.getBoolean("BISUPDATED") ? "Sim" : "Não").append("</td>");
                    lista.append("<td>").append(rs.getBoolean("BISINACTIVE") ? "Sim" : "Não").append("</td>");

                    lista.append("</tr>");
                }
                lista.append("</tbody>");
                lista.append("</table>");
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


// Final da tabela HTML
        lista.append("</tbody></table>");


        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
