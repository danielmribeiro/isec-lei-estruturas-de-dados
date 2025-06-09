package exercicio2;

public class DezReais {
    protected final int MAXIMO = 10;
    protected double[] array = new double[MAXIMO];
    int num = 0;

    public boolean add(double x){
        if (num == MAXIMO) {
            throw new RuntimeException();
        }
        array[num++] = x;
        return true;
    }

    @Override
    public String toString() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("["+array[i]+"]");
        }
        return "";
    }

    public int size() {
        return num;
    }

    public Double get(int pos) {
        return array[pos];
    }
}
