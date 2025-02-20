package org.example.servletbimo.controller.remover;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.PlanoPagamentoDAO; // Importa o dao para manipulação de planos de pagamento
import org.example.servletbimo.models.PlanoPagamento; // Importa o modelo PlanoPagamento

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/removerPlano"
@WebServlet(name = "removerPlano", value = "/removerPlano")
public class RemoverPlano extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "id" enviado no formulário para remoção do plano de pagamento
        String idStr = request.getParameter("id");

        int idInt = 0; // Inicializa o ID

        // Converte o ID para int, se não for nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria um objeto PlanoPagamento com o ID para remoção
        PlanoPagamento planoPagamento = new PlanoPagamento(idInt);

        // Instancia o dao para realizar a remoção do plano de pagamento
        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();
        int sucesso = planoPagamentoDAO.removerPlanoPagamento(planoPagamento); // Tenta remover o plano de pagamento

        // Define o resultado da operação como atributo da requisição
        if (sucesso > 0) {
            request.setAttribute("resultado", "Remoção realizada com sucesso!"); // Sucesso na remoção
            // Redireciona a requisição para a página de remoção
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao remover!"); // Falha na remoção
            request.getRequestDispatcher("/BiMO_Site/index/erro.jsp").forward(request, response);
        }
    }
}
