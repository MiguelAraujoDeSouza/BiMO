package org.example.servletbimo.models; // Pacote que contém a classe de modelo

import java.util.Date; // Importa a classe Date para manipulação de datas

public class Usuario {
    // Atributos da classe, representando as propriedades do usuário
    private int sId;
    private String cCnpj; // CNPJ do usuário
    private Date dDataCriacao; // Data de criação do usuário
    private Date dDataNascimento; // Data de nascimento do usuário
    private String ctelefone; // Telefone do usuário
    private String cSobrenome; // Sobrenome do usuário
    private String cSenha; // Senha do usuário
    private String cCpf; // CPF do usuário
    private String cNome; // Nome do usuário
    private String cEmail; // E-mail do usuário

    public Usuario(int sId) {
        this.sId = sId;
    }

    public Usuario(String variavel, int tipoVariavel) {
        if (tipoVariavel == 1){ //1 é para nome
            this.cNome = variavel;
        } else if (tipoVariavel == 2) { //2 é para email
            this.cEmail = variavel;
        } else if (tipoVariavel == 3) { //3 é para cpf
            this.cCpf = variavel;
        } else if (tipoVariavel == 4) { //4 é para cnpj
            this.cCnpj = variavel;
        }
    }

    public int getsId() {
        return sId;
    }

    // Método para obter o CNPJ do usuário
    public String getcCnpj() {
        return cCnpj; // Retorna o CNPJ
    }

    // Método para definir o CNPJ do usuário
    public void setcCnpj(String cCnpj) {
        this.cCnpj = cCnpj; // Define o CNPJ
    }

    // Método para obter a data de criação do usuário
    public Date getdDataCriacao() {
        return dDataCriacao; // Retorna a data de criação
    }

    // Método para definir a data de criação do usuário
    public void setdDataCriacao(Date dDataCriacao) {
        this.dDataCriacao = dDataCriacao; // Define a data de criação
    }

    // Método para obter a data de nascimento do usuário
    public Date getdDataNascimento() {
        return dDataNascimento; // Retorna a data de nascimento
    }

    // Método para definir a data de nascimento do usuário
    public void setdDataNascimento(Date dDataNascimento) {
        this.dDataNascimento = dDataNascimento; // Define a data de nascimento
    }

    // Método para obter o telefone do usuário
    public String getCtelefone() {
        return ctelefone; // Retorna o telefone
    }

    // Método para definir o telefone do usuário
    public void setCtelefone(String ctelefone) {
        this.ctelefone = ctelefone; // Define o telefone
    }

    // Método para obter o sobrenome do usuário
    public String getcSobrenome() {
        return cSobrenome; // Retorna o sobrenome
    }

    // Método para definir o sobrenome do usuário
    public void setcSobrenome(String cSobrenome) {
        this.cSobrenome = cSobrenome; // Define o sobrenome
    }

    // Método para obter a senha do usuário
    public String getcSenha() {
        return cSenha; // Retorna a senha
    }

    // Método para definir a senha do usuário
    public void setcSenha(String cSenha) {
        this.cSenha = cSenha; // Define a senha
    }

    // Método para obter o CPF do usuário
    public String getcCpf() {
        return cCpf; // Retorna o CPF
    }

    // Método para definir o CPF do usuário
    public void setcCpf(String cCpf) {
        this.cCpf = cCpf; // Define o CPF
    }

    // Método para obter o nome do usuário
    public String getcNome() {
        return cNome; // Retorna o nome
    }

    // Método para definir o nome do usuário
    public void setcNome(String cNome) {
        this.cNome = cNome; // Define o nome
    }

    // Método para obter o e-mail do usuário
    public String getcEmail() {
        return cEmail; // Retorna o e-mail
    }

    // Método para definir o e-mail do usuário
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail; // Define o e-mail
    }

    // Sobrescrita do método toString para fornecer uma representação legível do objeto
    @Override
    public String toString() {
        return "Usuario{" +
                "cCnpj='" + this.cCnpj + '\'' + // Representa o CNPJ
                ", dDataCriacao=" + this.dDataCriacao + // Representa a data de criação
                ", dDataNascimento=" + this.dDataNascimento + // Representa a data de nascimento
                ", ctelefone='" + this.ctelefone + '\'' + // Representa o telefone
                ", cSobrenome='" + this.cSobrenome + '\'' + // Representa o sobrenome
                ", cSenha='" + this.cSenha + '\'' + // Representa a senha
                ", cCpf='" + this.cCpf + '\'' + // Representa o CPF
                ", cNome='" + this.cNome + '\'' + // Representa o nome
                ", cEmail='" + this.cEmail + '\'' + // Representa o e-mail
                '}'; // Finaliza a representação da string
    }
}
