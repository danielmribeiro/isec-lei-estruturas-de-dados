package versaosemgenericos;

public class Main {
    public static void main(String[] args) {
        Par p1=new Par("Par1",1);
        Par p2=new Par(2,"Par2");

        Integer i1=(Integer)(p1.getSegundo());  //ok
        //Integer i2=(Integer)(p2.getSegundo());  //erro de execução! - ClassCastException
    }
}
