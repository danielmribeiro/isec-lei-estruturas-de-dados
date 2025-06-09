import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array={5,7,2,9,20,43,3,65,23,76,98,8,12};
        int chave = 20;  //valor de comparação

        System.out.println("Array Original:\t"+imprimeArray(array)+"\n");
        Arrays.sort(array);
        System.out.println("Array Ordenado:\t"+imprimeArray(array)+"\n");
        System.out.println(pesquisaBinaria(chave,array));

    }

    private static StringBuilder imprimeArray(int[] array) {
        StringBuilder stringArray= new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            stringArray.append("["+array[i]+"]");
            if(i< array.length-1){
                stringArray.append(",");
            }
        }
        stringArray.append("}");
        return stringArray;
    }

    private static String pesquisaBinaria(int chave, int[] array) {
        array=Arrays.sort(array);
        int min=0;
        int max=array.length-1;
        int iteracoes = 0;
        while(min<=max){
            iteracoes=++iteracoes;
            int tentativa = (min + max) / 2;

            System.out.println(
                    "min: valores["+min+"]="+array[min]+
                    "\nmax: valores["+max+"]="+array[max]+
                    "\ntentativa atual: valores["+tentativa+"]="+array[tentativa]
            );

            if(array[tentativa]==chave){
                System.out.println("\nEncontrou !\n");
                return "O valor "+chave+" demorou "+iteracoes+" iterações a ser encontrado.";
            }else if(array[tentativa]<chave){
                System.out.println("chave > tentativa; "+chave+">"+array[tentativa]);
                min = tentativa + 1;
            }else if(array[tentativa]>chave){
                System.out.println("chave < tentativa; "+chave+"<"+array[tentativa]);
                max = tentativa - 1;
            }else{
                return "chave não existe no array";
            }
            System.out.println("");
        }
        return "ERRO";
    }
}
