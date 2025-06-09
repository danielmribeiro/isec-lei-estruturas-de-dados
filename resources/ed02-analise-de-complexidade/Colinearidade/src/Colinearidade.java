import java.util.List;

public class Colinearidade {
    private List<Ponto> listaDePontos;
    Ponto pontoA;
    Ponto pontoB;
    Ponto pontoC;
    boolean temColinearidade = false;

    public Colinearidade(List<Ponto> listaDePontos) {
        this.listaDePontos = listaDePontos;
    }

    public String resolveProblemaEmOrdemCubica() {
        for (int i = 0; i < listaDePontos.size(); i++) {
            for (int j = i+1; j < listaDePontos.size(); j++) {
                for (int k = j+1; k < listaDePontos.size(); k++) {
                    if(colinearidadeEntrePontos(listaDePontos.get(i),listaDePontos.get(j),listaDePontos.get(k))==true){
                        temColinearidade=true;
                        pontoA= listaDePontos.get(i);
                        pontoB= listaDePontos.get(j);
                        pontoC= listaDePontos.get(k);
                    }
                }
            }
        }
        return toString();
    }

    private boolean colinearidadeEntrePontos(Ponto ponto1, Ponto ponto2, Ponto ponto3) {
        if(ponto1.getX()==ponto2.getX()&&ponto1.getX()==ponto3.getX()){
            return true;
        }else if(ponto1.getY()==ponto2.getY()&&ponto1.getY()==ponto3.getY()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(temColinearidade){
            return "os pontos " + pontoA + ", " + pontoB + " e "+ pontoC + " são colineares";
        }else{
            return "não existe colinearidade";
        }
    }
}
