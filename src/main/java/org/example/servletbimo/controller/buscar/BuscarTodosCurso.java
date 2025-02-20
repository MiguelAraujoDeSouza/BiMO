package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CursoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosCurso", value = "/buscarTodosCurso")
public class BuscarTodosCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CursoDAO cursoDAO = new CursoDAO();
        StringBuilder lista = new StringBuilder();
        ResultSet rs = cursoDAO.buscarTodosCursos();

        try  {
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");
                // Monta a tabela com o cabeçalho
                lista.append("<table>");
                lista.append("<thead><tr>")
                        .append("<th>sId</th>")
                        .append("<th>cNome</th>")
                        .append("<th>fValor</th>")
                        .append("<th>cDuração</th>")
                        .append("<th>cDescrição</th>")
                        .append("<th>cCertificação</th>")
                        .append("<th>bStatus</th>")
                        .append("<th>iNúmero Inscrição</th>")
                        .append("<th>idCategoriaCurso</th>")
                        .append("<th>transaction_made</th>")
                        .append("<th>bIsUpdated</th>")
                        .append("<th>bIsInactive</th>")
                        .append("</tr></thead>");

                lista.append("<tbody>");

                // Itera sobre os resultados e preenche a tabela
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                            .append("<td>").append(rs.getString("CDURACAO")).append("</td>")
                            .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                            .append("<td>").append(rs.getString("CCERTIFICACAO")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BSTATUS") ? "Sim" : "Não").append("</td>")
                            .append("<td>").append(rs.getInt("INUMEROINSCRICAO")).append("</td>")
                            .append("<td>").append(rs.getInt("IDCATEGORIACURSO")).append("</td>")
                            .append("<td>").append(rs.getBoolean("TRANSACTION_MADE") ? "Sim" : "Não").append("</td>")
                            .append("<td>").append(rs.getBoolean("BISUPDATED") ? "Sim" : "Não").append("</td>")
                            .append("<td>").append(rs.getBoolean("BISINACTIVE") ? "Sim" : "Não").append("</td>")
                            .append("</tr>");
                }
                lista.append("</tbody>");
                lista.append("</table>");
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
