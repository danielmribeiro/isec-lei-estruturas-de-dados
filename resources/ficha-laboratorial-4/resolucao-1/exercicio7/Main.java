package exercicio7;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DezReais d = new DezReais();
        d.add(12.8);
        d.add(132.5);
        d.add(123.3);
        d.add(413.2);
        d.add(21.4);
        d.add(90.6);

        DezReaisMutavel drm = new DezReaisMutavel();
        drm.add(9.4);
        drm.add(65.3);
        drm.add(543.4);
        drm.add(54.4);
        drm.add(12.4);
        drm.add(4.4);

        System.out.println(maior(d));
        System.out.println(maior(drm));
    }

    public static Double maior(Iterable<Double> d){
        Iterator<Double> it=d.iterator();
        Double m,temp;

        m= it.next();

        while (it.hasNext()) {
            temp=it.next();
            if(temp>m)
                m=temp;
        }
        return m;
    }
}
