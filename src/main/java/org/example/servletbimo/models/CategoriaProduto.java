package org.example.servletbimo.models;

public class CategoriaProduto {
    // Atributos da categoria de produto
    private int sId;
    private String cNome;            // Nome da categoria
    private boolean bis_inactive;     // Indica se a categoria está inativa
    private boolean bis_updated;       // Indica se a categoria foi atualizada
    private boolean btransaction_made; // Indica se uma transação foi realizada

    // Construtor para inicializar os atributos
    public CategoriaProduto(int sId, String cNome, boolean bis_inactive, boolean bis_updated, boolean btransaction_made) {
        this.sId = sId;
        this.cNome = cNome;
        this.bis_inactive = bis_inactive;
        this.bis_updated = bis_updated;
        this.btransaction_made = btransaction_made;
    }

    public CategoriaProduto(int sId) {
        this.sId = sId;
    }

    public CategoriaProduto(String cNome) {
        this.cNome = cNome;
    }

    public CategoriaProduto(int sId, String cNome) { // construtor para alteração
        this.sId = sId;
        this.cNome = cNome;
    }

    // Getter para o nome da categoria
    public int getsId(){
        return this.sId;
    }

    public String getcNome() {
        return cNome; // Retorna o nome da categoria
    }

    // Setter para o nome da categoria
    public void setcNome(String cNome) {
        this.cNome = cNome; // Atualiza o nome da categoria
    }

    // Getter para estado inativo
    public boolean isBis_inactive() {
        return bis_inactive; // Retorna estado inativo
    }

    // Setter para estado inativo
    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive; // Atualiza estado inativo
    }

    // Getter para estado atualizado
    public boolean isBis_updated() {
        return bis_updated; // Retorna estado atualizado
    }

    // Setter para estado atualizado
    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated; // Atualiza estado atualizado
    }

    // Getter para transação realizada
    public boolean isBtransaction_made() {
        return btransaction_made; // Retorna estado da transação
    }

    // Setter para transação realizada
    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made; // Atualiza estado da transação
    }

    // Sobrescrita do método toString para exibir informações da categoria
    @Override
    public String toString() {
        return "CategoriaProduto{" +
                "Nome='" + cNome + '\'' +
                ", Is_inactive=" + bis_inactive +
                ", Is_updated=" + bis_updated +
                ", Transaction_made=" + btransaction_made +
                '}';
    }
}
