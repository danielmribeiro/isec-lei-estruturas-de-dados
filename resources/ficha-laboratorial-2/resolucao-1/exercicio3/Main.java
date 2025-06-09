package exercicio3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static int[] criaArrayCom(int valor, int dimensao, boolean diferentes){
        int m[]=new int[dimensao];
        if(diferentes){
            for (int i = 0; i < dimensao; i++) {
                m[i]=i*10;
            }
            if((valor%10!=0)||(0>valor)||(valor>(dimensao-1)*10))
                m[0]=valor;
        } else{
            Random r = new Random();
            int gama=(Math.abs(valor)<10)?10:Math.abs(valor);
            for (int i = 0; i < dimensao; i++) {
                m[i]=r.nextInt(gama*4)-gama*2;
            }
            m[0]=valor;
        }
        Arrays.sort(m);
        return m;
    }

    public static void main(String[] args) {
        int chave=90;
        int array[]=criaArrayCom(chave,11,true);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
        int resultado = pesquisaBinaria(12,array);
        System.out.println(resultado);
    }

    private static int pesquisaBinaria(int chave, int[] tabela) {
        int start=0;
        int end=tabela.length-1;
        int meio=(start+end)/2;
        do{
            if(chave==tabela[meio]){
                return meio;
            }else if(chave>tabela[meio]){
                start=meio+1;
            }else{//chave<tabela[meio]
                end=meio-1;
            }
            meio=(start+end)/2;
        }while(start<end);
        if(tabela[meio]==chave) {
            return meio;
        }else{
            return -1;
        }
    }
}
