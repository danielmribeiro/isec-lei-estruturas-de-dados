public class Iteradores {
//    public class Par <T> implements Iterable<T>{
//        T p1,p2;
//
//        Iterator<T> iterator(){
//            return new IteratorPar<T>(this);
//        }
//    };
//
//    public class IteratorPar<T> implements Iterator<T>{
//        int counter=0;
//        Par<T> par;
//        IteratorPar(Par<T> p){
//            par=p;
//        }
//
//        Boolean hasNext(){
//            return counter!=2;
//        }
//
//        T next(){
//            switch(counter){
//                case 0:
//                    counter++;
//                    return par.p1;
//                case 1:
//                    counter++;
//                    return par.p2;
//                default:
//                    throw new NoSuchElementException();
//            }
//        }
//    }
//
//    public <T> boolean procura(Iterable<T> m, T o){
//        Iterator<T> it=m.iterator();
//        boolean proximo=it.hasNext();
//        while(proximo){
//            if(it.next()==o)   // compara referência, não conteúdo
//                return true;
//            proximo=it.hasNext();
//        }
//        return false;
//    }
//
}
