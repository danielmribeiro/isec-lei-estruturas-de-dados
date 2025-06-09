import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Cria pontos
        List<Ponto> listaDePontos = Arrays.asList(
                new Ponto(1,1),
                new Ponto(1,2),
                new Ponto(5,5),
                new Ponto(2,1),
                new Ponto(2,2),
                new Ponto(3,5),
                new Ponto(3,7),
                new Ponto(4,8),
                new Ponto(1,3)
        );

        //Resolve o problema
        Colinearidade colinearidade = new Colinearidade(listaDePontos);
        System.out.println(colinearidade.resolveProblemaEmOrdemCubica());
    }

    //Um ponto é colinear quando se encontra na mesma linha que outro ponto.
    //Ou seja, existindo o Ponto1 com coordenadas(x1,y1) e o Ponto2 com coordenadas(x2,y2), são colineares quando x1=x2 ou y1=y2.

}
