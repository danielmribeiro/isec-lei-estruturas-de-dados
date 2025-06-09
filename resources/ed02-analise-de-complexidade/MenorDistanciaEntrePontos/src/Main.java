import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //cria pontos
        List<Ponto> listaDePontos = Arrays.asList(
                new Ponto(1,2),
                new Ponto(3,6.5),
                new Ponto(10,9),
                new Ponto(12,12.5),
                new Ponto(15,14),
                new Ponto(20,16.5)
        );

        //resolve problema
        MenorDistanciaEntrePontos menorDistanciaEntrePontos = new MenorDistanciaEntrePontos(listaDePontos);
        System.out.println(menorDistanciaEntrePontos.resolveProblemaEmOrdemQuadratica());
    }
}
