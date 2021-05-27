package collections;

import nodes.DoubleNode;

/**
 * 使用链表实现序列ADT
 * @author 术
 */
public class DoubleLinkedSeq implements Cloneable {
    private int manyNodes;
    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode cursor;
    private DoubleNode preCursor;

    /**
     * 初始化生成空序列
     */
    public DoubleLinkedSeq(){
        manyNodes = 0;
        head = null;
        tail = null;
        cursor = null;
        preCursor = null;
    }
    public void addAfter(double element){
        if (manyNodes == 0){
            head = new DoubleNode(element,null);
            tail = head;
            cursor = head;
        }else if (cursor == null){
            tail.addNodeAfter(element);
            tail = tail.getLink();
        }else if (cursor == tail){
            cursor.addNodeAfter(element);
            tail = cursor.getLink();
        }else {
            cursor.addNodeAfter(element);
        }
        manyNodes ++;
    }
    public void addBefore(double element){
        if (manyNodes == 0){
            head = new DoubleNode(element,null);
            tail = head;
            cursor = head;
        }else if (cursor == null){
            head = new DoubleNode(element,head);
        }else if(cursor == head){
            head = new DoubleNode(element,head);
            preCursor = head;
        }else {
            preCursor.addNodeAfter(element);
            preCursor = preCursor.getLink();
        }
        manyNodes++;
    }
    public void addAll(DoubleLinkedSeq addend){
        DoubleNode[] addNodes;
        if (addend == null){
            throw new IllegalArgumentException("addend is null");
        }
        if (addend.manyNodes > 0){
            addNodes = DoubleNode.listCopyWithTail(addend.head);
            tail.setLink(addNodes[0]);
            tail = addNodes[1];
            manyNodes += addend.manyNodes;
        }
    }
    public void advance(){
        if (!isCurrent()){
            throw new IllegalStateException("no currentIndex");
        }
        else if (cursor == head){
            cursor = cursor.getLink();
            preCursor = head;
        }
        else if (cursor == tail){
            cursor = null;
            preCursor = null;
        }else {
            cursor = cursor.getLink();
            preCursor = preCursor.getLink();
        }
    }
    @Override
    public DoubleLinkedSeq clone(){
        DoubleLinkedSeq answer;
        DoubleNode[] copyList;
        try {
            answer = (DoubleLinkedSeq) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("This class does not implements Cloneable");
        }
        if (!isCurrent()){
            copyList = DoubleNode.listCopyWithTail(head);
            answer.head = copyList[0];
            answer.tail = copyList[1];
            answer.cursor = null;
            answer.preCursor = null;
        }else if(cursor == head){
            copyList = DoubleNode.listCopyWithTail(head);
            answer.head = copyList[0];
            answer.tail = copyList[1];
            answer.cursor = copyList[0];
            answer.preCursor = null;
        }else{
            DoubleNode[] copyList1 = DoubleNode.listPart(head,preCursor);
            DoubleNode[] copyList2 = DoubleNode.listPart(cursor,tail);
            answer.head = copyList1[0];
            answer.tail = copyList2[1];
            answer.cursor = copyList2[0];
            answer.preCursor = copyList1[1];
            answer.preCursor.setLink(answer.cursor);
        }
        return answer;
    }
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq b1, DoubleLinkedSeq b2){
        DoubleLinkedSeq answer;
        if (b1 == null){
            throw new IllegalArgumentException("b1 is null");
        }
        if (b2 == null){
            throw new IllegalArgumentException("b2 is null");
        }
        answer = new DoubleLinkedSeq();
        answer.addAll(b1);
        answer.addAll(b2);
        return answer;
    }
    public double getCurrent(){
        if (isCurrent()){
            return cursor.getData();
        }else {
            throw new IllegalArgumentException ("Do not exist current element");
        }
    }
    public boolean isCurrent(){
        if (cursor != null){
            return true;
        }else {
            return false;
        }
    }
    public void removeCurrent(){
        if (isCurrent()){
            if (cursor == tail){
                cursor = null;
                tail = preCursor;
                preCursor = null;
            }else if (cursor == head){
                cursor = cursor.getLink();
                head = cursor;
            }else {
                cursor = cursor.getLink();
                preCursor.setLink(cursor);
            }
        }else {
            throw new IllegalArgumentException ("Do not exist current element");
        }
    }
    public int size(){
        return manyNodes;
    }
    public void start(){
        cursor = head;
        preCursor = null;
    }
}
