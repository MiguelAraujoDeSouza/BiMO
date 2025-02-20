package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CursoDAO;
import org.example.servletbimo.models.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/cadastrarCurso"
@WebServlet(name = "cadastrarCurso", value = "/cadastrarCurso")
public class CadastrarCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros enviados no formulário de cadastro do curso
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String numInscricaoStr = request.getParameter("num-inscricao");
        String valorStr = request.getParameter("valor");
        String statusStr = request.getParameter("status");
        String duracao = request.getParameter("duracao");
        String certificacao = request.getParameter("certificacao");
        String idCategoriaStr = request.getParameter("id-categoria");

        // Inicializa variáveis para armazenar os dados convertidos
        double valorDouble = 0.0;
        int idCategoriaInt = 0;
        int numInscricaoInt = 0;
        boolean statusBool = false;

        // Converte o valor para double, se não for nulo ou vazio
        if (valorStr != null && !valorStr.isEmpty()) {
            try {
                valorDouble = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Converte o ID da categoria para int, se não for nulo ou vazio
        if (idCategoriaStr != null && !idCategoriaStr.isEmpty()) {
            try {
                idCategoriaInt = Integer.parseInt(idCategoriaStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Converte o número de inscrição para int, se não for nulo ou vazio
        if (numInscricaoStr != null && !numInscricaoStr.isEmpty()) {
            try {
                numInscricaoInt = Integer.parseInt(numInscricaoStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Converte o status para boolean, se não for nulo ou vazio
        if (statusStr != null && !statusStr.isEmpty()) {
            statusBool = Boolean.parseBoolean(statusStr.trim());
        }

        // Cria um novo objeto Curso com os dados capturados
        Curso curso = new Curso(idCategoriaInt, nome, valorDouble, descricao, statusBool, numInscricaoInt, duracao, certificacao);

        // Instancia o dao para realizar a inserção do novo curso no banco de dados
        CursoDAO cursoDAO = new CursoDAO();
        boolean sucesso = cursoDAO.inserirCurso(curso); // Tenta inserir o curso

        // Define o resultado da operação como atributo da requisição
        if (sucesso) {
            request.setAttribute("resultado", "Cadastro realizado com sucesso!"); // Sucesso na inserção
            // Redireciona a requisição para a página de cadastro
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);

        } else {
            request.setAttribute("resultado", "Erro ao cadastrar!"); // Falha na inserção
        }
    }
}
