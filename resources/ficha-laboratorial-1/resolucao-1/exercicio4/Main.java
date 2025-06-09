package exercicio4;

public class Main {
    private static long stopTime;
    private static long startTime;
    private static int n;
    private static int numeroDeIteracoes;

    public static int maxSeqContV1(int []m){ //O(N^3)
        int maxSoma=0;
        numeroDeIteracoes=0;
        int N=m.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int estaSoma=0;
                for(int k=i;k<=j;k++){
                    estaSoma+=m[k];
                    numeroDeIteracoes++;
                }
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return maxSoma;
    }

    public static int maxSeqContV2(int []m){ //O(N^2)
        int maxSoma=0;
        numeroDeIteracoes=0;
        int N=m.length;
        for (int i = 0; i < N; i++) {
            int estaSoma=0;
            for (int j = i; j < N; j++) {
                estaSoma+=m[j];
                numeroDeIteracoes++;
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return maxSoma;
    }

    public static int maxSeqContV3a(int []m){ //O(N^2)
        int maxSoma=0;
        int N=m.length;
        numeroDeIteracoes=0;
        for (int i = 0; i < N; i++) {
            int estaSoma=0;
            for (int j = i; j < N; j++) {
                estaSoma+=m[j];
                numeroDeIteracoes++;
                if(estaSoma<0){
                    break;
                }
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return maxSoma;
    }

    public static int maxSeqContV3b(int []m){ //O(N^2)
        int maxSoma=0;
        int N=m.length;
        numeroDeIteracoes=0;
        for(int i=0; i<N; i++){
            int estaSoma=0;
            for(int j=i;j<N;j++){
                estaSoma+=m[j];
                numeroDeIteracoes++;
                if(estaSoma<0){
                    i=j;
                    break;
                }
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return maxSoma;
    }

    public static int maxSeqContV3c(int []m){ //O(N)
        int maxSoma=0;
        int N=m.length;
        int estaSoma=0;
        numeroDeIteracoes=0;
        for(int i=0; i<N; i++){
            estaSoma+=m[i];
            numeroDeIteracoes++;
            if(estaSoma>maxSoma){
                maxSoma=estaSoma;
            }
            if(estaSoma<0){
                estaSoma=0;
            }
        }
        return maxSoma;
    }

    public static void main(String[] args) {
        int resultado;
        int numero=0;
        int conjunto1[]= {2,3,4,-2,5,6,-8,-5,3,4}; //array de valores1
        n=conjunto1.length;

        System.out.println("### Versao 1 ###");
        startTimer();
        resultado=maxSeqContV1(conjunto1);
        stopTimer();
        showTime();
        System.out.println("Máxima Sequencia Contígua? "+resultado);
        System.out.println("Numero de Iterações: "+numeroDeIteracoes);

        System.out.println("### Versao 2 ###");
        startTimer();
        resultado=maxSeqContV2(conjunto1);
        stopTimer();
        showTime();
        System.out.println("Máxima Sequencia Contígua? "+resultado);
        System.out.println("Numero de Iterações: "+numeroDeIteracoes);

        System.out.println("### Versao 3a ###");
        startTimer();
        resultado=maxSeqContV3a(conjunto1);
        stopTimer();
        showTime();
        System.out.println("Máxima Sequencia Contígua? "+resultado);
        System.out.println("Numero de Iterações: "+numeroDeIteracoes);

        System.out.println("### Versao 3b ###");
        startTimer();
        resultado=maxSeqContV3b(conjunto1);
        stopTimer();
        showTime();
        System.out.println("Máxima Sequencia Contígua? "+resultado);
        System.out.println("Numero de Iterações: "+numeroDeIteracoes);

        System.out.println("### Versao 3c ###");
        startTimer();
        resultado=maxSeqContV3c(conjunto1);
        stopTimer();
        showTime();
        System.out.println("Máxima Sequencia Contígua? "+resultado);
        System.out.println("Numero de Iterações: "+numeroDeIteracoes);
    }

    private static void showTime() {
        long interval=stopTime-startTime;
        long secs=interval/1000000000L;
        long decs=interval-secs*1000000000L;
        decs/=100000000L;
        System.out.println("secs="+secs+"."+decs);
    }
    private static void stopTimer() {
        stopTime=System.nanoTime();
    }
    private static void startTimer() {
        startTime=System.nanoTime();
    }
}
