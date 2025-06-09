/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6;

/**
 *
 * @author nelio
 */
public class Trabalho {
    String nomeFichairo;
    int pInicial, pFinal;
    
    public Trabalho(String nome, int in, int fin){
        this.nomeFichairo = nome;
        this.pInicial = in;
        this.pFinal = fin;
}
    
    public String getNomeFicheiro(){
        return nomeFichairo;
    }
    
    public int getNumPaginas(){
        return pFinal - pInicial;
    }
    
    public int getPaginaInicial(){
        return pInicial;
    }
    
    public int getPaginaFinal(){
        return pFinal;
    }
    
    public String getInfo(){
        return "Trabalho \"" + nomeFichairo + "\" | numPaginas: " + getNumPaginas();
    }
}
