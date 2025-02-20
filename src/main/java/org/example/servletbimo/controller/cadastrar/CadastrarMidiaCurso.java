package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.ServletException; // Importa a exceção de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para declarar um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para tratar requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para tratar respostas HTTP
import org.example.servletbimo.dao.MidiaCursoDAO; // Importa a classe de acesso a dados para mídias de curso
import org.example.servletbimo.models.MidiaCurso; // Importa a classe do modelo de mídia de curso

import java.io.IOException; // Importa a classe para exceções de entrada/saída

@WebServlet(name = "cadastrarMidiaCurso", value = "/cadastrarMidiaCurso")
public class CadastrarMidiaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros da requisição
        String idStr = request.getParameter("id");
        String urlFoto = request.getParameter("url-foto");

        int idInt = 0;

        // Converte o ID para inteiro, se fornecido
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria um objeto MidiaCurso com os dados fornecidos
        MidiaCurso midiaCurso = new MidiaCurso(idInt, 2, urlFoto);

        // Cria uma instância do dao para inserir a mídia do curso
        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();
        boolean success = midiaCursoDAO.inserirMidiaCurso(midiaCurso);

        // Define o resultado da operação
        if (success){
            request.setAttribute("resultado", "Cadastro realizado com sucesso!");
            // Redireciona para a página de cadastro
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao cadastrar!");
            request.getRequestDispatcher("/BiMO_Site/index/erro.jsp").forward(request, response);
        }
    }
}
