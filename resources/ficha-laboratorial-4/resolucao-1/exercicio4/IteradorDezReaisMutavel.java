package exercicio4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorDezReaisMutavel implements Iterator {
    DezReaisMutavel drm;
    int pos;
    boolean podeRemover = false;
    int modificacoesConhecidas = 0;

    public IteradorDezReaisMutavel(DezReaisMutavel dezReaisMutavel) {
        drm=dezReaisMutavel;
        pos=-1;
        modificacoesConhecidas = drm.getModificacoes();
    }

    @Override
    public boolean hasNext() {
        return pos+1<drm.size();
    }

    @Override
    public Double next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        podeRemover = true;
        return drm.get(++pos);
    }

    @Override
    public void remove() {
        if (drm.num == -1) {
            throw new IllegalStateException();
        }
        drm.remove(pos);
        podeRemover = false;
        modificacoesConhecidas++;
    }
}
