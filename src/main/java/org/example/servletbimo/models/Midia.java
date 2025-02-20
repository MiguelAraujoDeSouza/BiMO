package org.example.servletbimo.models; // Pacote que contém a classe de modelo

public class Midia {
    // Atributos da classe
    private int sId;
    private String cURLVideo; // URL do vídeo
    private String cURLFoto; // URL da foto

    public Midia(int sId) {
        this.sId = sId;
    }

    public Midia(String cURLFoto) {
        this.cURLFoto = cURLFoto;
    }

    public int getsId() { return this.sId; }

    // Método para obter a URL do vídeo
    public String getcURLVideo() {
        return cURLVideo; // Retorna a URL do vídeo
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

    // Construtor da classe
    public Midia(String cURLVideo, String cURLFoto) {
        this.cURLVideo = cURLVideo; // Inicializa a URL do vídeo
        this.cURLFoto = cURLFoto; // Inicializa a URL da foto
    }
}
