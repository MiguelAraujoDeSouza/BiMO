package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.ProdutoDAO;
import org.example.servletbimo.models.Produto;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarNomeProduto", value = "/buscarNomeProduto")
public class BuscarNomeProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        // Validação da entrada
        if (nome == null || nome.trim().isEmpty()) {
            request.setAttribute("resultado", "O nome do produto não pode ser vazio.");
            request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
            return;
        }

        Produto produto = new Produto(nome, 1);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        StringBuilder lista = new StringBuilder();
        ResultSet rs = produtoDAO.buscarProdutoPorNome(produto);
        try{
            // Adiciona estilo CSS para a tabela
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

            // Monta a lista de resultados
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>cNome</th><th>fValor</th><th>cEstado</th><th>cDescrição</th>")
                    .append("<th>dDataCriação</th><th>idUsuario</th><th>idCategoriaProduto</th></tr>");

            while (rs.next()) {
                // Formata a data de criação para ser mais legível
                java.sql.Date dataCriacao = rs.getDate("DDATACRIACAO");
                String dataFormatada = (dataCriacao != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataCriacao) : "Data não disponível";

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
            lista.append("</table>");
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro ao consultar o banco de dados: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
