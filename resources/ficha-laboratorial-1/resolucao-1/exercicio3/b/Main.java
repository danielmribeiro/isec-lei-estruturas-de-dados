package exercicio3.b;

public class Main {

    public static void main(String[] args) {
        int matriz[][] = new int[][]{
                {1,2,3,4},
                {6,8,20,21},
                {22,23,27,43},
                {44,56,78,93}
        };
        int numeroAProcurar=matriz[matriz.length-1][matriz.length-1];

        boolean resultado = procuraNumero(numeroAProcurar,matriz);
        System.out.println(resultado);
    }

    private static boolean procuraNumero(int numeroAProcurar, int[][] matriz) {
        int N=matriz.length;
        int linha=0, coluna=0;
        while(linha < N && coluna >=0){
            if(matriz[linha][coluna]==numeroAProcurar){
                return true;
            }else{
                coluna++;
                if(coluna==N){
                    coluna=0;
                    linha++;
                }
            }
        }
        return false; //o numero não existe na matriz
    }

}
