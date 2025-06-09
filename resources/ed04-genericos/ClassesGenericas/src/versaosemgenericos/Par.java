package versaosemgenericos;

public class Par {
    Object primeiro;
    Object segundo;

    public Par(Object a, Object b) {
        primeiro = a;
        segundo = b;
    }

    public Object getPrimeiro() {
        return primeiro;
    }

    public Object getSegundo() {
        return segundo;
    }

    public void setPrimeiro(Object a) {
        primeiro = a;
    }

    public void setSegundo(Object b) {
        segundo = b;
    }
}
