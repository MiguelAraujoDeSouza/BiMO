package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CategoriaCursoDAO;
import org.example.servletbimo.models.CategoriaCurso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarNomeCategoriaCurso"
@WebServlet(name = "buscarNomeCategoriaCurso", value = "/buscarNomeCategoriaCurso")
public class BuscarNomeCategoriaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o nome da categoria de curso da requisição
        String nome = request.getParameter("nome");

        // Cria uma nova instância de CategoriaCurso com o nome fornecido
        CategoriaCurso categoriaCurso = new CategoriaCurso(nome);

        // Cria uma instância do dao para acessar dados da categoria de curso
        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();

        // Busca a categoria de curso pelo nome
        ResultSet rs = categoriaCursoDAO.buscarPorNome(categoriaCurso);
        StringBuilder lista = new StringBuilder();

        try {
                // Adiciona o estilo da tabela
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

                // Começa a construção da tabela HTML
                lista.append("<table>");
                lista.append("<tr>")
                        .append("<th>sId</th>")
                        .append("<th>cNome</th>")
                        .append("<th>transaction_made</th>")
                        .append("<th>bIsUpdated</th>")
                        .append("<th>bIsInactive</th>")
                        .append("</tr>");

                // Itera sobre o ResultSet e adiciona os dados à tabela
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
                            .append("</tr>");
                }

                lista.append("</table>");  // Fecha a tabela
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
