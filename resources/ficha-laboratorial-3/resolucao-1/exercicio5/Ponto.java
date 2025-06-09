package exercicio5;

public class Ponto <A extends Number,B extends Number>{
    private A p1;
    private B p2;

    public Ponto(A x,B y){
        p1=x;
        p2=y;
    }

    //o copy suficientemente genérico aceita tipos diferentes compativeis

    public void copy(Ponto<? extends A, ? extends B> p){
        p1=p.p1;
        p2=p.p2;
    }

    public void mostra(){
        System.out.println("Ponto: {"+p1+","+p2+"}");
    }

    @Override
    public String toString() {
        return "Ponto: {"+p1+","+p2+"}";
    }
}
