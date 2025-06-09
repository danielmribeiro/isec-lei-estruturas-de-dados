package exercicio3a;

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
        Rectangulo r3 = new Rectangulo(8,5);
        System.out.println(comparaDuasFiguras(r1,r2));
        System.out.println(comparaDuasFiguras(r3,r2));
        //System.out.println(comparaDuasFiguras(r3,co));//ERRO
        //System.out.println(comparaDuasFiguras(r3,cf));//ERRO
        //System.out.println(comparaDuasFiguras(r3,cr));//ERRO
    }

    private static boolean comparaDuasFiguras(Figura f1, Figura f2) {
        return f2.compareTo(f1)==0;
    }
}
