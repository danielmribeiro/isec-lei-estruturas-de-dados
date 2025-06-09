package versaocomgenericos;

public class Main {
    public static void main(String[] args) {
        // Java 7+
        Par<String, Integer> p1= new Par<>("Par1",1);

        // Java 5,6
        Par<Integer, String> p2=new Par<Integer,String>(2,"Par2");

        Integer i1=p1.getSegundo(); //ok
        //Integer i2=p2.getSegundo(); //erro de compilação!
    }
}
