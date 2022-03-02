package collections;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Cloneable{
    private E[] data;
    private int manyItems;
    private int front;
    private int rear;

    public ArrayQueue() {
        final int INITIAL_CAPACTITY = 10;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACTITY];
    }

    public ArrayQueue(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException("initialCapacity < 0");
        }
        manyItems = 0;
        data = (E[]) new Object[initialCapacity];
    }

    public void add(E item){
        if (manyItems == data.length){

        }
        if (manyItems == 0){
            front = 0;
            rear = 0;
        }else {
            rear = nextIndex(rear);
        }
        data[rear] = item;
        manyItems++;
    }

    public boolean isEmpty(){
        return manyItems == 0;
    }

    public E remove(){
        if (isEmpty()){
            throw new NoSuchElementException("ArrayQueue is null");
        }
        E answer;
        answer = data[front];
        front = nextIndex(front);
        manyItems--;
        return answer;
    }

    public int size(){
        return manyItems;
    }

    private int nextIndex(int i){
        if (++i == data.length){
            return 0;
        }else {
            return i;
        }
    }
    @Override
    public ArrayQueue<E> clone(){
        ArrayQueue<E> answer;
        try {
            answer = (ArrayQueue<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class doesn't implement Cloneable");
        }
        answer.data = data.clone();
        return answer;
    }
    public int getCapacity(){
        return data.length;
    }
    public void ensureCapacity(int minimumCapacity){
        E[] biggerArray;
        int n1,n2;

        if (data.length > minimumCapacity){
            return;
        }else if (manyItems == 0){
            data = (E[]) new Object[minimumCapacity];
        }else if (front <= rear){
            biggerArray = (E[]) new Object[minimumCapacity];
            System.arraycopy(data,front,biggerArray,front,manyItems);
            data = biggerArray;
        }else {
            biggerArray = (E[]) new Object[minimumCapacity];
            n1 = data.length-front;
            n2 = rear+1;
            System.arraycopy(data,front,biggerArray,0,n1);
            System.arraycopy(data,0,biggerArray,n1,n2);
            front = 0;
            rear = manyItems-1;
            data = biggerArray;
        }
    }
    public void trimToSize(){
        if (manyItems == data.length){
            return;
        }else if (manyItems == 0){
            data = (E[]) new Object[manyItems];
        }else if (front < rear){
            E[] copyArray = (E[]) new Object[manyItems];
            System.arraycopy(data,front,copyArray,0,manyItems);
            front = 0 ;
            rear = manyItems-1;
            data = copyArray;
        }else {
            E[] copyArray = (E[]) new Object[manyItems];
            int n1 = data.length - front;
            int n2 = rear+1;
            System.arraycopy(data,front,copyArray,0,n1);
            System.arraycopy(data,0,copyArray,n1,n2);
            front = 0;
            rear = manyItems-1;
            data = copyArray;
        }
    }
}
