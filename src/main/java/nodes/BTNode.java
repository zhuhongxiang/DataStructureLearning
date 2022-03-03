package nodes;

public class BTNode<E> {
    private E data;
    private BTNode<E> left;
    private BTNode<E> right;

    public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight){
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public E getData(){
        return data;
    }

    public BTNode<E> getLeft(){
        return left;
    }

    public BTNode<E> getRight() {
        return right;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(BTNode<E> left) {
        this.left = left;
    }

    public void setRight(BTNode<E> right) {
        this.right = right;
    }

    public E getLeftmostData(){
        if (left == null){
            return data;
        }else {
            return left.getLeftmostData();
        }
    }

    public E getRightmostData(){
        if (right == null){
            return data;
        }else {
            return right.getRightmostData();
        }
    }

    public BTNode<E> removeLeftmost(){
        if (left == null){
            return null;
        }else {
            left = left.removeLeftmost();
            return this;
        }
    }

    public BTNode<E> removeRightmost(){
        if (right == null){
            return null;
        }else {
            right = right.removeRightmost();
            return this;
        }
    }

    public static<E> BTNode<E> treeCopy(BTNode<E> source){
        BTNode<E> copyLeft, copyRight;
        if (source == null){
            return null;
        }else {
            copyLeft = treeCopy(source.left);
            copyRight = treeCopy(source.right);
            return new BTNode<E>(source.data, copyLeft,copyRight);
        }
    }

    public boolean isLeaf(){
        return (left == null) && (right == null);
    }

    public void preorderPrint(){
        System.out.println(data);
        if (left != null){
            left.preorderPrint();
        }
        if (right != null){
            right.preorderPrint();
        }
    }

    public void inorderPrint(){
        if (left != null){
            left.inorderPrint();
        }
        System.out.println(data);
        if (right != null){
            right.inorderPrint();
        }
    }

    public void postorderPrint(){
        if (left != null){
            left.inorderPrint();
        }
        if (right != null){
            right.inorderPrint();
        }
        System.out.println(data);
    }

    public void print(int depth){
        int i;
        for (i = 1;i <= depth;i++){
            System.out.println("    ");
        }
        System.out.println(data);

        if (left != null){
            left.print(depth+1);
        }else if (right != null){
            for (i = 1; i <= depth+1; i++){
                System.out.println("    ");
            }
            System.out.println("--");
        }

        if (right != null){
            right.print(depth+1);
        }else if (left != null){
            for (i = 1; i <= depth+1; i++){
                System.out.println("    ");
            }
            System.out.println("--");
        }
    }

    public static <E> int treeSize(BTNode<E> root){
        if (root == null){
            return 0;
        }else {
            return 1 + treeSize(root.left) + treeSize(root.right);
        }
    }
}

