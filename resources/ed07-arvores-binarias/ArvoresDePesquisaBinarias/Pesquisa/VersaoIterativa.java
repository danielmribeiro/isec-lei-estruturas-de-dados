package Pesquisa;

public class VersaoIterativa {
    private AnyType elementAt(BinaryNode<AnyType> t){
        return t == null ? null : t.element;
    }
    
    private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t){
        while(t!=null){
            if(x.compareTo(t.element)<0){
                t=t.left;
            }else{
                if(x.compareTo(t.element)>0){
                    t=t.right;
                }else{
                    return t;
                    //  Encontrado
                    //  (Resultado menos provável testado em último lugar)
                }
            }
        }
        return null;
    }
}
