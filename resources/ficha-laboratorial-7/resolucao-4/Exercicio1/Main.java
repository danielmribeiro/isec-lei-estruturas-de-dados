package Exercicio1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        arvoreBinaria.Insert(5);
        arvoreBinaria.Insert(3);
        arvoreBinaria.Insert(2);
        arvoreBinaria.Insert(4);
        arvoreBinaria.Insert(7);
        arvoreBinaria.Insert(6);


        System.out.println("Depth = " + arvoreBinaria.Depth());
        System.out.println("Depth of 7 = " + arvoreBinaria.DepthOf(7));
        System.out.println("Depth of 2 = " + arvoreBinaria.DepthOf(2));

        arvoreBinaria.Print();

        System.out.println("Size = " + arvoreBinaria.Size());

        arvoreBinaria.PrintLevels();
    }
}
