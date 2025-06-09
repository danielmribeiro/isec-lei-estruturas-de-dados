
package ficha5;

import java.util.*;
public class Ficha5 {

    public static <T> void myFill(List <? super T> d, T n){
        //Collections.fill(d, n);
        //for(int j=0; j<d.size(); j++)
            //d.set(j, n);
        ListIterator it = d.listIterator();
        while(it.hasNext()){
            it.next();
            it.set(n);
        }
    }
    
    void imprimeInverso(List <?> alist){
        ListIterator it = alist.listIterator(alist.size());
        int j = alist.size();
        while(it.hasPrevious())
            System.out.println("["+ (--j) +"] "+ it.previous());
    }
    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("A");
        alist.add("B");
        alist.add("C");
        System.out.println("Lista original: "+alist);
        Collections.fill(alist, "ED");
        System.out.println("Lista preenchida com fill: "+alist);
        myFill(alist, "F");
        System.out.println("Lista preenchida com myFill: "+alist);
    }
    
};
