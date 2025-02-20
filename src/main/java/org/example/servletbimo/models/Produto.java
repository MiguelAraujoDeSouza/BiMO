package org.example.servletbimo.models; // Pacote que contém a classe de modelo

import java.util.Date; // Importa a classe Date para representar datas

public class Produto {
    // Atributos da classe, representando as propriedades do produto
    private int sId;
    private double fValor; // Valor do produto
    private String cDescricao; // Descrição do produto
    private Date dDataCriacao; // Data de criação do produto
    private String cNome; // Nome do produto
    private String cCategoria; // Categoria do produto
    private String cEstado; // Estado do produto (ex: disponível, esgotado)

    public Produto(int sId) {
        this.sId = sId;
    }

    public Produto(String variavel, int tipoVariavel) {
        if (tipoVariavel == 1){ //1 é para nome
            this.cNome = variavel;
        } else if (tipoVariavel == 2) { //2 é para estado
            this.cEstado = variavel;
        }
    }

    public int getsId() {
        return sId;
    }

    // Método para obter o valor do produto
    public double getfValor() {
        return fValor; // Retorna o valor
    }

    // Método para definir o valor do produto
    public void setfValor(double fValor) {
        this.fValor = fValor; // Define o valor
    }

    // Método para obter a descrição do produto
    public String getcDescricao() {
        return cDescricao; // Retorna a descrição
    }

    // Método para definir a descrição do produto
    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao; // Define a descrição
    }

    // Método para obter a data de criação do produto
    public Date getdDataCriacao() {
        return dDataCriacao; // Retorna a data de criação
    }

    // Método para definir a data de criação do produto
    public void setdDataCriacao(Date dDataCriacao) {
        this.dDataCriacao = dDataCriacao; // Define a data de criação
    }

    // Método para obter o nome do produto
    public String getcNome() {
        return cNome; // Retorna o nome
    }

    // Método para definir o nome do produto
    public void setcNome(String cNome) {
        this.cNome = cNome; // Define o nome
    }

    // Método para obter a categoria do produto
    public String getcCategoria() {
        return cCategoria; // Retorna a categoria
    }

    // Método para definir a categoria do produto
    public void setcCategoria(String cCategoria) {
        this.cCategoria = cCategoria; // Define a categoria
    }

    // Método para obter o estado do produto
    public String getcEstado() {
        return cEstado; // Retorna o estado
    }

    // Método para definir o estado do produto
    public void setcEstado(String cEstado) {
        this.cEstado = cEstado; // Define o estado
    }

    // Sobrescrita do método toString para fornecer uma representação legível do objeto

    @Override
    public String toString() {
        return "Produto{" +
                "sId=" + sId +
                ", fValor=" + fValor +
                ", cDescricao='" + cDescricao + '\'' +
                ", dDataCriacao=" + dDataCriacao +
                ", cNome='" + cNome + '\'' +
                ", cCategoria='" + cCategoria + '\'' +
                ", cEstado='" + cEstado + '\'' +
                '}';
    }
}
