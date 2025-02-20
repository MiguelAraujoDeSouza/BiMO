package org.example.servletbimo.dao;

import org.example.servletbimo.models.Administrador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// Classe responsável pela manipulação de administradores
public class AdministradorDAO {
    private PreparedStatement pstm; // Objeto para executar comandos SQL
    private ResultSet rs;
    private Conexao conexao = new Conexao(); // Instância da classe de conexão ao banco de dados

    // Construtor da classe
    public AdministradorDAO() {}

    //Metodo para o logar adm
    public boolean BuscarAdministrador(String email, String senha) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            pstm = this.conexao.getConn().prepareStatement("SELECT CEMAIL, CSENHA FROM ADMINISTRADOR WHERE CEMAIL = ? AND CSENHA = ? ORDER BY 1");
            // Define os parâmetros na consulta SQL
            pstm.setString(1, email);
            pstm.setString(2, senha);
            // Executa a busca e obtém o ResultSet
            this.rs = pstm.executeQuery();
            // Verifica se o ResultSet contém pelo menos um resultado
            if (rs != null && rs.next()) {
                return true; // Encontrou um administrador
            } else {
                return false; // Não encontrou nenhum administrador
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Exibe o erro caso ocorra uma exceção SQL
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão no bloco "finally" para garantir que sempre será executado
        }
    }

    // Método para inserir um novo administrador
    public boolean inserirAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {

            // Prepara a instrução SQL para inserção
            pstm = this.conexao.getConn().prepareStatement("INSERT INTO ADMINISTRADOR (CNOME, CEMAIL, CSENHA) VALUES(?,?,?)");
            pstm.setString(1, adm.getcNome()); // Define o valor do parâmetro CNOME
            pstm.setString(2, adm.getcEmail()); // Define o valor do parâmetro CEMAIL
            pstm.setString(3, adm.getcSenha()); // Define o valor do parâmetro CSENHA
            return pstm.executeUpdate() > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return false; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para remover um administrador pelo SID
    public int removerAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {

            // Prepara a instrução SQL para remoção
            this.pstm = conexao.getConn().prepareStatement("DELETE FROM ADMINISTRADOR WHERE SID = ?");
            pstm.setInt(1, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o nome de um administrador
    public int alterarNomeAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CNOME = ? WHERE SID = ?");
            pstm.setString(1, adm.getcNome()); // Define o novo nome
            pstm.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o email de um administrador
    public int alterarEmailAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CEMAIL = ? WHERE SID = ?");
            pstm.setString(1, adm.getcEmail()); // Define o novo email
            pstm.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar a senha de um administrador
    public int alterarSenhaAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstm = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CSENHA = ? WHERE SID = ?");
            pstm.setString(1, adm.getcSenha()); // Define a nova senha
            pstm.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar todos os administradores
    public ResultSet buscarTodosAdministradores() {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca
            this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR ORDER BY 1");
            // Executa a busca e retorna o ResultSet com os resultados
            return pstm.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo SID
    public ResultSet buscarAdministradorPorId(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            this.pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE SID = ? ORDER BY 1");
            pstm.setInt(1, adm.getsId()); // Define o valor do parâmetro SID
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    public boolean verificarAdministrador(String cEmail){
        conexao.conectar();
        try{
            pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CEMAIL = ? ORDER BY 1");
            pstm.setString(1, cEmail);
            if (pstm.executeQuery().next()) {
                return false;
            } else {
                return true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

    // Método para buscar um administrador pelo nome
    public ResultSet buscarAdministradorPorNome(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por nome
            this.pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CNOME = ? ORDER BY 1");
            pstm.setString(1, adm.getcNome()); // Define o valor do parâmetro CNOME
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo email
    public ResultSet buscarAdministradorPorEmail(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por email
            this.pstm = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CEMAIL = ? ORDER BY 1");
            pstm.setString(1, adm.getcEmail()); // Define o valor do parâmetro CEMAIL
            return pstm.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para criptografar a senha
    public String criptografarSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder(); // StringBuilder para construir a senha criptografada
        String alfabetoMinusculo = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto minúsculo
        String alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alfabeto maiúsculo
        int chaveSt = Integer.parseInt(System.getenv("CHAVE_CRIPTOGRAFIA")); // Obtém a chave de criptografia do ambiente

        // Itera sobre cada caractere da senha
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            // Verifica se o caractere é uma letra minúscula
            if (Character.isLowerCase(caractere)) {
                // Calcula a nova posição do caractere e adiciona ao resultado
                int novaPosicao = (alfabetoMinusculo.indexOf(caractere) + chaveSt) % alfabetoMinusculo.length();
                char novaLetra = alfabetoMinusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra); // Adiciona a nova letra à senha criptografada
            }
            // Verifica se o caractere é uma letra maiúscula
            else if (Character.isUpperCase(caractere)) {
                // Calcula a nova posição do caractere e adiciona ao resultado
                int novaPosicao = (alfabetoMaiusculo.indexOf(caractere) + chaveSt) % alfabetoMaiusculo.length();
                char novaLetra = alfabetoMaiusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra); // Adiciona a nova letra à senha criptografada
            }
            // Verifica se o caractere é um dígito
            else if (Character.isDigit(caractere)) {
                // Calcula o novo dígito e adiciona ao resultado (limita entre 0-9)
                int novoDigito = (Character.getNumericValue(caractere) + chaveSt) % 10;
                senhaCriptografada.append(novoDigito); // Adiciona o novo dígito à senha criptografada
            } else {
                // Mantém caracteres que não são letras nem dígitos inalterados
                senhaCriptografada.append(caractere);
            }
        }

        // Retorna a senha criptografada como uma string
        return senhaCriptografada.toString();
    }
}
