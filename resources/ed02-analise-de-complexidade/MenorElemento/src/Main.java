public class Main {
    public static void main(String[] args) {
        int[] array={54,65,75,34,23,21,43,32,12,64};
        int min=array[0];

        for (int i = 0; i < array.length; i++) {
            System.out.println("### Iteracão "+(i+1)+" ###");
            if(min>array[i]){
                System.out.println("O menor elemento será atualizado de "+min+" para "+array[i]);
                min=array[i];
            }
            System.out.println("O menor elemento atual é "+min);
        }

        // Dado que é necessário realizar a mesma quantidade de trabalho para todos os elementos do array, o processo é linear.
    }
}
