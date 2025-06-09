package exercicio5;

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
        int chave= 30;
        int array[]=criaArrayCom(chave,11,true);
        //int array[]={3,7,12,15};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
        double resultado = percentagemDeValoresInferiores(8,array);
        System.out.println(resultado);
    }

    private static double percentagemDeValoresInferiores(int chave, int[] tabela) {
        int pos = pesquisaBinaria(chave,tabela); //Método da Alínea Anterior

        //se o valor existe
        if(pos>=0)
            return (double)pos/tabela.length;

        //se o valor não existe
        int posInsert=-pos-1;
        //o valor na pos de inserção é menor e deve contar
        return posInsert/(double)tabela.length;
    }

    private static int pesquisaBinaria(int chave, int[] tabela) {
        int start=0;
        int end=tabela.length-1;
        int meio=(start+end)/2;
        do{
            if(chave==tabela[meio]){
                return meio;
            }if(chave<tabela[meio]){
                end=meio-1;
            }else{
                start=meio+1;
            }
            meio=(start+end)/2;
        }while(start<end);
        if(tabela[meio]==chave) {
            return meio;
        }else if(chave>tabela[meio]){
            return -meio-2; // Chave deve ir para a direita do meio
        }else{
            return -meio-1; // Chave deve ir para a esquerda do meio
        }
    }
}
