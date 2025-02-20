package org.example.servletbimo.dao;

import org.example.servletbimo.models.PlanoPagamento;

import java.sql.PreparedStatement; // Importa a classe para executar instruções SQL preparadas
import java.sql.ResultSet; // Importa a classe para manipular resultados de consultas SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL



// Classe responsável pela manipulação de planos de pagamento
public class PlanoPagamentoDAO {
    private PreparedStatement pstm; // Objeto para executar comandos SQL preparados
    private Conexao conexao = new Conexao();// Instância da classe de conexão com o banco de dados;

    // Construtor da classe
    public PlanoPagamentoDAO() {
    }

    // Método para inserir um novo plano de pagamento
    public boolean inserirPlanoPagamento(PlanoPagamento planoP) {
        this.conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para inserção
            this.pstm = this.conexao.getConn().prepareStatement("INSERT INTO PLANO (CNOME, CDESCRICAO, FVALOR) VALUES(?,?,?)");
            // Define os valores dos parâmetros
            this.pstm.setString(1, planoP.getcNome());
            this.pstm.setString(2, planoP.getcDescricao());
            this.pstm.setDouble(3, planoP.getfValor());
            // Executa a inserção e retorna o número de linhas afetadas
            return pstm.executeUpdate() > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o valor por ID
    public int alterarNomePlanoPagamento(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do valor
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE PLANO SET CNOME = ? WHERE SID = ?");
            // Define os parâmetros
            pstm.setString(1, planoP.getcNome()); // Atualiza o valor
            pstm.setInt(2, planoP.getsId()); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a descrição por ID
    public int alterarDescricaoPlanoPagamento(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização da descrição
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE PLANO SET CDESCRICAO = ? WHERE SID = ?");
            // Define os parâmetros
            pstm.setString(1, planoP.getcDescricao()); // Atualiza a descrição
            pstm.setInt(2, planoP.getsId()); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o valor por ID
    public int alterarValorPlanoPagamento(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do valor
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE PLANO SET FVALOR = ? WHERE SID = ?");
            // Define os parâmetros
            pstm.setDouble(1, planoP.getfValor()); // Atualiza o valor
            pstm.setInt(2, planoP.getsId()); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para remover um plano de pagamento por ID
    public int removerPlanoPagamento(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para remoção
            this.pstm = conexao.getConn().prepareStatement("UPDATE PLANO SET bisInactive = true WHERE sId = ?");
            // Define o parâmetro
            pstm.setInt(1, planoP.getsId()); // Define o ID do plano a ser removido
            // Executa a remoção e retorna o número de linhas afetadas
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar todos os planos de pagamento
    public ResultSet buscarTodosPlanoPagamento() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM PLANO ORDER BY 1");
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

    // Método para buscar um plano de pagamento por ID
    public ResultSet buscarPlanoPagamentoPorId(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por ID
            this.pstm = conexao.getConn().prepareStatement("SELECT * from PLANO WHERE SID = ? ORDER BY 1");
            pstm.setInt(1, planoP.getsId()); // Define o ID do plano a ser buscado
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

    // Método para buscar um plano de pagamento por NOME
    public ResultSet buscarPlanoPagamentoPorNome(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por ID
            this.pstm = conexao.getConn().prepareStatement("SELECT * from PLANO WHERE CNOME = ? ORDER BY 1");
            pstm.setString(1, planoP.getcNome()); // Define o NOME do plano a ser buscado
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

    // Método para buscar um plano de pagamento por valor
    public ResultSet buscarPlanoPagamentoPorValor(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por valor
            this.pstm = conexao.getConn().prepareStatement("SELECT * from PLANO WHERE FVALOR = ? ORDER BY 1");
            pstm.setDouble(1, planoP.getfValor()); // Define o valor do plano a ser buscado
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

    // Método para buscar um plano de pagamento por descrição
    public ResultSet buscarPlanoPagamentoPorDescricao(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por descrição
            this.pstm = conexao.getConn().prepareStatement("SELECT * from PLANO WHERE CDESCRICAO = ? ORDER BY 1");
            pstm.setString(1, planoP.getcDescricao()); // Define a descrição do plano a ser buscado
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
