package org.example.servletbimo.models; // Pacote que contém a classe de modelo

public class CategoriaCurso {
    // Atributos da classe
    private int sId;
    private boolean bis_updated; // Indica se a categoria foi atualizada
    private boolean btransaction_made; // Indica se uma transação foi realizada
    private boolean bis_inactive; // Indica se a categoria está inativa
    private String cNome; // Nome da categoria

    public CategoriaCurso(int sId) {
        this.sId = sId;
    }

    public CategoriaCurso(String cNome) {
        this.cNome = cNome;
    }

    public CategoriaCurso(int sId, String cNome) {
        this.sId = sId;
        this.cNome = cNome;
    }

    // Método para verificar se a categoria foi atualizada
    public boolean isBis_updated() {
        return bis_updated; // Retorna o estado de atualização
    }

    public int getsId(){
        return this.sId;
    }

    // Método para definir o estado de atualização
    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated; // Define o estado de atualização
    }

    // Método para verificar se uma transação foi realizada
    public boolean isBtransaction_made() {
        return btransaction_made; // Retorna o estado da transação
    }

    // Método para definir o estado da transação
    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made; // Define o estado da transação
    }

    // Método para verificar se a categoria está inativa
    public boolean isBis_inactive() {
        return bis_inactive; // Retorna o estado de inatividade
    }

    // Método para definir o estado de inatividade
    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive; // Define o estado de inatividade
    }

    // Método para obter o nome da categoria
    public String getcNome() {
        return cNome; // Retorna o nome da categoria
    }

    // Método para definir o nome da categoria
    public void setcNome(String cNome) {
        this.cNome = cNome; // Define o nome da categoria
    }

    // Método para representar a classe como uma string
    @Override
    public String toString() {
        return "CategoriaCurso{" +
                "bis_updated=" + this.bis_updated + // Representa o estado de atualização
                ", btransaction_made=" + this.btransaction_made + // Representa o estado da transação
                ", bis_inactive=" + this.bis_inactive + // Representa o estado de inatividade
                ", cNome='" + this.cNome + '\'' + // Representa o nome da categoria
                '}'; // Finaliza a representação da string
    }
}
