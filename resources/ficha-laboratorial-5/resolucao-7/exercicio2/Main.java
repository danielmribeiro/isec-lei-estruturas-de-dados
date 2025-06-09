package exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void ordemInversa(List<?> alist){
        ListIterator it = alist.listIterator(alist.size());
        int j= alist.size();
        while(it.hasPrevious())
            System.out.println("["+(--j)+"] "+it.previous());
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("Daniel");
        alist.add("Marta");
        alist.add("Pedro");

        System.out.println(alist);
        ordemInversa(alist);
    }


}
