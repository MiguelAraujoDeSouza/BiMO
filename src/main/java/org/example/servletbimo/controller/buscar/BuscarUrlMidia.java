package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.MidiaDAO;
import org.example.servletbimo.models.Midia;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarUrlMidia", value = "/buscarUrlMidia")
public class BuscarUrlMidia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        // Validação da entrada

        Midia midia = new Midia(url);
        MidiaDAO midiaDAO = new MidiaDAO();
        StringBuilder lista = new StringBuilder();
        ResultSet rs = midiaDAO.buscarMidiaPorUrl(midia);
        try  {
            // Verifica se o resultado está vazio

            // Adiciona o estilo CSS para a tabela
            lista.append("<style>");
            lista.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
            lista.append("tr:nth-child(even) { background-color: #f9f9f9; }"); // Linhas alternadas
            lista.append("tr:hover { background-color: #e2e2e2; }"); // Efeito hover nas linhas
            lista.append("</style>");

            // Monta a lista de resultados em uma tabela
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>idProduto</th><th>cUrlFoto</th></tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getInt("IDPRODUTO")).append("</td>")
                        .append("<td>").append(rs.getString("CURLFOTO")).append("</td>")
                        .append("</tr>");
            }
            lista.append("</table>");
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
