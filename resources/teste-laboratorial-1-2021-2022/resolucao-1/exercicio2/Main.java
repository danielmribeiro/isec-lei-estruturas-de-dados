package exercicio2;

public class Main {
    public static void main(String[] args) {
        int m[]={1,4,6,9,20};
        intervalo(m,4); // 4 está contido em [4,6]
        //(não [4,4] porque os limites inf e sup têm de ser diferentes
        // não [1,4] porque é maior do que [4,6]: 4-1=3 e 6-4=2 )
        intervalo(m,1); //1 está contido em [1,4]
        intervalo(m,6); // 6 está contido em [4,6]
        intervalo(m,9); // 9 está contido em [6,9]
        intervalo(m,20); // 20 está contido em [9,20]
        System.out.println("nao existentes");
        intervalo(m,2); //2 está contido em [1,4]
        intervalo(m,7); //7 está contido em [6,9]
        intervalo(m,15); //15 está contido em [9,20]
        intervalo(m,22); // 22 está contido em [2o,+inf[
        intervalo(m,-3); // 0 está contido em ]-inf,1]
    }

    private static void intervalo(int[] m, int x) {
        int resultado=pesquisa(m,x);
        System.out.println("Resultado="+resultado);
        if(resultado>=0){
            if(resultado-1<0 && resultado+1>m.length-1){
                System.out.println(x+" está contido em ]-inf,+inf[");
            }else if(resultado-1<0){
                System.out.println(x+" está contido em ["+m[resultado]+","+m[resultado+1]+"]");
            }else if(resultado+1>m.length-1){
                System.out.println(x+" está contido em ["+m[resultado-1]+","+m[resultado]+"]");
            }else{
                if(m[resultado+1]-m[resultado]<m[resultado]-m[resultado-1]){
                    System.out.println(x+" está contido em ["+m[resultado]+","+m[resultado+1]+"]");
                }else{
                    System.out.println(x+" está contido em ["+m[resultado-1]+","+m[resultado]+"]");
                }
            }
        }else{
            resultado=-(resultado+1);
            if(resultado-1<0 && resultado+1>m.length-1){
                System.out.println(x+" está contido em ]-inf,+inf[");
            }else if(resultado-1<0){
                System.out.println(x+" está contido em ]-inf,"+m[0]+"]");
            }else if(resultado+1>m.length-1){
                System.out.println(x+" está contido em ["+m[m.length-1]+",+inf[");
            }else{
                if(m[resultado]<x){
                    System.out.println(x+" está contido em ["+m[resultado]+","+m[resultado+1]+"]");
                }else{
                    System.out.println(x+" está contido em ["+m[resultado-1]+","+m[resultado]+"]");
                }
            }
        }
    }

    public static int pesquisa(int m[], int valor){
        int start=0;
        int end=m.length-1;
        int meio=(start+end)/2;
        do{
            if(valor==m[meio]){
                return meio;
            }if(valor<m[meio]){
                end=meio-1;
            }else{
                start=meio+1;
            }
            meio=(start+end)/2;
        }while(start<end);
        if(m[meio]==valor) {
            return meio;
        }else if(valor>m[meio]){
            return -meio-2; // Chave deve ir para a direita do meio
        }else{
            return -meio-1; // Chave deve ir para a esquerda do meio
        }
    }
}
