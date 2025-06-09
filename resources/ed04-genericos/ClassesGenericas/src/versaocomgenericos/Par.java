package versaocomgenericos;

public class Par <T,S>{
    T primeiro;
    S segundo;

    public Par(T a, S b) {
        primeiro = a;
        segundo = b;
    }

    public T getPrimeiro() {
        return primeiro;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setPrimeiro(T a) {
        primeiro = a;
    }

    public void setSegundo(S b) {
        segundo = b;
    }
}
