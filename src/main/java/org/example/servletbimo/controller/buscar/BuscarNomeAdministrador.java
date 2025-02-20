package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarNomeAdm"
@WebServlet(name = "buscarNomeAdm", value = "/buscarNomeAdm")
public class BuscarNomeAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o nome do administrador da requisição
        String nome = request.getParameter("nome");

        // Cria uma nova instância de Administrador com o nome fornecido
        Administrador administrador = new Administrador(nome, 1); // O '1' aqui parece ser um valor fixo, considere se é necessário

        // Cria uma instância do dao para acessar dados do administrador
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Busca o administrador pelo nome
        ResultSet rs = administradorDAO.buscarAdministradorPorNome(administrador);
        StringBuilder lista = new StringBuilder();

        try {
            // Verifica se o ResultSet contém resultados
            if (!rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum usuário encontrado.");
            } else {
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
                        .append("<th>cEmail</th>")
                        .append("</tr>");

                // Itera sobre o ResultSet e adiciona os dados à tabela
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getString("CEMAIL")).append("</td>")
                            .append("</tr>");
                }

                lista.append("</table>");  // Fecha a tabela
            }
        } catch (SQLException sqle) {
            // Em caso de erro, armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
