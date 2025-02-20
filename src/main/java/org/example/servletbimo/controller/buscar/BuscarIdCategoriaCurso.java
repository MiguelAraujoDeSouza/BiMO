package org.example.servletbimo.controller.buscar;

// Importações necessárias
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

// Declaração do servlet, mapeado para a URL "/buscarIdCategoriaCurso"
@WebServlet(name = "buscarIdCategoriaCurso", value = "/buscarIdCategoriaCurso")
public class BuscarIdCategoriaCurso extends HttpServlet {

    // Método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID da categoria do curso informado pelo usuário
        String idStr = request.getParameter("id");

        int idInt = 0;
        // Converte o ID para int, caso não seja nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria um objeto CategoriaCurso utilizando o ID fornecido
        CategoriaCurso categoriaCurso = new CategoriaCurso(idInt);

        // Instancia o dao de categoria de curso para interagir com o banco de dados
        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();

        // Realiza a busca da categoria de curso pelo ID no banco de dados
        ResultSet rs = categoriaCursoDAO.buscarPorId(categoriaCurso);

        // StringBuilder para construir o HTML com os dados da categoria do curso
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
            lista.append("<tr><th>sId</th><th>cNome</th><th>transaction_made</th><th>bIsUpdated</th><th>bIsInactive</th></tr>");

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
            // Em caso de erro na consulta, adiciona a mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        // Define o resultado da consulta como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP "resultadoBusca.jsp" para exibir o resultado

    }
}
