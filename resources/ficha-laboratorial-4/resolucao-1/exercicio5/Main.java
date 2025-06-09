package exercicio5;


public class Main {
    public static void main(String[] args) {
        DezReaisMutavel drm = new DezReaisMutavel();
        IteradorDezReaisMutavel idrm = new IteradorDezReaisMutavel(drm);

        for (int i = 0; i < 10; i++) {
            drm.add(1.0*i);
        }

        System.out.println(); drm.toString();

        idrm.next();
        idrm.next();

        idrm.remove();

        System.out.println(); drm.toString();

        idrm.next();
        idrm.next();

        idrm.remove();

        System.out.println(); drm.toString();

        idrm.remove();
        idrm.remove();

        System.out.println(); drm.toString();
    }
}
