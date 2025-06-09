package exercicio3b;

public abstract class Figura implements Comparable<Figura>{
    public abstract double area();
    @Override
    public int compareTo(Figura fig) {
        double dif=area()-fig.area();
        if(dif>0){
            return 1;
        }else if(dif<0){
            return -1;
        }else {
            return 0;
        }
    }
}
