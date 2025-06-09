package FunctorComparator;

interface Comparator<T>{
    public int compare(T o1, T o2);
}

class Comparador2Char implements Comparator<String>{
    @Override
    public int compare(String o1, String o2){
        Character c1 = new Character(o1.charAt(1));
        Character c2 = new Character(o2.charAt(1));
        return o1.compareTo(o2);
    }
}


//    List<String> c= ...
//    sort(c,new Comparator2Char());  //c fica ordenado de acordo com o 2º caracter das Strings que armazena

class DefaultComparator <E extends Comparable<? super E> > implements Comparator<E>{
    @Override
    public int compare(E lhs, E rhs){
        return lhs.compareTo(rhs);
    }
}