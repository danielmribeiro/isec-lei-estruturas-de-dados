package exercicio2;

public class Main {
    public static void main(String[] args) {
        String[] tab1= {"Daniel", "Marta", "Anabela", "Agostinho", "Marta"};
        String chave1 = "Marta";
        Integer[] tab2={1,6,7,3,9,4,2,1,4,23,3,5,6};
        int chave2= 3;
        int chave3=32;
        System.out.println(encontraRepetido(tab1,chave1));
        System.out.println(encontraRepetido(tab2,chave2));
        System.out.println(encontraRepetido(tab2,chave3));
    }

    private static <T extends Comparable<T>> boolean encontraRepetido(T[] array, T chave) {
        int count = 0;
        for(T valor : array){
            if(valor.compareTo(chave)==0){
                count++;
            }
        }
        return count>1;
    }
}
