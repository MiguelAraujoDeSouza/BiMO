package org.example.servletbimo.dao; // Pacote que contém a classe dao

import org.example.servletbimo.models.Produto;

import java.sql.PreparedStatement; // Importa a classe para preparar instruções SQL
import java.sql.ResultSet;
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL

public class ProdutoDAO {
    private Conexao conexao = new Conexao(); // Cria uma instância da classe de conexão
    private PreparedStatement pstm; // Declara um PreparedStatement para executar comandos SQL

    // Método para remover um produto pelo ID
    public int removerProduto(Produto produto) {
        try {
            conexao.conectar(); // Estabelece a conexão com o banco de dados
            // Prepara a instrução SQL para deletar um produto com base no seu ID
            pstm = conexao.getConn().prepareStatement("DELETE FROM produto WHERE sId = ?");
            pstm.setInt(1, produto.getsId()); // Define o ID do produto a ser removido
            return pstm.executeUpdate();
        } catch (SQLException sqle) { // Trata exceções relacionadas ao SQL
            sqle.printStackTrace(); // Imprime a stack trace da exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Garante que a conexão seja fechada
        }
    }

    public ResultSet buscarProdutoPorId(Produto produto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            pstm = conexao.getConn().prepareStatement("SELECT * FROM PRODUTO WHERE SID = ? ORDER BY 1");
            pstm.setInt(1, produto.getsId()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            // Não fecha a conexão aqui, pois o ResultSet ainda pode ser utilizado
        }
    }

    public ResultSet buscarProdutoPorNome(Produto produto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por NOME
            pstm = conexao.getConn().prepareStatement("SELECT * FROM PRODUTO WHERE CNOME = ? ORDER BY 1");
            pstm.setString(1, produto.getcNome()); // Define o valor do parâmetro CNOME
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            // Não fecha a conexão aqui, pois o ResultSet ainda pode ser utilizado
        }
    }

    public ResultSet buscarTodosProduto() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM PRODUTO ORDER BY 1");
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

    public ResultSet buscarProdutoPorEstado(Produto produto) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ESTADO
            pstm = conexao.getConn().prepareStatement("SELECT * FROM PRODUTO WHERE CESTADO = ? ORDER BY 1");
            pstm.setString(1, produto.getcEstado()); // Define o valor do parâmetro CESTADO
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            // Não fecha a conexão aqui, pois o ResultSet ainda pode ser utilizado
        }
    }
}
