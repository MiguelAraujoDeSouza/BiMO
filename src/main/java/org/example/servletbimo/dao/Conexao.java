package org.example.servletbimo.dao;
import java.sql.Connection; // Importa a classe para gerenciar conexões com o banco de dados
import java.sql.DriverManager; // Importa a classe para criar uma conexão com o banco de dados
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL


// Classe responsável por gerenciar a conexão com o banco de dados
public class Conexao {
    private Connection conn;// Objeto para armazenar a conexão com o banco de dados
    // Variáveis para armazenar as credenciais e informações do banco de dados, obtidas a partir de variáveis de ambiente
    String nomeUsusario = System.getenv("NOME_USUARIO_DO_BANCO_DE_DADOS"); // Nome do usuário
    String senhaBanco = System.getenv("SENHA_DO_BANCO_DE_DADOS"); // Senha do banco de dados
    String maintanceBanco = System.getenv("MAINTANCE_DATABASE_BANCO_DE_DADOS"); // Nome do banco de dados
    String portaBanco = System.getenv("PORTA_DO_BANCO_DE_DADOS"); // Porta do banco de dados
    String hostBanco = System.getenv("HOST_BANCO_DE_DADOS"); // Host do banco de dados

    // Método para obter a conexão
    public Connection getConn() {
        return this.conn; // Retorna o objeto de conexão
    }

    // Método para conectar ao banco de dados
    public boolean conectar() {
        try {
            // Registra o driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Estabelece a conexão com o banco de dados usando as informações fornecidas
            conn = DriverManager.getConnection("jdbc:postgresql://" + hostBanco + ":" + portaBanco + "/" + maintanceBanco, nomeUsusario, senhaBanco);
                return true; // Retorna true se a conexão for bem-sucedida
        }
        // Tratamento de exceção para caso o driver não seja encontrado
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace(); // Imprime a pilha de erros
        }
        // Tratamento de exceção para erros de SQL
        catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros
        }
        return false; // Retorna false se a conexão falhar
    }

    // Método para desconectar do banco de dados
    public void desconectar() {
        try {
            // Verifica se a conexão não é nula e se não está fechada
            if (conn != null && !conn.isClosed()) {
                // Fecha a conexão com o banco de dados
                conn.close();
            }
        }
        // Tratamento de exceção para erros de SQL durante a desconexão
        catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros
        }
    }
}
