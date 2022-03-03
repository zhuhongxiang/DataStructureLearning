package stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class LinkedStackDemo {
    public static void main(String[] args) {
        //测试栈的功能
        LinkedStack stack = new LinkedStack();
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

    static class LinkedStack {
        private IntNode head;
        private int count;

        public LinkedStack(){
            head = null;
        }

        //栈空
        public boolean isEmpty(){
            return head == null;
        }
        //入栈
        public void push(int value){
            count++;
            head = new IntNode(value,head);
        }
        //出栈
        public int pop(){
            if (isEmpty()){
                throw new EmptyStackException();
            }
            int value = head.getValue();
            head = head.getNext();
            count--;
            return value;
        }
        //遍历
        public void show(){
            if (isEmpty()){
                System.out.println("栈空，没有数据~~");
                return;
            }
            int num = count;
            IntNode cursor = head;
            while (cursor != null){
                System.out.printf("Stack[%d] = %d \n",num,cursor.getValue());
                num--;
                cursor = cursor.getNext();
            }
        }
    }
    static class IntNode{
        private int value;
        private IntNode next;

        public IntNode(int value,IntNode next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(IntNode next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public IntNode getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "IntNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
