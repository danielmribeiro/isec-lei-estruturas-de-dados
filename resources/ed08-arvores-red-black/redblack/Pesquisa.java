package redblack;

public class Pesquisa {
    public AnyType find( AnyType x ) {
        nullNode.element = x;
        current = header.right; 
        for(;;){ 
            if( x.compareTo( current.element ) < 0 ) {
                current = current.left;
            }else if( x.compareTo( current.element ) > 0 ) {
                current = current.right;
            }else if( current != nullNode ){
                return current.element;
            } else{
                return null;
            }
        }
    }
    
    private final int compare( AnyType item, RedBlackNode<AnyType> t ) {
        if( t == header ){
            return 1;
        }else{
            return item.compareTo( t.element );
        } 
    }
    
    
}
