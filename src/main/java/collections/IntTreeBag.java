package collections;

import nodes.IntBTNode;

public class IntTreeBag implements Cloneable{
    private IntBTNode root;

    public IntTreeBag(){
        root = null;
    }
    public void add(int element){
        root = add1(root,element);
    }
    private IntBTNode add1(IntBTNode node, Integer e){
        if (node == null){
            node = new IntBTNode(e,null,null);
        }
        if (e.compareTo(node.getData()) < 0){
            node.setLeft(add1(node.getLeft(),e));
        }
        if (e.compareTo(node.getData()) > 0){
            node.setRight(add1(node.getRight(),e));
        }
        return node;
    }
    public void addMany(int... elements){
        for (int e : elements){
            add(e);
        }
    }
    public void addAll(IntTreeBag addend){
        IntBTNode addroot;
        if (root == addend.root){
            addroot = IntBTNode.treeCopy(addend.root);
            addTree(addroot);
        }else {
            addTree(addend.root);
        }
    }
    private void addTree(IntBTNode addroot){
        if (addroot != null){
            add(addroot.getData());
            addTree(addroot.getLeft());
            addTree(addroot.getRight());
        }
    }
    @Override
    public IntTreeBag clone(){
        IntTreeBag answer;
        try {
            answer = (IntTreeBag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implements Cloneable!");
        }
        answer.root = IntBTNode.treeCopy(root);
        return answer;
    }
    public int countOccurrences(int target){
        int count = 0;
        IntBTNode cursor = root;
        while (true){
            if (cursor == null){
                return count;
            }
            if (target < cursor.getData()){
                cursor = cursor.getLeft();
            }
            if (target > cursor.getData()){
                cursor = cursor.getRight();
            }
            if (target == cursor.getData()){
                count++;
                cursor = cursor.getLeft();
            }
        }
    }
    public int size(){
        return IntBTNode.treeSize(root);
    }
    public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2){
        IntTreeBag answer = new IntTreeBag();
        if (b1 == null || b2 == null){
            throw new IllegalArgumentException("b1 or b2 is null!");
        }
        answer.addTree(b1.root);
        answer.addTree(b2.root);
        return answer;
    }
    public boolean remove(int target){
        IntBTNode cursor = root;
        IntBTNode parentOfCursor = null;
        while (true){
            if (cursor == null){
                return false;
            }
            if (target  == root.getData() && root.getLeft()== null){
                root = cursor.getRight();
                return true;
            }
            if (target == cursor.getData() && cursor.getLeft() == null && parentOfCursor != null){
                if (cursor == parentOfCursor.getLeft()){
                    parentOfCursor.setLeft(cursor.getRight());
                }
                if (cursor == parentOfCursor.getRight()){
                    parentOfCursor.setRight(cursor.getRight());
                }
                return true;
            }
            if (target == cursor.getData() && cursor.getLeft() != null){
                cursor.setData(cursor.getLeft().getRightmostData());
                cursor.setLeft(cursor.getLeft().removeRightmost());
            }
            if (target < cursor.getData()){
                parentOfCursor = cursor;
                cursor = cursor.getLeft();
            }
            if (target > cursor.getData()){
                parentOfCursor = cursor;
                cursor = cursor.getRight();
            }
        }


    }
}
