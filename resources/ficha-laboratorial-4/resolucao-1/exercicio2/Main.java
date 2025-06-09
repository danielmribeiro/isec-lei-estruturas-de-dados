package exercicio2;

public class Main {
    public static void main(String[] args) {
        DezReais dr = new DezReais();
        IteradorDezReais idr = new IteradorDezReais(dr);

        for (int i = 1; i <= 10; i++) {
            dr.add(32.9*i);
        }

        while(idr.hasNext()){
            System.out.println(idr.next());
        }
    }
}
