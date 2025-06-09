package ficha6;

public class Trabalho {
    public String nomeFicheiro;
    public int paginaInicial;
    public int paginaFinal;

    public Trabalho(String nomeFicheiro, int paginaInicial, int paginaFinal) {
        this.nomeFicheiro = nomeFicheiro;
        this.paginaInicial = paginaInicial;
        this.paginaFinal = paginaFinal;
    }

    public int getPaginas() {
        return paginaFinal-paginaInicial;
    }
}
