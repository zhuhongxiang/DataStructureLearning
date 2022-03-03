package nodes;

public class IntBTNode {
    private int data;
    private IntBTNode left;
    private IntBTNode right;

    public IntBTNode(int initialData, IntBTNode initialLeft, IntBTNode initialRight){
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public int getData(){
        return data;
    }

    public IntBTNode  getLeft(){
        return left;
    }

    public IntBTNode  getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(IntBTNode  left) {
        this.left = left;
    }

    public void setRight(IntBTNode  right) {
        this.right = right;
    }

    public int getLeftmostData(){
        if (left == null){
            return data;
        }else {
            return left.getLeftmostData();
        }
    }

    public int getRightmostData(){
        if (right == null){
            return data;
        }else {
            return right.getRightmostData();
        }
    }

    public IntBTNode  removeLeftmost(){
        if (left == null){
            return null;
        }else {
            left = left.removeLeftmost();
            return this;
        }
    }

    public IntBTNode  removeRightmost(){
        if (right == null){
            return null;
        }else {
            right = right.removeRightmost();
            return this;
        }
    }

    public static  IntBTNode  treeCopy(IntBTNode  source){
        IntBTNode  copyLeft, copyRight;
        if (source == null){
            return null;
        }else {
            copyLeft = treeCopy(source.left);
            copyRight = treeCopy(source.right);
            return new IntBTNode (source.data, copyLeft,copyRight);
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

    public static   int treeSize(IntBTNode  root){
        if (root == null){
            return 0;
        }else {
            return 1 + treeSize(root.left) + treeSize(root.right);
        }
    }
}

