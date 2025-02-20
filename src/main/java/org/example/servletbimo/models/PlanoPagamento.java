package org.example.servletbimo.models; // Pacote que contém a classe de modelo

public class PlanoPagamento {
    // Atributos da classe, representando as propriedades do plano de pagamento
    private int sId;
    private String cDescricao; // Descrição do plano
    private String cNome;      // Nome do plano
    private double fValor;     // Valor do plano
    private boolean bis_inactive; // Indica se o plano está inativo
    private boolean bis_updated;   // Indica se o plano foi atualizado
    private boolean btransaction_made; // Indica se uma transação foi realizada

    // Construtor padrão da classe
    public PlanoPagamento() {}

    // Construtor da classe que inicializa todos os atributos
    public PlanoPagamento(String cDescricao, String cNome, double fValor) {
        this.cDescricao = cDescricao; // Inicializa a descrição do plano
        this.cNome = cNome;           // Inicializa o nome do plano
        this.fValor = fValor;
    }

    public PlanoPagamento(int sId) {
        this.sId = sId;
    }

    public PlanoPagamento(int sId, String variavel, int tipoVariavel) { // construtor para alteração de nome e descrição
        this.sId = sId;
        if (tipoVariavel == 1) { // 1 é para nome
            this.cNome = variavel;
        } else if (tipoVariavel == 2) { // 2 é para descrição
            this.cDescricao = variavel;
        }
    }

    public PlanoPagamento(int sId, double fValor) { // construtor para alteração de valor
        this.sId = sId;
        this.fValor = fValor;
    }

    public PlanoPagamento(String variavel, int tipoVariavel) {
        if (tipoVariavel == 1) { //1 é para nome
            this.cNome = variavel;
        } else if (tipoVariavel == 2) { //2 é para descrição
            this.cDescricao = variavel;
        }
    }

    // Getters e Setters para acessar e modificar os atributos

    public int getsId(){
        return this.sId;
    }

    public String getcDescricao() {
        return cDescricao; // Retorna a descrição do plano
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao; // Define a descrição do plano
        // Considerar validação de entrada aqui, se necessário
    }

    public String getcNome() {
        return cNome; // Retorna o nome do plano
    }

    public void setcNome(String cNome) {
        this.cNome = cNome; // Define o nome do plano
        // Considerar validação de entrada aqui, se necessário
    }

    public double getfValor() {
        return fValor; // Retorna o valor do plano
    }

    public void setfValor(double fValor) {
        this.fValor = fValor; // Define o valor do plano
        // Considerar evitar valores negativos, se necessário
    }

    public boolean isBis_inactive() {
        return bis_inactive; // Retorna o estado inativo
    }

    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive; // Define o estado inativo
    }

    public boolean isBis_updated() {
        return bis_updated; // Retorna o estado de atualização
    }

    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated; // Define o estado de atualização
    }

    public boolean isBtransaction_made() {
        return btransaction_made; // Retorna o estado da transação
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made; // Define o estado da transação
    }

    // Sobrescrita do método toString para fornecer uma representação legível do objeto
    @Override
    public String toString() {
        return "PlanoPagamento{" +
                "Descricao='" + cDescricao + '\'' + // Representa a descrição do plano
                ", Nome='" + cNome + '\'' + // Representa o nome do plano
                ", Valor=" + fValor + // Representa o valor do plano
                ", Is_inactive=" + bis_inactive + // Representa o estado inativo
                ", Is_updated=" + bis_updated + // Representa o estado de atualização
                ", Transaction_made=" + btransaction_made + // Representa o estado da transação
                '}'; // Finaliza a representação da string
    }
}
