package exercicio8;

import java.util.ConcurrentModificationException;
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
        if(modificacoesConhecidas!=drm.getModificacoes()){
            throw new ConcurrentModificationException();
        }
        return pos + 1 < drm.size();
    }

    @Override
    public Double next() {
        if(modificacoesConhecidas!=drm.getModificacoes()){
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        podeRemover = true;
        return drm.get(++pos);
    }

    @Override
    public void remove() {
        if(modificacoesConhecidas!=drm.getModificacoes()){
            throw new ConcurrentModificationException();
        }
        if (drm.num == -1) {
            throw new IllegalStateException();
        }
        drm.remove(pos);
        podeRemover = false;
        modificacoesConhecidas++;
    }
}
