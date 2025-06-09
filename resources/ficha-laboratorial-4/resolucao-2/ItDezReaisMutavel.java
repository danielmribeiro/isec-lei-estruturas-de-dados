package ficha4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author nelio
 */
public class ItDezReaisMutavel implements Iterator<Double> {

    int posUltimo = -1;
    boolean podeRemover = false;
    DezReaisMutavel drm;
    int modificacoesConhecidas = 0;

    public ItDezReaisMutavel(DezReaisMutavel drm) {
        this.drm = drm;
        modificacoesConhecidas = drm.getModificacoes();
    }

    @Override
    public boolean hasNext() {
        verificaModificacao();
        return posUltimo + 1 < drm.size();
    }

    @Override
    public Double next() {
        verificaModificacao();
        if (posUltimo + 1 >= drm.size()) {
            throw new NoSuchElementException();
        }
        podeRemover = true;
        return drm.get(++posUltimo);
    }

    @Override
    public void remove() {
        if (!podeRemover) {
            throw new IllegalStateException();
        }
        podeRemover = false;        //apos remover, nao é possivel remover novamente
        System.out.println("removing: " + drm.get(posUltimo));
        drm.remove(posUltimo);
        posUltimo--;
        modificacoesConhecidas++;
    }

    public void verificaModificacao() {
        if(modificacoesConhecidas != drm.getModificacoes()) 
            throw new ConcurrentModificationException();
    }

}
