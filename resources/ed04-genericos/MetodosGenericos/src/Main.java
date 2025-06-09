public class Main {
    public static void imprime1 (String [] m){
        for(String a: m){
            System.out.println(a);
        }
    }

    public static <T> void imprime2 (T [] m){
        for(T a: m){
            System.out.println(a);
        }
    }

    public static <T> T escolheAleat(T a, T b){
        T ret;
        if(Math.random()>0.5){
            ret=a;
        }else{
            ret=b;
        }
        return ret;
    }

    public static void main(String[] args) {
        String m[]={"José","António"};
        Integer n[]={2,3};

        System.out.println("-----imprime1(m)-----");
        imprime1(m);

        System.out.println("-----imprime2(m)-----");
        imprime2(m);

        System.out.println("-----imprime2(n)-----");
        imprime2(n);

        System.out.println("-----imprime2(escolheAleat(m,n))-----");
        imprime2(escolheAleat(m,n));
    }
}
