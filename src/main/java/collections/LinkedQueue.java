package collections;

import nodes.Node;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Cloneable{
    private int manyNodes;
    private Node<E> front;
    private Node<E> rear;

    public LinkedQueue(){
        front = null;
        rear = null;
    }
    public void add(E item){
        if (isEmpty()){
            front = new Node<E>(item,null);
            rear = front;
        }else {
            rear.addNodeAfter(item);
            rear = rear.getLink();
        }
        manyNodes++;
    }
    public boolean isEmpty(){
        return manyNodes == 0;
    }
    @Override
    public LinkedQueue<E> clone(){
        LinkedQueue<E> answer;
        try {
            answer = (LinkedQueue<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implements Cloneable");
        }
        Node[] cloneInfo;
        cloneInfo = Node.listCopyWithTail(front);
        answer.front = cloneInfo[0];
        answer.rear = cloneInfo[1];
        return answer;
    }
    public E remove(){
        E answer;
        if (manyNodes == 0){
            throw new NoSuchElementException("Queue underflow.");
        }
        answer = front.getData();
        front = front.getLink();
        manyNodes--;
        if (manyNodes == 0){
            rear = null;
        }
        return answer;
    }
    public int size(){
        return manyNodes;
    }
}
