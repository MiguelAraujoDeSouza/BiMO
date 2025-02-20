package org.example.servletbimo.controller.buscar;

// Importações necessárias
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.UsuarioDAO;
import org.example.servletbimo.models.Usuario;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet, mapeado para a URL "/buscarEmailUsuario"
@WebServlet(name = "buscarEmailUsuario", value = "/buscarEmailUsuario")
public class BuscarEmailUsuario extends HttpServlet {

    // Método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o email fornecido pelo usuário a partir dos parâmetros da requisição
        String email = request.getParameter("email");

        // Cria um objeto Usuario usando o email
        Usuario usuario = new Usuario(email, 2);

        // Instancia o dao de usuário para interagir com o banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Realiza a busca do usuário pelo email no banco de dados
        ResultSet rs = usuarioDAO.buscarUsuarioPorEmail(usuario);

        // StringBuilder para construir o HTML com os dados do usuário
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
            lista.append("<tr><th>sId</th><th>cEmail</th><th>cTelefone</th><th>dDataNascimento</th><th>cNome</th><th>cSobrenome</th><th>cCNPJ</th><th>cCPF</th><th>dDataCriação</th><th>idPlano</th></tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CEMAIL")).append("</td>")
                        .append("<td>").append(rs.getString("CTELEFONE")).append("</td>")
                        .append("<td>").append(rs.getDate("DDATANASCIMENTO")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getString("CSOBRENOME")).append("</td>")
                        .append("<td>").append(rs.getString("CCNPJ")).append("</td>")
                        .append("<td>").append(rs.getString("CCPF")).append("</td>")
                        .append("<td>").append(rs.getDate("DDATACRIACAO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDPLANO")).append("</td>")
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
