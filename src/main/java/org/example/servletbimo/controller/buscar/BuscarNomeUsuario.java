package org.example.servletbimo.controller.buscar;

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

@WebServlet(name = "buscarNomeUsuario", value = "/buscarNomeUsuario")
public class BuscarNomeUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        // Validação da entrada
        if (nome == null || nome.trim().isEmpty()) {
            request.setAttribute("resultado", "O nome do usuário não pode ser vazio.");
            request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario(nome, 1);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        StringBuilder lista = new StringBuilder();

        try (ResultSet rs = usuarioDAO.buscarUsuarioPorNome(usuario)) {
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
            lista.append("<tr><th>sId</th><th>cEmail</th><th>cTelefone</th><th>dDataNascimento</th>")
                    .append("<th>cNome</th><th>cSobrenome</th><th>cCNPJ</th><th>cCPF</th>")
                    .append("<th>dDataCriação</th><th>idPlano</th></tr>");

            while (rs.next()) {
                // Formata as datas para um formato mais legível
                java.sql.Date dataNascimento = rs.getDate("DDATANASCIMENTO");
                java.sql.Date dataCriacao = rs.getDate("DDATACRIACAO");

                String dataNascimentoFormatada = (dataNascimento != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) : "Data não disponível";
                String dataCriacaoFormatada = (dataCriacao != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataCriacao) : "Data não disponível";

                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CEMAIL")).append("</td>")
                        .append("<td>").append(rs.getString("CTELEFONE")).append("</td>")
                        .append("<td>").append(dataNascimentoFormatada).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getString("CSOBRENOME")).append("</td>")
                        .append("<td>").append(rs.getString("CCNPJ")).append("</td>")
                        .append("<td>").append(rs.getString("CCPF")).append("</td>")
                        .append("<td>").append(dataCriacaoFormatada).append("</td>")
                        .append("<td>").append(rs.getInt("IDPLANO")).append("</td>")
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
