package Exercicio8;

import java.util.Iterator;

public class Exercicio8 {
    
    public static <T extends Comparable<? super T>> T maior(Iterable<T> d) {
        Iterator<T> it = d.iterator();
        T m, j;

        m = it.next();
        while(it.hasNext() ){
            j=it.next();
            if(j.compareTo(m) > 0)
                m=j;
        }
        return m;
    }
    
    
    public static void main(String[] args) {
        DezReais d = new DezReais();
        ItDezReais id = new ItDezReais(d);

        int j;

        for (j = 0; j < 10; j++) {
            d.add(j * 0.1);
        }

        while (id.hasNext()) {
            System.out.println("ultimo: " + id.next());
        }

        DezReaisMutavel drm = new DezReaisMutavel();
        ItDezReaisMutavel idrm = new ItDezReaisMutavel(drm);

        for (j = 0; j < 10; j++) {
            drm.add(j * 0.1 + 5.0);
        }

        j = 0;
        Double dbl;

        while (idrm.hasNext() && (dbl = idrm.next()) < 0.4) {
            System.out.println((j++) + ": ultimo: " + dbl);
        }

        idrm.remove();


        ItDezReaisMutavel idrm2 = new ItDezReaisMutavel(drm);
        j = 0;

        while (idrm2.hasNext())
            System.out.println((j++) + ": Sem 5.5 " + idrm2.next());
    }
}
