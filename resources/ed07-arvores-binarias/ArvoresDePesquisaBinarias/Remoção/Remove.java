package Remoção;

public class Remove {
    protected BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ) {
        if( t == null ){
            throw new ItemNotFoundException( x.toString( ) );
        }
        if( x.compareTo( t.element ) < 0 ){
            t.left = remove( x, t.left );
        } else if( x.compareTo( t.element ) > 0 ){
            t.right = remove( x, t.right );
        } else if( t.left != null && t.right != null ){ // Dois descendentes
            t.element = findMin( t.right ).element;
            t.right = removeMin( t.right 
        } else{
            t = ( t.left != null ) ? t.left : t.right; // Um só descendente
        } 
        return t; 
    } 
}
