package org.example.servletbimo.models; // Pacote que contém a classe de modelo

public class MidiaCurso {
    // Construtor da classe
    // Atributos da classe

    private int sId; // ID da mídia do curso
    private int idCurso;
    private String cURLVideo; // URL do vídeo da mídia
    private String cURLFoto; // URL da foto da mídia
    private boolean btransaction_made; // Indica se uma transação foi realizada
    private boolean bisInactive; // Indica se a mídia está inativa
    private boolean bisUpdates; // Indica se a mídia foi atualizada
    public MidiaCurso(int sId, int idCurso, String cURLVideo, String cURLFoto, boolean btransaction_made, boolean bisInactive, boolean bisUpdates) {
        this.sId = sId;
        this.idCurso = idCurso;
        this.cURLVideo = cURLVideo; // Inicializa a URL do vídeo
        this.cURLFoto = cURLFoto; // Inicializa a URL da foto
        this.btransaction_made = btransaction_made; // Inicializa o estado da transação
        this.bisInactive = bisInactive; // Inicializa o estado de inatividade
        this.bisUpdates = bisUpdates; // Inicializa o estado de atualização
    }
    public MidiaCurso( int idCurso, String cURLVideo, String cURLFoto, boolean btransaction_made, boolean bisInactive, boolean bisUpdates) {
        this.idCurso = idCurso;
        this.cURLVideo = cURLVideo; // Inicializa a URL do vídeo
        this.cURLFoto = cURLFoto; // Inicializa a URL da foto
        this.btransaction_made = btransaction_made; // Inicializa o estado da transação
        this.bisInactive = bisInactive; // Inicializa o estado de inatividade
        this.bisUpdates = bisUpdates; // Inicializa o estado de atualização
    }

    public MidiaCurso(int id, int tipoId, String cUrlFoto) { // construtor para cadastro e alteração de url
        if (tipoId == 1){ // 1 é para sId
            this.sId = id;
        } else if (tipoId == 2) { // 2 é para idCurso
            this.idCurso = id;
        }
        this.cURLFoto = cUrlFoto;
    }

    public MidiaCurso(int sId) {
        this.sId = sId;
    }

    public MidiaCurso(int sId, int idCurso) {
        this.sId = sId;
        this.idCurso = idCurso;
    }

    public MidiaCurso(String cURLFoto) {
        this.cURLFoto = cURLFoto;
    }

    // Método para obter o ID da mídia
    public int getsId() {
        return this.sId; // Retorna o ID da mídia
    }

    public int getIdCurso() {
        return idCurso;
    }

    // Método para obter a URL do vídeo
    public String getcURLVideo() {
        return this.cURLVideo; // Retorna a URL do vídeo
    }

    // Método para definir a URL do vídeo
    public void setcURLVideo(String cURLVideo) {
        this.cURLVideo = cURLVideo; // Define a URL do vídeo
    }

    // Método para obter a URL da foto
    public String getcURLFoto() {
        return cURLFoto; // Retorna a URL da foto
    }

    // Método para definir a URL da foto
    public void setcURLFoto(String cURLFoto) {
        this.cURLFoto = cURLFoto; // Define a URL da foto
    }

    // Método para verificar se uma transação foi realizada
    public boolean isBtransaction_made() {
        return this.btransaction_made; // Retorna o estado da transação
    }

    // Método para definir o estado da transação
    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made; // Define o estado da transação
    }

    // Método para verificar se a mídia está inativa
    public boolean isBisInactive() {
        return this.bisInactive; // Retorna o estado de inatividade
    }

    // Método para definir o estado de inatividade
    public void setBisInactive(boolean bisInactive) {
        this.bisInactive = bisInactive; // Define o estado de inatividade
    }

    // Método para verificar se a mídia foi atualizada
    public boolean isBisUpdates() {
        return bisUpdates; // Retorna o estado de atualização
    }

    // Método para definir o estado de atualização

    public void setBisUpdates(boolean bisUpdates) {
        this.bisUpdates = bisUpdates; // Define o estado de atualização
    }
    // Método para representar a classe como uma string

    @Override
    public String toString() {
        return "MidiaCurso{" +
                "sId=" + sId +
                ", idCurso=" + idCurso +
                ", cURLVideo='" + cURLVideo + '\'' +
                ", cURLFoto='" + cURLFoto + '\'' +
                ", btransaction_made=" + btransaction_made +
                ", bisInactive=" + bisInactive +
                ", bisUpdates=" + bisUpdates +
                '}';
    }
}
