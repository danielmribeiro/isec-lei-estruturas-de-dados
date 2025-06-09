package exercicio1;

public class Main {
    private static long stopTime;
    private static long startTime;
    static void funcao(long n){ //O(N^2)
        long soma=0;
        startTimer();
        for(int x=1;x<100;x++)
            for(int i=0;i<n;i++)
                if(i>100)
                    for(int k=0;k<n-i;k++)
                        soma++;
        System.out.print("Soma="+soma);
        stopTimer();
        showTime();
    }
    private static void showTime() {
        long interval=stopTime-startTime;
        long secs=interval/1000000000L;
        long decs=interval-secs*1000000000L;
        decs/=100000000L;
        System.out.println("\tsecs="+secs+"."+decs);
    }
    private static void stopTimer() {
        stopTime=System.nanoTime();
    }
    private static void startTimer() {
        startTime=System.nanoTime();
    }
    public static void main(String[] args) {
        long n = 4000;
        System.out.print("N:\t");    funcao(n);
        System.out.print("4N:\t");   funcao(4*n);
    }

}
