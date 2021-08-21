package Stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试栈的功能
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show:代表显示栈");
            System.out.println("exit:代表显退出菜单");
            System.out.println("push:代表入栈");
            System.out.println("pop:代表出栈");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数是%d \n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出~~~");


    }

    static class ArrayStack{
        private int maxSize;
        private int[] data;
        private int top = -1;

        public ArrayStack(int maxSize){
            this.maxSize = maxSize;
            this.data = new int[this.maxSize];
        }

        //栈满
        public boolean isFull(){
            return top == maxSize-1;
        }
        //栈空
        public boolean isEmpty(){
            return top == -1;
        }
        //入栈
        public void push(int value){
            if (isFull()){
                System.out.println("栈满，无法入栈！");
                return;
            }
            data[++top] = value;
        }
        //出栈
        public int pop(){
            if (isEmpty()){
                throw new EmptyStackException();
            }
            return data[top--];
        }
        //遍历
        public void show(){
            if (isEmpty()){
                System.out.println("栈空，没有数据~~");
                return;
            }
            for (int i = top;i>=0;i--){
                System.out.printf("Stack[%d] = %d \n",i,data[i]);
            }
        }
    }
}
