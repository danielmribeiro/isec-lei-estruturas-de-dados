package exercicio1;

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

    private static <T> boolean encontraRepetido(T array[], T chave) {
        int count=0;

        for(T valor : array){
            if(valor == chave){
                count++;
                if(count>1)
                    return true;
            }
        }
        return false;
    }
}
