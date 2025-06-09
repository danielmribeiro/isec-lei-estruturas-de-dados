public class ParComparavel <S extends Comparable<? super S>, T extends Comparable<? super T>> extends Par<S,T> implements Comparable<ParComparavel<?extends S, ? extends T>>{

    //Como definir uma classe ParComparável, sabendo que esta representa um Par cujos elementos são comparáveis.
    //A classe ParComparável deve por sua vez ser também comparável:
    //a comparação deve ser decidida através da comparação dos dois primeiros elementos de cada par, desempatando com a comparação dos segundos.

    public ParComparavel(S a, T b) {
        super(a, b);
    }

    @Override
    public int compareTo(ParComparavel<? extends S, ? extends T> p) {
        int compPrimeiro=p.getPrimeiro().compareTo(getPrimeiro());
        if(compPrimeiro==0){
            return p.getSegundo(getSegundo());
        }else{
            return compPrimeiro;
        }
    }
}
