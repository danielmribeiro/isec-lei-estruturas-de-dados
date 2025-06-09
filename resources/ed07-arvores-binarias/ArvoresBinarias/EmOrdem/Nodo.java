package EmOrdem;
//impressão (em-ordem)
class Nodo {
    String valor;
    Nodo esquerda, direita;
    void expressao(){
        if(esquerda!=null){
            esquerda.expressao();
            System.out.println(valor);
            if(direita!=null){
                direita.expressao();
            }
        }
    }
}
