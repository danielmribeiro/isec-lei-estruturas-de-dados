package Exercicios;

import java.util.Comparator;


public class Exercicios {
    public static void main(String[] args) {
        
        // ex1
        
        BinaryTree binTree = new BinaryTree(
                new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        binTree.Insert(5);
        binTree.Insert(3);
        binTree.Insert(2);
        binTree.Insert(4);
        binTree.Insert(7);
        binTree.Insert(6);
        
        
        System.out.println("Depth = " + binTree.Depth());
        System.out.println("Depth of 7 = " + binTree.DepthOf(7));
        System.out.println("Depth of 2 = " + binTree.DepthOf(2));
        
        binTree.Print();
        
        System.out.println("Size = " + binTree.Size());
        
        binTree.PrintLevels();
        
        /*-------------------------------------------------------*/
        
        // ex2
        
        BinaryTree<String> binTree2 = new BinaryTree<>();
        
        binTree2.Insert("D");
        binTree2.Insert("B");
        binTree2.Insert("E");
        binTree2.Insert("A");
        binTree2.Insert("C");
        binTree2.Insert("F");
        binTree2.Insert("H");
        binTree2.Insert("G");
        
        binTree2.PrintByLevel();
        
        System.out.println("Size = " + binTree2.Size());
        binTree2.Remove("B");
        System.out.println("Size = " + binTree2.Size());
        binTree2.PrintByLevel();
        
        /*-------------------------------------------------------*/
        
        // ex8
        BinaryTree<Integer> binTree3 = new BinaryTree<>();
        
        binTree3.Insert(5);
        binTree3.Insert(2);
        binTree3.Insert(10);
        binTree3.Insert(1);
        binTree3.Insert(4);
        binTree3.Insert(8);
        binTree3.Insert(11);
        binTree3.Insert(3);
        binTree3.Insert(7);
        binTree3.Insert(9);
        binTree3.Insert(12);
        
        binTree3.PrintByLevel();
        
        binTree3.RemoveLeafs();

        binTree3.PrintByLevel();

        /*-------------------------------------------------------*/
        
        // ex11
        BinaryTree<Integer> binTree4a = new BinaryTree<>();
        BinaryTree<Integer> binTree4b = new BinaryTree<>();

        binTree4a.Insert(5);        binTree4b.Insert(5);
        binTree4a.Insert(2);        binTree4b.Insert(2);
        binTree4a.Insert(10);       binTree4b.Insert(10);
        binTree4a.Insert(1);        binTree4b.Insert(1);
        binTree4a.Insert(4);        binTree4b.Insert(4);
        binTree4a.Insert(8);        binTree4b.Insert(8);
        binTree4a.Insert(11);       binTree4b.Insert(11);
        binTree4a.Insert(3);        binTree4b.Insert(3);
        binTree4a.Insert(7);        binTree4b.Insert(7);
        binTree4a.Insert(9);        binTree4b.Insert(9);
        binTree4a.Insert(12);       binTree4b.Insert(12);
        
        System.out.println(binTree4a.EqualTo(binTree4b));
        
        binTree4a.Remove(5);
        
        System.out.println(binTree4a.EqualTo(binTree4b));

        /*-------------------------------------------------------*/

        BinaryTree<Integer> binTree5 = new BinaryTree<>();
        
        binTree5.Insert(5);
        binTree5.Insert(2);
        binTree5.Insert(10);
        binTree5.Insert(1);
        binTree5.Insert(4);
        binTree5.Insert(8);
        binTree5.Insert(11);
        binTree5.Insert(3);
        binTree5.Insert(7);
        binTree5.Insert(9);
        binTree5.Insert(12);
        
        binTree5.PrintByLevel();
        
        binTree5.RotateWithRight();

        binTree5.PrintByLevel();
        
        binTree5.RotateWithLeft();

        binTree5.PrintByLevel();

        binTree5.PrintByLevel();
        
        binTree5.RemoveNodesWithoutLeft();

        binTree5.PrintByLevel();
    }
}
