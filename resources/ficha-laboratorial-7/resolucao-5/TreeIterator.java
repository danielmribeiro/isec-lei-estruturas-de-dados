package ficha7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TreeIterator<T> implements Iterator {

    List<Node<T>> array = new ArrayList<Node<T>>();
    int lastPos = -1;

    public TreeIterator(BinaryTree bt) {
        AddToArray(bt.getRoot());
    }

    private void AddToArray(Node<T> subTRoot) {
        if (subTRoot == null) {
            return;
        }

        AddToArray(subTRoot.getLeft());
        array.add(subTRoot);
        AddToArray(subTRoot.getRight());
    }

    @Override
    public boolean hasNext() {
        return lastPos + 1 < array.size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return array.get(lastPos + 1);
    }

}