package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CursoDAO;
import org.example.servletbimo.models.Curso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet, mapeado para a URL "/buscarIdCurso"
@WebServlet(name = "buscarIdCurso", value = "/buscarIdCurso")
public class BuscarIdCurso extends HttpServlet {

    // Método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID do curso informado pelo usuário
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

        // Cria um objeto Curso utilizando o ID fornecido
        Curso curso = new Curso(idInt);

        // Instancia o dao de curso para interagir com o banco de dados
        CursoDAO cursoDAO = new CursoDAO();

        // Realiza a busca do curso pelo ID no banco de dados
        ResultSet rs = cursoDAO.buscarPorId(curso);
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
            lista.append("<tr>")
                    .append("<th>sId</th>")
                    .append("<th>cNome</th>")
                    .append("<th>fValor</th>")
                    .append("<th>cDuração</th>")
                    .append("<th>cDescrição</th>")
                    .append("<th>cCertificação</th>")
                    .append("<th>bStatus</th>")
                    .append("<th>iNúmeroInscrição</th>")
                    .append("<th>idCategoriaCurso</th>")
                    .append("<th>transaction_made</th>")
                    .append("<th>bIsUpdated</th>")
                    .append("<th>bIsInactive</th>")
                    .append("</tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                        .append("<td>").append(rs.getString("CDURACAO")).append("</td>")
                        .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                        .append("<td>").append(rs.getString("CCERTIFICACAO")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BSTATUS")).append("</td>")
                        .append("<td>").append(rs.getInt("INUMEROINSCRICAO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDCATEGORIACURSO")).append("</td>")
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
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
