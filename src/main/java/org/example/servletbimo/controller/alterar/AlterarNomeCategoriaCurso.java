package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException; // Importa a classe para exceções de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para definir um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para manipulação de requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para manipulação de respostas HTTP
import org.example.servletbimo.dao.CategoriaCursoDAO; // Importa a classe dao para interações com a tabela de categorias de cursos
import org.example.servletbimo.models.CategoriaCurso; // Importa a classe de modelo para a categoria do curso

import java.io.IOException; // Importa a classe de exceções de entrada/saída

// Define o servlet e a URL para acesso
@WebServlet(name = "alterarNomeCategoriaCurso", value = "/alterarNomeCategoriaCurso")
public class AlterarNomeCategoriaCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros 'id' e 'nome' da requisição
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");

        int idInt = 0; // Inicializa a variável para armazenar o ID da categoria

        // Verifica se o ID não é nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                // Tenta converter o ID de String para inteiro
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Cria uma nova instância de CategoriaCurso com os dados recebidos
        CategoriaCurso categoriaCurso = new CategoriaCurso(idInt, nome);

        // Instancia o dao para manipular os dados da categoria do curso
        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();

        // Chama o método para alterar o nome da categoria no banco de dados
        int sucesso = categoriaCursoDAO.alterarNome(categoriaCurso);

        // Verifica se a alteração foi bem-sucedida
        if (sucesso > 0) {
            request.setAttribute("resultado", "Alteração realizada com sucesso!"); // Define atributo para sucesso
            // Redireciona para a página de alteração
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao fazer a alteração!"); // Define atributo para erro
            request.getRequestDispatcher("/BiMO_Site/index/erro.jsp").forward(request, response);
        }
    }
}
