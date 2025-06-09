package Pesquisa;

public class VersaoRecursiva {
    private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t){
        if(t!=null){
            if(x.compareTo(t.element)<0){
                return find(x,t.left);
            }else{
                if(x.compareTo(t.element)>0){
                    return find(x,t.right);
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
