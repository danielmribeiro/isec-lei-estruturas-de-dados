package exercicio1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static int[] criaArrayCom(int valor, int dimensao, boolean diferentes){
        int m[]= new int[dimensao];
        if(diferentes){
            for(int i=0;i<dimensao;i++)
                m[i]=i*10;
            if((valor%10!=0)||(0>valor)||(valor>(dimensao-1)*10))
                m[0]=valor;
        }else{
            Random r = new Random();
            int gama=(Math.abs(valor)<10)?10:Math.abs(valor);
            for(int i=0;i<dimensao;i++)
                m[i]=r.nextInt(gama*4)-gama*2;
            m[0]=valor;
        }
        Arrays.sort(m);
        return m;
    }

    public static void main(String[] args) {
        int chave=30;
        int[] array=criaArrayCom(chave,12,true);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
        boolean resultado = pesquisaBinariaRecursiva(chave,array);
        System.out.println(resultado);
    }

    public static boolean pesquisaBinariaRecursiva(int chave, int[] tabela){
        int start = 0;
        int end = tabela.length;
        int meio = (start+end)/2;

        if(end==0){
            return false;
        }
        if(tabela[meio]==chave){
            return true;
        }else if(tabela[meio]>chave){
            end=meio-1;
        }else{
            start=meio+1;
        }

        if(end < tabela.length)
            end++;//copyOfRange vai até end-1

        int[] newt=Arrays.copyOfRange(tabela,start,end); //com copia de dados

        return pesquisaBinariaRecursiva(chave,newt);
    }
}

// PERQUISA BINÁRIA RECURSIVA:
// O algoritmo de pesquisa binária com uma comparação reduz para metadre o espaço de pesquisa
// É de complexidade temporal logaritmica O(log(n)), logaritmo base 2
// Se for implementado de forma recursiva, a cada iteração a função de pesquisa duplica-se, abrindo uma nova instância
// Complexidade espacial logaritmica também