package Exercicios;

public class No2 <T extends Comparable<? super T>> {
    private T valor;
    private No esquerdo;
    private No direito;
    private int pl, pr; // Profundidade da sub-Ã¡rvore esquerda e da sub-Ã¡rvore direita

    public No2() { 
        this.pl = 0;
        this.pr = 0;
    }    
    
    public No2(T valor) {
        this.valor = valor;
        this.pl = 0;
        this.pr = 0;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public int getPl() {
        return pl;
    }

    public void setPl(int pl) {
        this.pl = pl;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }
    
    public int getProfundidade(){
        return (pl > pr) ? pl + 1 : pr + 1; // A profundidade do nÃ³ Ã© a da maior das sub-Ã¡rvores + 1
    }
    
    // MÃ©todo que indica se o nÃ³ estÃ¡ balanceado (diferenÃ§a de profundifades das sub-Ã¡rvores <= 1)
    public boolean balanceada(){
        return Math.abs(pl - pr) <= 1;
    }
       
    
    
} 
