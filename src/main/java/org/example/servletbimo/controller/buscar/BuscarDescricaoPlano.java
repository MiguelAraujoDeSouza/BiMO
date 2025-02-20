package org.example.servletbimo.controller.buscar;

// Importações necessárias para a criação do servlet e para manipulação do banco de dados
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.PlanoPagamentoDAO;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet "buscarDescricaoPlano", mapeado para a URL "/buscarDescricaoPlano"
@WebServlet(name = "buscarDescricaoPlano", value = "/buscarDescricaoPlano")
public class BuscarDescricaoPlano extends HttpServlet {

    // Sobrescreve o método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "descricao" do pedido HTTP
        String descricao = request.getParameter("descricao");

        // Cria um objeto PlanoPagamento com a descrição fornecida e um valor numérico fixo (2)
        PlanoPagamento planoPagamento = new PlanoPagamento(descricao, 2);

        // Instancia o dao PlanoPagamentoDAO para acesso ao banco de dados
        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();

        // Realiza a consulta no banco de dados para buscar o plano de pagamento pela descrição
        ResultSet rs = planoPagamentoDAO.buscarPlanoPagamentoPorDescricao(planoPagamento);

        // StringBuilder para armazenar o HTML gerado a partir dos resultados
        StringBuilder lista = new StringBuilder();

        // Adiciona o estilo CSS para formatação dos campos
        lista.append("<style>")
                .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                .append("th { background-color: #f2f2f2; font-weight: bold; }")
                .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                .append("tr:hover { background-color: #e2e2e2; }")
                .append("td, th { text-align: center; }")
                .append("</style>");

        try {
            // Adiciona o estilo inline para a tabela
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; font-family: Arial, sans-serif; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; font-size: 14px; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; color: #333; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("</style>");

            // Monta a lista de resultados em uma tabela HTML
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>cNome</th><th>cDescricao</th><th>fValor</th><th>transaction_made</th><th>bIsUpdated</th><th>bIsInactive</th></tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                        .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                        .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
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

    }
}
