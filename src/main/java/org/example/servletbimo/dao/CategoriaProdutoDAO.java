package org.example.servletbimo.dao;

import org.example.servletbimo.models.CategoriaProduto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// Classe responsável pela manipulação de categorias de produtos
public class CategoriaProdutoDAO {
    private PreparedStatement pstm; // Objeto para executar comandos SQL
    private Conexao conexao = new Conexao(); // Instância da classe de conexão ao banco de dados

    // Construtor da classe
    public CategoriaProdutoDAO() {}

    // Método para inserir uma nova categoria de produto
    public boolean inserirCategoriaProduto(CategoriaProduto categoriaProduto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            pstm = conexao.getConn().prepareStatement("INSERT INTO CATEGORIAPRODUTO (cNome) VALUES(?)");
            pstm.setString(1, categoriaProduto.getcNome()); // Define o valor do parâmetro CNOME
            return pstm.executeUpdate() > 0; // Executa a inserção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para remover uma categoria pelo SID
    public int removerCategoriaProduto(CategoriaProduto categoriaProduto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para remoção
            pstm = conexao.getConn().prepareStatement("UPDATE CATEGORIAPRODUTO SET bIsInactive = TRUE WHERE sId = ?");
            pstm.setInt(1, categoriaProduto.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o nome de uma categoria
    public int alterarNome(CategoriaProduto categoriaProduto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            pstm = conexao.getConn().prepareStatement("UPDATE CATEGORIAPRODUTO SET cNome = ? WHERE sId = ?");
            pstm.setString(1, categoriaProduto.getcNome()); // Define o valor do novo nome
            pstm.setInt(2, categoriaProduto.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar todas as categorias
    public ResultSet buscarTodasCategoriaProduto() {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO ORDER BY 1");
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    // Método para buscar uma categoria pelo SID
    public ResultSet buscarCategoriaProdutoPorId(CategoriaProduto categoriaProduto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO WHERE sId = ? ORDER BY 1");
            pstm.setInt(1, categoriaProduto.getsId()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    // Método para buscar uma categoria pelo nome
    public ResultSet buscarCategoriaProdutoPorNome(CategoriaProduto categoriaProduto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por nome
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO WHERE CNOME = ? ORDER BY 1");
            pstm.setString(1, categoriaProduto.getcNome()); // Define o valor do parâmetro CNOME
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarTodosCategoriaProduto() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM CATEGORIAPRODUTO ORDER BY 1");
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
