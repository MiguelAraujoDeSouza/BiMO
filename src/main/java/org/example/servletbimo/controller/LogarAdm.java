package org.example.servletbimo.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.dao.AdministradorDAO;

import java.io.IOException;

@WebServlet(name = "loginjsp", value = "/loginjsp")
public class LogarAdm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministradorDAO administradorDAO = new AdministradorDAO();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        senha = administradorDAO.criptografarSenha(senha);

        // Chama o método para buscar administrador
        if (administradorDAO.BuscarAdministrador(email, senha)) {
            request.getSession().setAttribute("logado",true);
            request.getRequestDispatcher("./BiMO_Site/index/admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("./BiMO_Site/index/erro_login.jsp").forward(request, response);
        }
    }
}