package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.UsuarioDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarIdUsuario"
@WebServlet(name = "buscarTodosUsuario", value = "/buscarTodosUsuario")
public class BuscarTodosUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Realiza a busca pelo usuário no banco de dados
        ResultSet rs = usuarioDAO.buscarTodosUsuario();
        StringBuilder lista = new StringBuilder();

        try {
            // Verifica se o ResultSet contém resultados

                // Adiciona o estilo CSS para a tabela
                lista.append("<style>");
                lista.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
                lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
                lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
                lista.append("tr:nth-child(even) { background-color: #f9f9f9; }"); // Linhas alternadas
                lista.append("tr:hover { background-color: #e2e2e2; }"); // Efeito hover nas linhas
                lista.append("</style>");

                // Monta a tabela
                lista.append("<table>");
                lista.append("<tr><th>sId</th><th>cEmail</th><th>cTelefone</th><th>dDataNascimento</th><th>cNome</th><th>cSobrenome</th><th>cCNPJ</th><th>cCPF</th><th>dDataCriação</th><th>idPlano</th></tr>");

                while (rs.next()) {
                    // Formatação de datas para exibição amigável
                    java.sql.Date dataNascimento = rs.getDate("DDATANASCIMENTO");
                    String dataNascimentoFormatada = (dataNascimento != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) : "";

                    java.sql.Date dataCriacao = rs.getDate("DDATACRIACAO");
                    String dataCriacaoFormatada = (dataCriacao != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataCriacao) : "";

                    // Adiciona uma linha da tabela para cada usuário
                    lista.append("<tr>");
                    lista.append("<td>").append(rs.getInt("SID")).append("</td>");
                    lista.append("<td>").append(rs.getString("CEMAIL")).append("</td>");
                    lista.append("<td>").append(rs.getString("CTELEFONE")).append("</td>");
                    lista.append("<td>").append(dataNascimentoFormatada).append("</td>");
                    lista.append("<td>").append(rs.getString("CNOME")).append("</td>");
                    lista.append("<td>").append(rs.getString("CSOBRENOME")).append("</td>");
                    lista.append("<td>").append(rs.getString("CCNPJ")).append("</td>");
                    lista.append("<td>").append(rs.getString("CCPF")).append("</td>");
                    lista.append("<td>").append(dataCriacaoFormatada).append("</td>");
                    lista.append("<td>").append(rs.getInt("IDPLANO")).append("</td>");
                    lista.append("</tr>");
                }
                lista.append("</table>"); // Fecha a tabela
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
