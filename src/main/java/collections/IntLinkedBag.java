package collections;

import nodes.IntNode;

/**
 * 用链表实现包ADT
 * @author 术
 */
public class IntLinkedBag implements Cloneable{
    private IntNode head;
    private int manyNodes;

    public IntLinkedBag(){
        head = null;
        manyNodes = 0;
    }
    public void add(int element){
        head = new IntNode(element,head);
        manyNodes++;
    }
    public void addAll(IntLinkedBag addend){
        IntNode[] addNodes;
        if (addend == null){
            throw new IllegalArgumentException("addend is null");
        }
        if (addend.manyNodes > 0){
            addNodes = IntNode.listCopyWithTail(addend.head);
            addNodes[1].setLink(head);
            head = addNodes[0];
            manyNodes += addend.manyNodes;
        }
    }
    public void addMany(int... elements){
        for (int i : elements){
            add(i);
        }
    }
    @Override
    public IntLinkedBag clone(){
        IntLinkedBag answer;
        try {
            answer = (IntLinkedBag) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("This class does not implements Cloneable");
        }
        answer.head = IntNode.listCopy(head);
        return answer;
    }
    public int countOccurrences(int target){
        int count = 0;
        IntNode cursor;
        for (cursor = head;cursor != null;cursor = cursor.getLink()){
            if (cursor.getData() == target){
                count++;
            }
        }
        return count;
    }
    public int grab(){
        int i;
        IntNode cursor;

        if (manyNodes == 0){
            throw new IllegalStateException("Bag size is zero");
        }
        i =(int) (Math.random()* manyNodes)+1;
        cursor = IntNode.listPosition(head,i);
        return cursor.getData();
    }
    public boolean remove(int target){
        IntNode targetNode;
        targetNode = IntNode.listSearch(head,target);
        if (targetNode == null){
            return false;
        }else {
            targetNode.setData(head.getData());
            head = head.getLink();
            manyNodes--;
            return true;
        }
    }
    public int size(){
        return manyNodes;
    }
    public static IntLinkedBag union(IntLinkedBag b1,IntLinkedBag b2){
        if (b1 == null){
            throw new IllegalArgumentException("b1 is null");
        }
        if (b2 == null){
            throw new IllegalArgumentException("b2 is null");
        }
        IntLinkedBag answer = new IntLinkedBag();
        answer.addAll(b1);
        answer.addAll(b2);
        return answer;
    }
}
