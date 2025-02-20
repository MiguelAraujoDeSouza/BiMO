package org.example.servletbimo.dao;

import org.example.servletbimo.models.Curso;

import java.sql.PreparedStatement; // Importa a classe para executar instruções SQL preparadas
import java.sql.ResultSet;
import java.sql.SQLException;// Importa a classe para tratar exceções relacionadas ao SQL


// Classe responsável pela manipulação de cursos
public class CursoDAO {
    private Conexao conexao = new Conexao(); // Instância da classe de conexão com o banco de dados
    private PreparedStatement pstm; // Objeto para executar comandos SQL preparados

    // Método para inserir um novo curso no banco de dados
    public boolean inserirCurso(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para inserção
            pstm = conexao.getConn().prepareStatement("INSERT INTO Curso(cdescricao, cnome, inumeroinscricao, fvalor, bstatus, cduracao,  idcategoriacurso, ccertificacao) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            // Define os valores dos parâmetros
            pstm.setString(1, curso.getcDescricao());
            pstm.setString(2, curso.getcNome());
            pstm.setInt(3, curso.getiNumeroInscricao());
            pstm.setDouble(4, curso.getfValor());
            pstm.setBoolean(5, curso.getbStatus());
            pstm.setString(6, curso.getcDuracao());
            pstm.setInt(7, curso.getIdCategoriaCurso());
            pstm.setString(8, curso.getcCertificacao());
            // Executa a inserção e verifica se houve sucesso
            return pstm.executeUpdate() > 0;
            // Retorna false se a inserção
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o status de um curso
    public int alterarStatusCurso(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização do status
            pstm = conexao.getConn().prepareStatement("UPDATE Curso SET bStatus = ? WHERE sID = ?");
            pstm.setBoolean(1, curso.getbStatus()); // Define o novo status
            pstm.setInt(2, curso.getsId()); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    public int alterarCertificacao(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização do status
            pstm = conexao.getConn().prepareStatement("UPDATE Curso SET CCERTIFICACAO = ? WHERE sID = ?");
            pstm.setString(1, curso.getcCertificacao()); // Define o novo status
            pstm.setInt(2, curso.getsId()); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o nome de um curso
    public int alterarNomeCurso(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do nome do curso
            pstm = conexao.getConn().prepareStatement("UPDATE Curso SET cNome_curso = ? WHERE sID = ?");
            pstm.setString(1, curso.getcNome()); // Define o novo nome
            pstm.setInt(2, curso.getsId()); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o valor de um curso
    public int alterarValorCurso(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do valor do curso
            pstm = conexao.getConn().prepareStatement("UPDATE Curso SET fValor = ? WHERE sID = ?");
            pstm.setDouble(1, curso.getfValor()); // Define o novo valor
            pstm.setInt(2, curso.getsId()); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a descrição de um curso
    public int alterarDescricaoCurso(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização da descrição do curso
            pstm = conexao.getConn().prepareStatement("UPDATE Curso SET cDescricao = ? WHERE sID = ?");
            pstm.setString(1, curso.getcDescricao()); // Define a nova descrição
            pstm.setInt(2, curso.getsId()); // Define o ID do curso a ser atualizado
            // Executa a atualização e verifica se houve sucesso
            return pstm.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para remover um curso pelo SID
    public int removerCurso(Curso curso) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para remoção
            pstm = conexao.getConn().prepareStatement("UPDATE CURSO SET bisinactive = 'TRUE' WHERE sId = ?");
            pstm.setInt(1, curso.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate();  // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }


    // Método para buscar um curso pelo ID
    public ResultSet buscarPorId(Curso curso) {
        conexao.conectar();
        try {
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CURSO WHERE sId = ? ORDER BY 1"); // Prepara a instrução SQL
            pstm.setInt(1, curso.getsId()); // Define o ID da categoria a ser buscada
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }

    // Método para buscar um curso pelo nome
    public ResultSet buscarPorNome(Curso curso) {
        conexao.conectar();
        try {
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CURSO WHERE CNOME = ? ORDER BY 1"); // Prepara a instrução SQL
            pstm.setString(1, curso.getcNome()); // Define o nome da categoria a ser buscada
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }

    public ResultSet buscarPorValor(Curso curso) {
        conexao.conectar();
        try {
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CURSO WHERE FVALOR = ? ORDER BY 1"); // Prepara a instrução SQL
            pstm.setDouble(1, curso.getfValor()); // Define o nome da categoria a ser buscada
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }

    // Método para buscar um curso pelo nome
    public ResultSet buscarPorCertificacao(Curso curso) {
        conexao.conectar();
        try {
            pstm = conexao.getConn().prepareStatement("SELECT * FROM CURSO WHERE CCERTIFICACAO = ? ORDER BY 1"); // Prepara a instrução SQL
            pstm.setString(1, curso.getcCertificacao()); // Define o nome da categoria a ser buscada
            return pstm.executeQuery(); // Executa a consulta e retorna o ResultSet
        } catch (SQLException sqle) { // Trata exceções SQL
            sqle.printStackTrace(); // Exibe a stack trace da exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar();
        }
        // Nota: A conexão não é fechada aqui, pois o ResultSet está sendo retornado.
    }

    public ResultSet buscarTodosCursos() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM CURSO ORDER BY 1");
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
