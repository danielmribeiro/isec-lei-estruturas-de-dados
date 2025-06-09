package exercicio3b;

public class Main {


    public static void main(String[] args) {
        Comparable<Object> co = new Comparable<Object>() {
            @Override
            public int compareTo(Object arg0) {
                return 0;
            }
        };
        Comparable<Figura> cf = new Comparable<Figura>() {
            @Override
            public int compareTo(Figura arg0) {
                return 0;
            }
        };
        Comparable<Rectangulo> cr = new Comparable<Rectangulo>() {
            @Override
            public int compareTo(Rectangulo arg0) {
                return 0;
            }
        };
        Rectangulo r1 = new Rectangulo(2,3);
        Rectangulo r2 = new Rectangulo(5,8);
        Figura f1 = new Figura() {
            @Override
            public double area() {
                return 0;
            }
        };
        X x = new X();
        Y y = new Y();
        Z z = new Z();
        System.out.println(comparaDuasFiguras(r1,f1));//figura
        System.out.println(comparaDuasFiguras(r1,r2));//rectangulo
        System.out.println(comparaDuasFiguras(r1,x));//classe x que seja Comparable<Rectangulo>
        System.out.println(comparaDuasFiguras(r1,y));//classe y que seja Comparable<Figura>
        System.out.println(comparaDuasFiguras(r1,z));//classe z que seja Comparable<Object>
        System.out.println(comparaDuasFiguras(r1,co));
        System.out.println(comparaDuasFiguras(r1,cf));
        System.out.println(comparaDuasFiguras(r1,cr));
    }

    private static boolean comparaDuasFiguras(Rectangulo f1, Comparable<? super Rectangulo> f2) {
        return f2.compareTo(f1)==0;
    }
}
