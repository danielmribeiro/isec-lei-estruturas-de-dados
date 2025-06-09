package exercicio7;

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
        int chave= 7;
        //int array[]=criaArrayCom(chave,11,false);
        int array[]={3,3,7,12,12,15};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
        boolean resultado = pesquisaDuplicado(chave,array);
        System.out.println(resultado);
    }

    private static boolean pesquisaDuplicado(int chave, int[] tabela) {
        int elemento = pesquisaBinaria(chave,tabela);
        if(elemento<0){
            return false;
        }else{
            if(elemento==0){// Limite inferior da tabela, só se pode comparar o seguinte
                if(chave!=tabela[elemento+1]){
                    return false;
                }else{
                    return true;
                }
            }else if(elemento== tabela.length-1){// Limite superior da tabela, só se pode comparar o anterior
                if(chave!=tabela[elemento-1]){
                    return false;
                }else{
                    return true;
                }
            }else{
                if(tabela[elemento]==tabela[elemento+1] || tabela[elemento]==tabela[elemento-1]){
                    return true;
                }else {
                    return false;
                }
            }
        }
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
