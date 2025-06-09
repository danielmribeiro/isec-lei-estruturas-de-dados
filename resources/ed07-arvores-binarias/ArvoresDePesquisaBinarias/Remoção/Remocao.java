package Remoção;

public class Remocao {
    public void removeMin() {
        root=removeMin(root);
    }
    
    private BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t ) {
        if( t == null ){
            throw new ItemNotFoundException();
        }else if( t.left != null ){ 
            t.left = removeMin( t.left );
            return t;
        }else{
            return t.right;
        }
    }
}
