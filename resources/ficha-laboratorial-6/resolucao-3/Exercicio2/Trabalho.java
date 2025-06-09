package Exercicio2;

public class Trabalho {
    private String nomeFicheiro;
    private int pagInicial;
    private int pagFinal;

    public Trabalho(String nomeFicheiro, int pagInicial, int pagFinal) {
        this.nomeFicheiro = nomeFicheiro;
        this.pagInicial = pagInicial;
        this.pagFinal = pagFinal;
    }

    public String getNomeFicheiro() {
        return nomeFicheiro;
    }

    public int getPagInicial() {
        return pagInicial;
    }

    public int getPagFinal() {
        return pagFinal;
    }
    
    public int getPaginas() {
        return pagFinal - pagInicial;
    }
}
