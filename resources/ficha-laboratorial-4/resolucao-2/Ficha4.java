package ficha4;

import java.util.Iterator;

/**
 *
 * @author nelio
 */
public class Ficha4 {

    public static void main(String[] args) {

        int j;
        Double dbl;
        DezReais dr = new DezReais();
        ItDezReais idr = new ItDezReais(dr);
        DezReaisMutavel drm = new DezReaisMutavel();
        ItDezReaisMutavel idrm = new ItDezReaisMutavel(drm);
        
        System.out.println("DezReais (cria array)");
        for(j=0; j<10; j++)
            dr.add(j*0.1);
        
        
        System.out.println("ItDezReais (mostra array)");
        while(idr.hasNext())
            System.out.println("ultimo: " + idr.next());
        System.out.println("\n");
        
        
        System.out.println("ItDezReaisMutavel (preenche array com j * 0.1 + 4.0)");
        for(j=0; j<10; j++)
            drm.add(j*0.1+4.0);

        System.out.println("\n");
        
        
        System.out.println("ItDezReaisMutavel: (mostra os inferiores a 4.4)");
        j = 0;
        while(idrm.hasNext() && (dbl = idrm.next()) < 4.4)
            System.out.println((j++) + ": ultimo: " + dbl);     // idrm fica na ultima posição
        idrm.remove();
        System.out.println("\n");
        
        
        System.out.println("ItDezReaisMutavel2: ");
        ItDezReaisMutavel idrm2 = new ItDezReaisMutavel(drm);
        j = 0;
        while(idrm2.hasNext())
            System.out.println((j++) + ": Sem 5.5 " + idrm2.next());
        System.out.println("\n");
        
        System.out.println("[maior]: " + maior(drm));
        System.out.println("[maiorg]: " + maior(drm));
    }
    
    public static Double maior(Iterable<Double> d){
        Iterator<Double> it = d.iterator();
        Double m, j;
        
        m = it.next();
        
        while(it.hasNext()){
            j = it.next();
            if(j > m) m = j;
        }
        return m;
    }
    
    public static <T extends Comparable<? super T>> T maiorg(Iterable<T> d){
        Iterator<T> it = d.iterator();
        T m, j;
        
        m = it.next();
        
        while(it.hasNext()){
            j = it.next();
            if(j.compareTo(m) > 0 ) m = j;
        }
        return m;
    }
    
}
