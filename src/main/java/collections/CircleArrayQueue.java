package collections;

import java.util.NoSuchElementException;

public class CircleArrayQueue<E> {
    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * 指向第一个元素，初始值为0
     */
    private int front;
    /**
     * 指向最后一个元素的后一个位置
     */
    private int rear;
    private E[] arr;

    public CircleArrayQueue(int arrayMaxSize){
        maxSize = arrayMaxSize;
        arr = (E[]) new Object[maxSize];
    }

    public Boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public Boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(E item){
        if (isFull()){
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = item;
        rear = (rear+1) % maxSize;
    }

    public E getQueue(){
        if (isEmpty()){
            throw new NoSuchElementException("队列空，无法取数据");
        }
        // 先把front对应的值保留到一个临时变量answer
        // 再把front后移，再将answer返回
        E answer = arr[front];
        front = (front+1) % maxSize;
        return answer;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据~");
            return;
        }
        // 思路：从front开始遍历，遍历size()个元素
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size(){
        return (rear+maxSize-front) % maxSize;
    }

    public E headQueue(){
        if (isEmpty()){
            throw new NoSuchElementException("队列空，无法取数据");
        }
        return arr[front];
    }
}