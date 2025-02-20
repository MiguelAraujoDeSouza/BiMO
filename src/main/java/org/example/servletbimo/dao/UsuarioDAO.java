package org.example.servletbimo.dao; // Pacote que contém a classe dao

import org.example.servletbimo.models.Usuario;

import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.ResultSet;
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL

public class UsuarioDAO {

    private Conexao conexao = new Conexao(); // Cria uma nova instância da classe de conexão
    private PreparedStatement pstm; // Declara um PreparedStatement para executar comandos SQL

    // Método para remover um usuário pelo ID
    public int removerUsuario(Usuario user) {
        try {
            conexao.conectar(); // Estabelece a conexão com o banco de dados
            // Prepara a instrução SQL para deletar um usuário com base no seu ID
            pstm = conexao.getConn().prepareStatement("DELETE FROM usuario WHERE SID = ?");
            pstm.setInt(1, user.getsId()); // Define o ID do usuário a ser remo vido
            return pstm.executeUpdate(); // Retorna true se a operação for bem-sucedida
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção para depuração
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Garante que a conexão seja fechada
        }
    }

    public ResultSet buscarUsuarioPorId(Usuario usuario) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
                pstm = conexao.getConn().prepareStatement("SELECT * FROM USUARIO WHERE SID = ? ORDER BY 1");
            pstm.setInt(1, usuario.getsId()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarUsuarioPorNome(Usuario usuario) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            pstm = conexao.getConn().prepareStatement("SELECT * FROM USUARIO WHERE CNOME = ? ORDER BY 1");
            pstm.setString(1, usuario.getcNome()); // Define o valor do parâmetro CNOME
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarUsuarioPorEmail(Usuario usuario) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por NOME
            pstm = conexao.getConn().prepareStatement("SELECT * FROM USUARIO WHERE CEMAIL = ? ORDER BY 1");
            pstm.setString(1, usuario.getcEmail()); // Define o valor do parâmetro CEMAIL
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarUsuarioPorCpf(Usuario usuario) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por CPF
            pstm = conexao.getConn().prepareStatement("SELECT * FROM USUARIO WHERE CCPF = ? ORDER BY 1");
            pstm.setString(1, usuario.getcCpf()); // Define o valor do parâmetro CCPF
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarTodosUsuario() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM USUARIO ORDER BY 1");
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

    public ResultSet buscarUsuarioPorCnpj(Usuario usuario) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por CCNPJ
            pstm = conexao.getConn().prepareStatement("SELECT * FROM USUARIO WHERE CCNPJ = ? ORDER BY 1");
            pstm.setString(1, usuario.getcCnpj()); // Define o valor do parâmetro CCNPJ
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }
}
