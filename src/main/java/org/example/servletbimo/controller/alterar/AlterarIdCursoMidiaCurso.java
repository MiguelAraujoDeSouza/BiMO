package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException; // Importa a classe para exceções de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para definir um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para manipulação de requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para manipulação de respostas HTTP
import org.example.servletbimo.dao.MidiaCursoDAO; // Importa a classe dao para interações com a tabela de mídias de curso
import org.example.servletbimo.models.MidiaCurso; // Importa a classe de modelo para a mídia do curso

import java.io.IOException; // Importa a classe de exceções de entrada/saída

// Define o servlet e a URL para acesso
@WebServlet(name = "alterarIdCurso", value = "/alterarIdCurso")
public class AlterarIdCursoMidiaCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros 'id' e 'id-curso' da requisição
        String idStr = request.getParameter("id");
        String idCursoStr = request.getParameter("id-curso");

        int idInt = 0; // Inicializa a variável para armazenar o ID da mídia
        int idCursoInt = 0; // Inicializa a variável para armazenar o ID do curso

        // Verifica se o ID da mídia não é nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                // Tenta converter o ID da mídia de String para inteiro
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Verifica se o ID do curso não é nulo ou vazio
        if (idCursoStr != null && !idCursoStr.isEmpty()) {
            try {
                // Tenta converter o ID do curso de String para inteiro
                idCursoInt = Integer.parseInt(idCursoStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Cria uma nova instância de MidiaCurso com os dados recebidos
        MidiaCurso midiaCurso = new MidiaCurso(idInt, idCursoInt);

        // Instancia o dao para manipular os dados de mídia do curso
        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();

        // Chama o método para alterar o ID do curso associado à mídia no banco de dados
        int sucesso = midiaCursoDAO.alterarMidiaCursoidCurso(midiaCurso);

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
