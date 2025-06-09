package redblack;

public class inserir {
    public void insert( AnyType item ) {
        current = parent = grand = header;
        nullNode.element = item;
        while( compare( item, current ) != 0 ) {
            great = grand;
            grand = parent; 
            parent = current; 
            current = compare( item, current ) < 0 ?  current.left : current.right;
            // Verifica se dois descendentes são vermelhos; ajusta árvore se isso se verificar 
            if( current.left.color == RED && current.right.color == RED ){
                handleReorient( item );
            } 
        }
        // Inserção falha se valor já existe
        if( current != nullNode ){
            throw new DuplicateItemException( item.toString( ) );
        } 
        current = new RedBlackNode<AnyType>( item, nullNode, nullNode );
        // liga a ascendente 
        if( compare( item, parent ) < 0 ){
            parent.left = current;
        } else {
            parent, right = current;
        }
        handleReorient( item );
    }
    
    private void handleReorient( AnyType item ) {
        // Inverte cores
        current.color = RED; 
        current.left.color = BLACK; 
        current.right.color = BLACK; 
        if( parent.color == RED ){ // é necessário rodar 
            grand.color = RED; 
            if( ( compare( item, grand ) < 0 ) != ( compare( item, parent ) < 0 ) ){
                parent = rotate( item, grand ); // inicia dupla rotação
            }
            current = rotate( item, great );
            current.color = BLACK;
        } 
        header.right.color = BLACK; // torna raiz preta 
    }
    
    private RedBlackNode<AnyType> rotate( AnyType item, RedBlackNode<AnyType> parent ) {
        if( compare( item, parent ) < 0 ){
            return parent.left = compare( item, parent.left )<0 ? 
            rotateWithLeftChild( parent.left ) : // LL
            rotateWithRightChild( parent.left ) ; // LR
        }else{
            return parent.right = compare( item, parent.right )< 0 ?
            rotateWithLeftChild( parent.right ) : // RL 
            rotateWithRightChild( parent.right ); // RR 
        }
    }
    
    RedBlackNode<AnyType> rotateWithlLeftChild( RedBlackNode<AnyType> a) {
        RedBlackNode<AnyType> b=a.left;
        RedBlackNode<AnyType> s2=b.right;
        b.right=a;
        a.left=s2;
        return b;
    }
}
