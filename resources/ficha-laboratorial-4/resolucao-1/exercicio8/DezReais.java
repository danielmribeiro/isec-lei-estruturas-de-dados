package exercicio8;

public class DezReais implements Iterable<Double>{
    protected final int MAXIMO = 10;
    protected double[] array = new double[MAXIMO];
    int num = 0;

    public Double get(int pos){
        return array[pos];
    }

    public boolean add(Double x) {
        if (num == MAXIMO) {
            throw new RuntimeException();
        }
        array[num++] = x;
        return true;
    }

    public int size() {
        return num;
    }

    @Override
    public String toString() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("["+array[i]+"]");
        }
        return "";
    }

    public IteradorDezReais iterator(){
        return new IteradorDezReais(this);
    }
}
