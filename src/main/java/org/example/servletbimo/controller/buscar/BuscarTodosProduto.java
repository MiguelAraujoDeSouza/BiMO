package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.ProdutoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosProduto", value = "/buscarTodosProduto")
public class BuscarTodosProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        StringBuilder lista = new StringBuilder();
        ResultSet rs = produtoDAO.buscarTodosProduto();
        try {
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
            lista.append("<thead>")
                    .append("<tr>")
                    .append("<th>sId</th>")
                    .append("<th>cNome</th>")
                    .append("<th>fValor</th>")
                    .append("<th>cEstado</th>")
                    .append("<th>cDescrição</th>")
                    .append("<th>dDataCriação</th>")
                    .append("<th>idUsuario</th>")
                    .append("<th>idCategoriaProduto</th>")
                    .append("</tr>")
                    .append("</thead>");

            lista.append("<tbody>");
            while (rs.next()) {
                // Formatação de data para exibição amigável
                java.sql.Date dataCriacao = rs.getDate("DDATACRIACAO");
                String dataFormatada = (dataCriacao != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataCriacao) : "";

                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                        .append("<td>").append(rs.getString("CESTADO")).append("</td>")
                        .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                        .append("<td>").append(dataFormatada).append("</td>")
                        .append("<td>").append(rs.getInt("IDUSUARIO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDCATEGORIAPRODUTO")).append("</td>")
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
