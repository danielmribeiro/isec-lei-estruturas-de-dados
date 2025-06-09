public class Main {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9,10};
        int chave =9; //valor de comparação

        System.out.println(pesquisaSequencial(array,chave));
    }

    private static String pesquisaSequencial(int[] array, int chave) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == chave){
                return "A primeira localização do valor "+chave+" encontra-se no index "+i;
            }
        }
        return "O elemento "+chave+" não se encontra no array.";
    }
}
