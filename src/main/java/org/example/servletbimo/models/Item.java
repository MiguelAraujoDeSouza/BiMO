package org.example.servletbimo.models;

public class Item {
    private int iQuantidade;
    private double fValor;

    public int getiQuantidade() {
        return iQuantidade;
    }

    public void setiQuantidade(int iQuantidade) {
        this.iQuantidade = iQuantidade;
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iQuantidade=" + this.iQuantidade +
                ", fValor=" + this.fValor +
                '}';
    }
}
