package BasicLearning;

import nodes.BTNode;

import java.util.Scanner;

public class Animal {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        BTNode<String> root;
        instruct();
        root = beginningTree();
        do {
            play(root);
        }while (query("我们再来玩一次试试？"));
        System.out.println("谢谢你教会了我一些东西！");
    }

    public static void instruct(){
        System.out.println("让我们来玩一个猜动物的游戏吧~");
    }

    public static BTNode beginningTree(){
        BTNode root;
        BTNode child;
        final String ROOT_QUESTION = "你是一只哺乳动物吗？";
        final String LEFT_QUESTION = "你比一只猫大吗？";
        final String RIGHT_QUESTION = "你生活在水下吗？";
        final String ANIMAL1 = "袋鼠";
        final String ANIMAL2 = "老鼠";
        final String ANIMAL3 = "鲤鱼";
        final String ANIMAL4 = "黄鹂";

        root = new BTNode<String>(ROOT_QUESTION,null,null);
        child = new BTNode<String>(LEFT_QUESTION,null,null);
        child.setLeft(new BTNode<String>(ANIMAL1,null,null));
        child.setRight(new BTNode<String>(ANIMAL2,null,null));
        root.setLeft(child);

        child = new BTNode<String>(RIGHT_QUESTION,null,null);
        child.setLeft(new BTNode<String>(ANIMAL3,null,null));
        child.setRight(new BTNode<String>(ANIMAL4,null,null));
        root.setRight(child);

        return root;
    }

    public static boolean query(String prompt){
        String answer;
        System.out.println(prompt + "[Y or N]: ");
        answer = stdin.nextLine().toUpperCase();
        while (!answer.startsWith("Y") && !answer.startsWith("N")){
            System.out.println("无效回答，请回复Y或N");
            answer = stdin.nextLine().toUpperCase();
        }
        return answer.startsWith("Y");
    }

    public static void play(BTNode<String> current){
        while (!current.isLeaf()){
            if (query(current.getData())){
                current = current.getLeft();
            }else {
                current = current.getRight();
            }
        }
        System.out.println("我猜测是：" + current.getData());
        if (!query("我猜对了吗？")){
            learn(current);
        }else {
            System.out.println("我就知道我猜对了，嘿嘿~");
        }
    }
    public static void learn(BTNode<String> current){
        String guessAnimal = current.getData();
        String rightAnimal;
        String newQuestion;
        System.out.println("正确的动物是什么？");
        rightAnimal = stdin.nextLine();
        System.out.println("请提出一个用yes/no回答的区分这两个动物:"+rightAnimal+"和"+guessAnimal+"的问题！");
        newQuestion = stdin.nextLine();
        current.setData(newQuestion);
        System.out.println();
        if (query("对于"+rightAnimal+"，"+newQuestion)){
            current.setLeft(new BTNode<String>(rightAnimal,null,null));
            current.setRight(new BTNode<String>(guessAnimal,null,null));
        }else {
            current.setLeft(new BTNode<String>(guessAnimal,null,null));
            current.setRight(new BTNode<String>(rightAnimal,null,null));
        }
    }
}
