package exercicio3;

public class Main {
    public static void main(String[] args) {
        DezReais dr = new DezReais();
        IteradorDezReais idr = new IteradorDezReais(dr);

        System.out.println(idr.next());
    }
}
