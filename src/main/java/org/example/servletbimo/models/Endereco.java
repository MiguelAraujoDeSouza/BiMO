package org.example.servletbimo.models; // Pacote que contém a classe de modelo

public class Endereco {
    // Atributos da classe
    private String cRua; // Nome da rua
    private String cCep; // Código de Endereçamento Postal (CEP)
    private String cEstado; // Estado do endereço
    private int iNumero; // Número da residência
    private String cBairro; // Nome do bairro

    // Método para obter o nome da rua
    public String getcRua() {
        return cRua; // Retorna o nome da rua
    }

    // Método para definir o nome da rua
    public void setcRua(String cRua) {
        this.cRua = cRua; // Define o nome da rua
    }

    // Método para obter o CEP
    public String getcCep() {
        return cCep; // Retorna o CEP
    }

    // Método para definir o CEP
    public void setcCep(String cCep) {
        this.cCep = cCep; // Define o CEP
    }

    // Método para obter o estado
    public String getcEstado() {
        return cEstado; // Retorna o estado
    }

    // Método para definir o estado
    public void setcEstado(String cEstado) {
        this.cEstado = cEstado; // Define o estado
    }

    // Método para obter o número da residência
    public int getiNumero() {
        return iNumero; // Retorna o número da residência
    }

    // Método para definir o número da residência
    public void setiNumero(int iNumero) {
        this.iNumero = iNumero; // Define o número da residência
    }

    // Método para obter o nome do bairro
    public String getcBairro() {
        return cBairro; // Retorna o nome do bairro
    }

    // Método para definir o nome do bairro
    public void setcBairro(String cBairro) {
        this.cBairro = cBairro; // Define o nome do bairro
    }

    // Construtor da classe
    public Endereco(String cRua, String cCep, String cEstado, int iNumero, String cBairro) {
        this.cRua = cRua; // Inicializa o nome da rua
        this.cCep = cCep; // Inicializa o CEP
        this.cEstado = cEstado; // Inicializa o estado
        this.iNumero = iNumero; // Inicializa o número da residência
        this.cBairro = cBairro; // Inicializa o nome do bairro
    }
}
