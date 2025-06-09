import java.util.Arrays;
import java.util.List;

public class MenorDistanciaEntrePontos {
    private List<Ponto> listaDePontos;
    double menorDistancia = Double.MAX_VALUE;
    Ponto pontoA;
    Ponto pontoB;
    private static long stopTime;
    private static long startTime;
    private int nIteracoes;

    public MenorDistanciaEntrePontos(List<Ponto> listaDePontos) {
        this.listaDePontos = listaDePontos;
    }

    public String resolveProblemaEmOrdemQuadratica() {
        startTimer();
        for (int i = 0; i < listaDePontos.size(); i++) {
            for (int j = i+1; j < listaDePontos.size(); j++) {
                nIteracoes++;
                if(distanciaEntreDoisPontos(listaDePontos.get(i),listaDePontos.get(j))<menorDistancia){
                    menorDistancia=distanciaEntreDoisPontos(listaDePontos.get(i),listaDePontos.get(j));
                    pontoA=listaDePontos.get(i);
                    pontoB= listaDePontos.get(j);
                }
            }
        }
        stopTimer();
        showTime();
        return toString();
    }

    private double distanciaEntreDoisPontos(Ponto ponto1, Ponto ponto2) {
        double DistanciaEmX = Math.abs(ponto1.getX()-ponto2.getX());
        double DistanciaEmY = Math.abs(ponto1.getY()-ponto2.getY());
        return Math.sqrt((DistanciaEmX*DistanciaEmX) + (DistanciaEmY*DistanciaEmY)); //retorna a hipotenusa
    }

    @Override
    public String toString() {
        return "A menor distancia ocorre entre o ponto " + pontoA + " e o ponto " + pontoB + " e possui o valor de "+ menorDistancia + ".\nO algoritmo demorou "+showTime()+" segundos e teve "+nIteracoes+" iteracoes.";
    }

    private static String showTime() {
        long interval=stopTime-startTime;
        long secs=interval/1000000000L;
        long decs=interval-secs*1000000000L;
        decs/=100000000L;
        return secs+"."+decs ;
    }
    private static void stopTimer() {
        stopTime=System.nanoTime();
    }
    private static void startTimer() {
        startTime=System.nanoTime();
    }
}
