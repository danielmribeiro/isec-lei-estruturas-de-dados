package redblack;
public class RedBlack {

    private static class RedBlackNode<AnyType> {
    // Construtores 
        RedBlackNode( AnyType theElement ) {
            this( theElement, null, null );
        } 
        RedBlackNode( AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt ) {
            element = theElement;
            left = lt;
            right = rt;
            color = RedBlackTree.BLACK;
        }
        AnyType element; 
        RedBlackNode<AnyType> left; 
        RedBlackNode<AnyType> right; 
        int color;
    }
    
}
