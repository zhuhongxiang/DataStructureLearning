package collections;

import nodes.Node;

import java.util.EmptyStackException;

public class linkedStack<E> implements Cloneable {
    private Node<E> top;

    public linkedStack(){
        top = null;
    }
    @Override
    public linkedStack<E> clone(){
        linkedStack<E> answer;
        try {
            answer = (linkedStack<E>) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("This class does not implements Cloneable");
        }
        answer.top = Node.listCopy(top);
        return answer;
    }
    public boolean isEmpty(){
        return (top == null);
    }
    public E peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.getData();
    }
    public E pop(){
        E answer;
        if (top == null){
            throw new EmptyStackException();
        }
        answer = top.getData();
        top = top.getLink();
        return answer;
    }
    public void push(E item){
        top = new Node<E>(item,top);
    }
    public int size(){
        return Node.listLength(top);
    }
}
