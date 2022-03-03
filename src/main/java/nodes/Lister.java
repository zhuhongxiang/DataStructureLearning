package nodes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lister<E> implements Iterator {
    private Node<E> current;

    public Lister(Node<E> head){
        current = head;
    }

    @Override
    public boolean hasNext() {
        return (current !=null);
    }

    @Override
    public E next() {
        E answer;
        if (!hasNext()){
            throw new NoSuchElementException("The Lister is empty");
        }
        answer = current.getData();
        current = current.getLink();
        return answer;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Lister has no remove method");
    }
}
