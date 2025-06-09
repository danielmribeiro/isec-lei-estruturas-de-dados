package exercicio4;

import java.util.List;

public class Fila<T> {
    List<? super T> lista;

    public Fila(List<? super T> lista) {
        this.lista = lista;
    }

    public void add(T objeto) {
        lista.add(objeto);
    }

    public T remove() {
        return (T) lista.remove(0);
    }

    public T element() {
        return (T) lista.get(0);
    }
}
