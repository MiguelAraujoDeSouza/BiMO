package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.MidiaCursoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosMidiaCurso", value = "/buscarTodosMidiaCurso")
public class BuscarTodosMidiaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();
        StringBuilder lista = new StringBuilder();
        ResultSet rs = midiaCursoDAO.buscarTodosMidiaCurso();

        try {
            // Adiciona o estilo CSS diretamente na página (caso não tenha arquivo separado)
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

            // Monta a lista de resultados em uma tabela
            lista.append("<table>");
            lista.append("<thead><tr>")
                    .append("<th>sId</th>")
                    .append("<th>idProduto</th>")
                    .append("<th>cUrlFoto</th>")
                    .append("<th>transaction_made</th>")
                    .append("<th>bIsUpdated</th>")
                    .append("<th>bIsInactive</th>")
                    .append("</tr></thead>");

            lista.append("<tbody>");
            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getInt("IDCURSO")).append("</td>")
                        .append("<td>").append(rs.getString("CURLFOTO")).append("</td>")
                        .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
                        .append("</tr>");
            }
            lista.append("</tbody>");
            lista.append("</table>"); // Fecha a tabela

        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
