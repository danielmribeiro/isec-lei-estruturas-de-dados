package exercicio1;

public class Trabalho {
    private String nomeFicheiro;
    private int paginaInicial;
    private int paginaFinal;

    public Trabalho(String nomeFicheiro, int paginaInicial, int paginaFinal) {
        this.nomeFicheiro = nomeFicheiro;
        this.paginaInicial = paginaInicial;
        this.paginaFinal = paginaFinal;
    }

    public String getNomeFicheiro() {
        return nomeFicheiro;
    }

    public int getPaginaInicial() {
        return paginaInicial;
    }

    public int getPaginaFinal() {
        return paginaFinal;
    }

    public int getPaginas(){
        return paginaFinal - paginaInicial;
    }

    @Override
    public String toString() {
        return "Trabalho{" +
                "nomeFicheiro='" + getNomeFicheiro() + '\'' +
                ", paginaInicial=" + getPaginaInicial() +
                ", paginaFinal=" + getPaginaFinal() +
                ", paginas=" + getPaginas() +
                '}';
    }
}
