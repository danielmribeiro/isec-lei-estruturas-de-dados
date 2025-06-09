package Exercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio5 {
    public static <T> void rev(List<? super T>alist){
        ListIterator iti = alist.listIterator();
        ListIterator itf = alist.listIterator(alist.size());
        T temp;

        while(iti.nextIndex()<itf.previousIndex()){
            temp=(T)iti.next();
            iti.set(itf.previous());
            itf.set(temp);
        }
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("AA");
        alist.add("BB");
        alist.add("CC");
        alist.add("DD");
        alist.add("EE");

        System.out.println(alist);
        rev(alist);
        System.out.println(alist);
    }
}
