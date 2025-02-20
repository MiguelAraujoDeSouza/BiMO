package org.example.servletbimo.controller.buscar;

// Importações necessárias para a criação do servlet e manipulação de dados
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

// Declaração do servlet "buscarEmailAdm", mapeado para a URL "/buscarEmailAdm"
@WebServlet(name = "buscarEmailAdm", value = "/buscarEmailAdm")
public class BuscarEmailAdministrador extends HttpServlet {

    // Sobrescreve o método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "email" da requisição HTTP
        String email = request.getParameter("email");

        // Cria um objeto Administrador com o email fornecido e um valor numérico fixo (2)
        Administrador administrador = new Administrador(email, 2);

        // Instancia o dao AdministradorDAO para acessar o banco de dados
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Realiza a consulta no banco de dados para buscar o administrador pelo email
        ResultSet rs = administradorDAO.buscarAdministradorPorEmail(administrador);

        // StringBuilder para armazenar o HTML gerado com os resultados
        StringBuilder lista = new StringBuilder();

        // Adiciona o estilo CSS para formatação dos campos
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
            lista.append("<tr><th>sId</th><th>cNome</th><th>cEmail</th></tr>");
            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getString("CEMAIL")).append("</td>")
                        .append("</tr>");
            }
            lista.append("</table>"); // Fecha a tabela

        } catch (SQLException sqle) {
            // Em caso de erro na consulta, adiciona a mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }



        // Define o HTML gerado como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());

        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha para a página JSP "resultadoBusca.jsp" para exibir o resultado

    }
}
