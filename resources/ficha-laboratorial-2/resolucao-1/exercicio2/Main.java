package exercicio2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static int[] criaArrayCom(int valor, int dimensao, boolean diferentes){//(numero que vai existir na tabela, dimensao da tabela. se for true a tabela não terá repetidos)
        int m[]=new int[dimensao];
        if(diferentes){
            for(int i=0;i<dimensao;i++)
                m[i]=i*10;
            if((valor%10!=0)||(0>valor)||(valor>(dimensao-1)*10))
                m[0]=valor;
        }
        else
        {
            Random r=new Random();
            int gama=(Math.abs(valor)<10)?10:Math.abs(valor);
            for(int i=0;i<dimensao;i++)
                m[i]=r.nextInt(gama*4)-gama*2;
            m[0]=valor;
        }
        Arrays.sort(m);
        return m;
    }

    public static boolean pesquisaBinariaIterativa(int chave, int tabela[]){
        int start=0;
        int end=tabela.length-1;
        int meio=(start+end)/2;
        do{
            if(chave==tabela[meio]){
                return true;
            }else if(chave < tabela[meio]){
                end=meio-1;
            }else{
                start=meio+1;
            }
            meio=(start+end)/2;
        }while(start<end);
        return chave==tabela[meio];
    }

    public static void main(String[] args) {
        int chave=100;
        int array[]=criaArrayCom(chave,11,true);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
        boolean resultado = pesquisaBinariaIterativa(chave,array);
        System.out.println(resultado);
    }
}

// PERQUISA BINÁRIA ITERATIVA:
// A implementação iterativa (não recursiva) é mais eficiente, pois não expande o número de métodos em memória
// Devem ser evitadas soluções recursivas, sempre que há alternativas práticas
// No caso do processamento de árvores, por exemplo, usam-se soluções recursivas porque outro tipo de algoritmos seria muito complicado
