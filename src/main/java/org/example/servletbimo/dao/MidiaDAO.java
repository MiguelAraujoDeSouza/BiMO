package org.example.servletbimo.dao;

import org.example.servletbimo.models.Midia;

import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.ResultSet;
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL


public class MidiaDAO {
    private Conexao conexao = new Conexao(); // Cria uma nova instância da classe de conexão
    private PreparedStatement pstm; // Declara um PreparedStatement para executar comandos SQL

    // Método para remover um usuário pelo ID
    public int removerMidia(Midia midia){
       try {
            conexao.conectar(); // Estabelece a conexão com o banco de dados
            // Prepara a instrução SQL para deletar um usuário com base no seu ID
            pstm = conexao.getConn().prepareStatement("DELETE FROM MIDIA WHERE SID = ?");
            pstm.setInt(1, midia.getsId()); // Define o ID do usuário a ser remo vido
            return pstm.executeUpdate(); // Retorna true se a operação for bem-sucedida
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção para depuração
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Garante que a conexão seja fechada
        }
    }

    // Método para buscar midia por sId
    public ResultSet buscarMidiaPorId(Midia midia) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            pstm = conexao.getConn().prepareStatement("SELECT * FROM MIDIA WHERE SID = ? ORDER BY 1");
            pstm.setInt(1, midia.getsId()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    // Método para buscar midia por sId
    public ResultSet buscarMidiaPorUrl(Midia midia) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            pstm = conexao.getConn().prepareStatement("SELECT * FROM MIDIA WHERE CURLFOTO = ? ORDER BY 1");
            pstm.setString(1, midia.getcURLFoto()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarTodosMidia() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM MIDIA ORDER BY 1");
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstm.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }
}
