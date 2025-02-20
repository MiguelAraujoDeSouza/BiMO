package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CategoriaProdutoDAO;
import org.example.servletbimo.models.CategoriaProduto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/cadastrarCategoriaProduto"
@WebServlet(name = "cadastrarCategoriaProduto", value = "/cadastrarCategoriaProduto")
public class CadastrarCategoriaProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "nome" enviado no formulário de cadastro
        String nome = request.getParameter("nome");

        // Cria um novo objeto CategoriaProduto com o nome capturado
        CategoriaProduto categoriaProduto = new CategoriaProduto(nome);

        // Instancia o dao para realizar a inserção da nova categoria de produto no banco de dados
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        boolean sucesso = categoriaProdutoDAO.inserirCategoriaProduto(categoriaProduto); // Tenta inserir a categoria

        // Define o resultado da operação como atributo da requisição
        if (sucesso) {
            request.setAttribute("resultado", "Cadastro realizado com sucesso!"); // Sucesso na inserção
            // Redireciona a requisição para a página de cadastro
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao cadastrar!"); // Falha na inserção
            request.getRequestDispatcher("/BiMO_Site/index/erro.jsp").forward(request, response);
        }
    }
}
