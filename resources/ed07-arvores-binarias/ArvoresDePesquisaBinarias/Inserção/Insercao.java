package Inserção;

public class Insercao {
    protected BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ) {
        if( t == null ){
            t = new BinaryNode<AnyType>( x );
        }else{
            if( x.compareTo( t.element ) < 0 ){
                t.left = insert( x, t.left );
            } else if( x.compareTo( t.element ) > 0 ){
                t.right = insert( x, t.right );
            } else{
                throw new DuplicateItemException( x.toString( ) );
            // Duplicado    
            }
        }
        return t; //nova raiz desta sub-árvore }
}
