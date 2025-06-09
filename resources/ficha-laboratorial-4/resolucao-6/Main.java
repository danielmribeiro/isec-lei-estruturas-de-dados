package ficha4ed;

public class Main {

    public static void main(String[] args) {
	    DezReaisMutavel drm = new DezReaisMutavel();
	    ItDezReaisMutavel idrm = new ItDezReaisMutavel(drm);

	    for(int i = 0; i < 10; i++)
	    	drm.add(i*0.1+5.0);
	    Double dbl;
	    
    }
}