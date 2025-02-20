package org.example.servletbimo.models; // Pacote que contém a classe de modelo

import java.util.Date; // Importa a classe Date para representar datas

public class Pedido {
    // Atributos da classe
    private double fValorTotal; // Valor total do pedido
    private String cTipoPagamento; // Tipo de pagamento utilizado
    private int iQuantidade; // Quantidade de itens no pedido
    private String cStatus; // Status do pedido (ex: pendente, completo)
    private Date dDataPedido; // Data em que o pedido foi realizado

    // Método para obter o valor total do pedido
    public double getfValorTotal() {
        return fValorTotal; // Retorna o valor total
    }

    // Método para definir o valor total do pedido
    public void setfValorTotal(double fValorTotal) {
        this.fValorTotal = fValorTotal; // Define o valor total
    }

    // Método para obter o tipo de pagamento
    public String getcTipoPagamento() {
        return cTipoPagamento; // Retorna o tipo de pagamento
    }

    // Método para definir o tipo de pagamento
    public void setcTipoPagamento(String cTipoPagamento) {
        this.cTipoPagamento = cTipoPagamento; // Define o tipo de pagamento
    }

    // Método para obter a quantidade de itens no pedido
    public int getiQuantidade() {
        return iQuantidade; // Retorna a quantidade de itens
    }

    // Método para definir a quantidade de itens no pedido
    public void setiQuantidade(int iQuantidade) {
        this.iQuantidade = iQuantidade; // Define a quantidade de itens
    }

    // Método para obter o status do pedido
    public String getcStatus() {
        return cStatus; // Retorna o status do pedido
    }

    // Método para definir o status do pedido
    public void setcStatus(String cStatus) {
        this.cStatus = cStatus; // Define o status do pedido
    }

    // Método para obter a data do pedido
    public Date getdDataPedido() {
        return dDataPedido; // Retorna a data do pedido
    }

    // Método para definir a data do pedido
    public void setdDataPedido(Date dDataPedido) {
        this.dDataPedido = dDataPedido; // Define a data do pedido
    }

    // Método para representar a classe como uma string
    @Override
    public String toString() {
        return "Pedido{" +
                "fValorTotal=" + this.fValorTotal + // Representa o valor total
                ", cTipoPagamento='" + this.cTipoPagamento + '\'' + // Representa o tipo de pagamento
                ", iQuantidade=" + this.iQuantidade + // Representa a quantidade de itens
                ", cStatus='" + this.cStatus + '\'' + // Representa o status do pedido
                ", dDataPedido=" + this.dDataPedido + // Representa a data do pedido
                '}'; // Finaliza a representação da string
    }
}
