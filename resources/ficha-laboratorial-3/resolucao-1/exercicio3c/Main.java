package exercicio3c;

public class Main {
    public static void main(String[] args) {
        Comparable<Object> co = new Comparable<Object>() {
            @Override
            public int compareTo(Object arg0) {
                return 0;
            }
        };
        Comparable<exercicio3b.Figura> cf = new Comparable<exercicio3b.Figura>() {
            @Override
            public int compareTo(exercicio3b.Figura arg0) {
                return 0;
            }
        };
        Comparable<exercicio3b.Rectangulo> cr = new Comparable<exercicio3b.Rectangulo>() {
            @Override
            public int compareTo(exercicio3b.Rectangulo arg0) {
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
        System.out.println(comparaDoisObjetos(r1,f1));//figura
        System.out.println(comparaDoisObjetos(r1,r2));//rectangulo
        System.out.println(comparaDoisObjetos(r1,x));//classe x que seja Comparable<Rectangulo>
        System.out.println(comparaDoisObjetos(r1,y));//classe y que seja Comparable<Figura>
        System.out.println(comparaDoisObjetos(r1,z));//classe z que seja Comparable<Object>
        System.out.println(comparaDoisObjetos(r1,co));
        //System.out.println(comparaDoisObjetos(r1,cf));
        //System.out.println(comparaDoisObjetos(r1,cr));
        System.out.println(comparaDoisObjetos("dsadsadsad","fasdsa"));//OK
    }

    private static <T> boolean comparaDoisObjetos(T o1, Comparable<? super T> o2) {
        return o2.compareTo(o1)==0;
    }

}
