public class Main {
    public static <T extends Number> boolean maior (T p1, T p2){
        return p1.doubleValue()>p2.doubleValue();
    }

    public static void main(String[] args) {
        Quad q1=new Quad(1), q2=new Quad(2);
        Rect r1=new Rect(2,3), r2=new Rect(3,4);
        Par<Quad,Rect> p1 = new Par<>(q1,r1);
        Par<Quad,Rect> p2 = new Par<>(q2,r2);
        p2.copia(p1);   //ok
        Par<Rect,Rect> p3 = new Par<>(q1,r1);
        Par<Rect,Rect> p4 = new Par<>(q2,r2);
        p3.copia(p4);   //ok
        p3.copia(p1);   //ok

        if(maior(33,4)){
            System.out.println("maior");
        }
        boolean m=maior("ola","adeus"); //erro de compilação
        // String não estende Number.

        Rect r= new Rect(2,3), q=new Rect(3,4);
        r.compareTo(q); //ok, é válido, apesar de Rect não ser Comparable<Rect> porque é Comparable<Figura>
    }

//
//    Exemplo 1:
//    public static <T,S> void f(par<T,S> p){}
//
//    Pode ser escrito como:
//    public static void f(par<?,?> p){}
//
//    Exemplo 2:
//    public static <T,S extends T> void f(par<T,S> p){}
//
//    Pode ser escrito como:
//    public static <T> void f(par<T,? extends T> p){}
//



    //Como usar wildcards para definir um método que recebe um parametro Rect e qualquer outro que possa ser comparado com ele?

    static int compara(Rect r, Comparable<Rect> c){
        // não funciona bem... Qualquer figura é comparável com Rect...
        return c.compareTo(r);
    }

    static int compara(Rect r, Comparable<Figura> c){
        // Já funciona melhro, mas infelizmente obriga-nos a saber que é exactamente a nível da classe Figura que se define a comparação...
        // Se também for possivel comparar uma outra classe não relacionada com figura(p.ex: Colorido) com um rectangulo, então não irá funcionar nesse caso...
        return c.compareTo(r);
    }

    static int compara(Rect r, Comparable<? super Rect> c){
        // Já funciona bem em todos os casos. Pode receber um objeto que seja comparável com Rect, ou então com Figura, ou então com Object...
        return c.compareTo(r);
    }


    static <T> int compara(T r, Comparable<? super T> c){
        //generalizando o Rect papra que a função possa receber qualquer tipo de objetos
        return c.compareTo(r);  //ok
    }
}
