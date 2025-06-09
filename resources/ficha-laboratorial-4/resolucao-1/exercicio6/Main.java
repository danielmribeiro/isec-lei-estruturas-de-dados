package exercicio6;

public class Main {
    public static void main(String[] args) {
        DezReaisMutavel drm = new DezReaisMutavel();
        IteradorDezReaisPositivos idrm = new IteradorDezReaisPositivos(drm);

        drm.add(-5.0);
        drm.add(3.0);
        drm.add(-5.0);
        drm.add(4.0);
        drm.add(2.3);
        drm.add(-4.0);
        drm.add(-6.2);
        drm.add(9.1);

        while (idrm.hasNext())
            System.out.println(idrm.next());
    }
}
