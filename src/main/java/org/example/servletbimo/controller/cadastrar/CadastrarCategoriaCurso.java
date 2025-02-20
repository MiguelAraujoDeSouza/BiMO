package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.CategoriaCursoDAO;
import org.example.servletbimo.models.CategoriaCurso;

import java.io.IOException;

// Define a servlet que responde a requisições no caminho "/cadastrarCategoriaCurso"
@WebServlet(name = "cadastrarCategoriaCurso", value = "/cadastrarCategoriaCurso")
public class CadastrarCategoriaCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "nome" enviado no formulário de cadastro
        String nome = request.getParameter("nome");

        // Cria um novo objeto CategoriaCurso com o nome capturado
        CategoriaCurso categoriaCurso = new CategoriaCurso(nome);

        // Instancia o dao para realizar a inserção da nova categoria de curso no banco de dados
        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();
        boolean sucesso = categoriaCursoDAO.inserirCategoriaCurso(categoriaCurso); // Tenta inserir a categoria

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
