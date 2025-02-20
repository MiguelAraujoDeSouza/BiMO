package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException; // Importa a classe para exceções de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para definir um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para manipulação de requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para manipulação de respostas HTTP
import org.example.servletbimo.dao.AdministradorDAO; // Importa a classe dao para interações com a tabela de administradores
import org.example.servletbimo.models.Administrador; // Importa a classe de modelo para o administrador

import java.io.IOException; // Importa a classe de exceções de entrada/saída

// Define o servlet e a URL para acesso
@WebServlet(name = "alterarSenhaAdm", value = "/alterarSenhaAdm")
public class AlterarSenhaAdm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Obtém os parâmetros 'id' e 'senha' da requisição
        String idStr = request.getParameter("id");
        String senha = request.getParameter("senha");

        int idInt = 0;

        // Criptografa a senha recebida
        String senhaCripto = administradorDAO.criptografarSenha(senha);

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

        // Cria uma nova instância de Administrador com os dados recebidos
        Administrador administrador = new Administrador(idInt, senhaCripto, 3);

        // Chama o método para alterar a senha do administrador no banco de dados
        int sucesso = administradorDAO.alterarSenhaAdministrador(administrador);

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
