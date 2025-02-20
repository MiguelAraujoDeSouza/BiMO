package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.PlanoPagamentoDAO;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/cadastrarPlano"
@WebServlet(name = "cadastrarPlano", value = "/cadastrarPlano")
public class CadastrarPlanoPagamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instancia o dao para interagir com a tabela de planos de pagamento
        PlanoPagamentoDAO pgDAO = new PlanoPagamentoDAO();

        // Obtém os parâmetros enviados no formulário de cadastro
        String nome = request.getParameter("nome");
        String valorStr = request.getParameter("valor");
        String descricao = request.getParameter("descricao");

        double valorDouble = 0.0; // Inicializa o valor

        // Converte o valor para double, se não for nulo ou vazio
        if (valorStr != null && !valorStr.isEmpty()) {
            try {
                valorDouble = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria um novo objeto PlanoPagamento com os dados capturados
        PlanoPagamento planoPagamento = new PlanoPagamento(descricao, nome, valorDouble);

        // Tenta inserir o plano de pagamento no banco de dados
        boolean success = pgDAO.inserirPlanoPagamento(planoPagamento);

        // Define o resultado da operação como atributo da requisição
        if (success) {
            request.setAttribute("resultado", "Cadastro realizado com sucesso!"); // Sucesso na inserção
            // Redireciona a requisição para a página de cadastro
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao cadastrar!"); // Falha na inserção
            request.getRequestDispatcher("/BiMO_Site/index/erro.jsp").forward(request, response);
        }

    }
}
