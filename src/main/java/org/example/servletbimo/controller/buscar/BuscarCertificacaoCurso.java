package org.example.servletbimo.controller.buscar;

// Importações necessárias para o funcionamento do servlet e interação com o banco de dados
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CursoDAO;
import org.example.servletbimo.models.Curso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet com o nome "buscarCertificacaoCurso" e mapeamento para a URL "/buscarCertificacaoCurso"
@WebServlet(name = "buscarCertificacaoCurso", value = "/buscarCertificacaoCurso")
public class BuscarCertificacaoCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera o parâmetro "certificacao" enviado na requisição
        String certificacao = request.getParameter("certificacao");

        // Cria um objeto Curso com a certificação fornecida e um valor numérico fixo (2)
        Curso curso = new Curso(certificacao, 2);

        // Cria uma instância de CursoDAO para acessar o banco de dados
        CursoDAO cursoDAO = new CursoDAO();

        // Chama o método buscarPorCertificacao para buscar cursos com a certificação fornecida
        ResultSet rs = cursoDAO.buscarPorCertificacao(curso);

        // StringBuilder para armazenar o HTML gerado com os dados dos cursos
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
            lista.append("<tr><th>sId</th><th>cNome</th><th>fValor</th><th>cDuração</th><th>cDescrição</th>")
                    .append("<th>cCertificação</th><th>bStatus</th><th>iNúmero Inscrição</th><th>idCategoriaCurso</th>")
                    .append("<th>transaction_made</th><th>bIsUpdated</th><th>bIsInactive</th></tr>");
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                            .append("<td>").append(rs.getString("CDURACAO")).append("</td>")
                            .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                            .append("<td>").append(rs.getString("CCERTIFICACAO")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BSTATUS")).append("</td>")
                            .append("<td>").append(rs.getInt("INUMEROINSCRICAO")).append("</td>")
                            .append("<td>").append(rs.getInt("IDCATEGORIACURSO")).append("</td>")
                            .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
                            .append("</tr>");
                }
                lista.append("</table>"); // Fecha a tabela

            }catch (SQLException sqle) {
                // Em caso de erro na consulta, adiciona a mensagem de erro como atributo de requisição
                request.setAttribute("resultado", "Erro: " + sqle.getMessage());
            }

            // Define o resultado gerado como atributo de requisição e encaminha para a página "resultadoBusca.jsp"
            request.setAttribute("resultado", lista.toString());
            request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        }
    }
