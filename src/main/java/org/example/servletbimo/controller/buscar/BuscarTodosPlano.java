package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.PlanoPagamentoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosPlano", value = "/buscarTodosPlano")
public class BuscarTodosPlano extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();
        StringBuilder lista = new StringBuilder();
        ResultSet rs = planoPagamentoDAO.buscarTodosPlanoPagamento();

            try {
                lista.append("<style>");
                lista.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
                lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
                lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
                lista.append("tr:nth-child(even) { background-color: #f9f9f9; }"); // Linhas alternadas
                lista.append("tr:hover { background-color: #e2e2e2; }"); // Efeito hover nas linhas
                lista.append("</style>");

// Monta a lista de resultados em uma tabela
                lista.append("<table>");
                lista.append("<tr><th>sId</th><th>cNome</th><th>cDescricao</th><th>fValor</th>")
                        .append("<th>transaction_made</th><th>bIsUpdated</th><th>bIsInactive</th></tr>");
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                            .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                            .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
                            .append("</tr>");
                }
                lista.append("</table>"); // Fecha a tabela
            } catch (SQLException sqle) {
                // Armazena a mensagem de erro na requisição
                request.setAttribute("resultado", "Erro: " + sqle.getMessage());
            }

        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}