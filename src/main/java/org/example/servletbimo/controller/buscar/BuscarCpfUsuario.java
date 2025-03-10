package org.example.servletbimo.controller.buscar;

// Importações para funcionamento do servlet e interação com o banco de dados
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

// Declaração do servlet com o nome "buscarCpfUsuario" e mapeamento para a URL "/buscarCpfUsuario"
@WebServlet(name = "buscarCpfUsuario", value = "/buscarCpfUsuario")
public class BuscarCpfUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera o parâmetro "cpf" enviado na requisição
        String cpf = request.getParameter("cpf");

        // Cria um objeto Usuario com o CPF fornecido e um valor numérico fixo (3)
        Usuario usuario = new Usuario(cpf, 3);

        // Cria uma instância de UsuarioDAO para acessar o banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Chama o método buscarUsuarioPorCpf para buscar o usuário pelo CPF
        ResultSet rs = usuarioDAO.buscarUsuarioPorCpf(usuario);

        // StringBuilder para armazenar o HTML gerado com os dados do usuário
        StringBuilder lista = new StringBuilder();

        // Adiciona o estilo CSS para as linhas e colunas
        lista.append("<style>")
                .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                .append("th { background-color: #f2f2f2; font-weight: bold; }")
                .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                .append("tr:hover { background-color: #e2e2e2; }")
                .append("td, th { text-align: center; }")
                .append("</style>");

        try {
            // Itera sobre o ResultSet para extrair os dados dos usuários encontrados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Monta o HTML com os dados do usuário recuperados do banco
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEmail: ").append("</div>").append(rs.getString("CEMAIL")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cTelefone: ").append("</div>").append(rs.getString("CTELEFONE")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("dDataNascimento: ").append("</div>").append(rs.getDate("DDATANASCIMENTO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cSobrenome: ").append("</div>").append(rs.getString("CSOBRENOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cCNPJ: ").append("</div>").append(rs.getString("CCNPJ")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cCPF: ").append("</div>").append(rs.getString("CCPF")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("dDataCriação: ").append("</div>").append(rs.getDate("DDATACRIACAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idPlano: ").append("</div>").append(rs.getInt("IDPLANO")).append("</p>")
                        .append("</div>").append("<br>"); // Usa <br> para criar uma nova linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Em caso de erro na consulta, adiciona a mensagem de erro como atributo de requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        // Define o resultado gerado como atributo de requisição e encaminha para a página "resultadoBusca.jsp"
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
