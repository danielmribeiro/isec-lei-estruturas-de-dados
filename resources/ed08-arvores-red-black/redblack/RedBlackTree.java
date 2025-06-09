package redblack;

public class RedBlackTree <AnyType extends Comparable<? super AnyType>>{ 
    public RedBlackTree() {} 
    public void insert(AnyType item) {} 
    public void remove(AnyType x) {} 
    public AnyType findMin()  {} 
    public AnyType findMax() {} 
    public AnyType find(AnyType x) {} 
    public void makeEmpty() { 
        header.right = nullNode;
    } 
    public boolean isEmpty(){
        return header.right == nullNode; 
    } 
    public void printTree() {
        printTree( header.right );
    } 
    private void printTree( RedBlackNode<AnyType> t ) {} 
    private final int compare( AnyType item, RedBlackNode<AnyType> t ) {}
    private void handleReorient( AnyType item ){} 
    private RedBlackNode<AnyType> rotate( AnyType item, RedBlackNode<AnyType> parent ) {}
    private static <AnyType>   RedBlackNode<AnyType> rotateWith_LeftChild(RedBlackNode<AnyType> k2 ) {} 
    private static <AnyType> RedBlackNode<AnyType> rotateWithRightChild( RedBlackNode<AnyType> kl ) {}
}

//Construção do NullNode
//nullNode = new RedBlackNode<AnyType>(null);
//nullNode.left = nullNode.right = nullNode;

//Construção do Header
//header = new RedBlackNode<AnyType>( null );
//header.left = header.right = nullNode;