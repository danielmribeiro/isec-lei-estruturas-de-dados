package exercicio5;

public class DezReaisMutavel {
    protected final int MAXIMO = 10;
    protected double[] array = new double[MAXIMO];
    int num = 0;
    int modificacoes = 0;

    public Double get(int pos){
        return array[pos];
    }

    public boolean add(Double x) {
        modificacoes++;
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

    public IteradorDezReaisMutavel iterator(){
        return new IteradorDezReaisMutavel(this);
    }

    public void remove(int pos) {
        modificacoes++;
        for (int i = pos; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size()]=0.0;
        --num;
    }

    public int getModificacoes() {
        return modificacoes;
    }
}
