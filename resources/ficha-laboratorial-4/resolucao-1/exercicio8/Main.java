package exercicio8;

import exercicio7.DezReais;
import exercicio7.DezReaisMutavel;

import java.util.Iterator;

public class Main {
    public static <T extends Comparable<? super T> > T  maior(Iterable<T> d){
        Iterator<T> it=d.iterator();
        T m,temp;

        m= it.next();

        while (it.hasNext()) {
            temp=it.next();
            if(temp.compareTo(m)>0)
                m=temp;
        }
        return m;
    }

    public static void main(String[] args) {
        exercicio7.DezReais d = new DezReais();
        d.add(12.8);
        d.add(132.5);
        d.add(123.3);
        d.add(413.2);
        d.add(21.4);
        d.add(90.6);

        exercicio7.DezReaisMutavel drm = new DezReaisMutavel();
        drm.add(9.4);
        drm.add(65.3);
        drm.add(543.4);
        drm.add(54.4);
        drm.add(12.4);
        drm.add(4.4);

        System.out.println(maior(d));
        System.out.println(maior(drm));
    }
}
