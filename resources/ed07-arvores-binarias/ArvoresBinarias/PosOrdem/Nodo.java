package PosOrdem;
// cálculo de valor (pós-ordem)
class Nodo {
    String valor;
    Nodo esquerda, direita;
    Integer CalculaValor(){
        if((esquerda==null)&&(direita==null)){
            return Integer.valueOf(valor);
        }
        int valEsq=esquerda.CalculaValor().intValue();
        int valDir=0;
        if(direita!=null){
            direita=direita.CalculaValor().intValue();
        }
        if(valor.equals("+")){
            return valDir+valEsq;
        }
        if(valor.equals("*")){
            return valDir*valEsq;
        }
        if(valor.equals("-")){
            return valDir-valEsq;
        }
    }
}
