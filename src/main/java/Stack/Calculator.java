package Stack;

import java.util.EmptyStackException;

public class Calculator {
    public static void main(String[] args) {
        // 根据思路，完成表达式的运算
        String expression = "70+20*6-4";
        // 创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepNum = "";
        //将每次扫描得到的char保存到ch中
        char ch = ' ';
        // 开始while循环扫描expression
        while (true){
            // 依次得到expression每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)){
                // 判断当前的符号栈是否为空
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }

                }else {
                    // 如果为空直接入栈
                    operStack.push(ch);
                }
            }else {
                // numStack.push(ch - 48);
                // 思路分析：
                // 1.当处理多位数时，不能发现一个数就立马入栈
                // 2.在处理书，需要向expression的表达式的index 后再看一位，如果是数就继续扫描，如果是符号才入栈
                // 3.因此我们需要定义一个变量字符串用于拼接

                // 处理多位数
                keepNum += ch;
                // 如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    // 判断下一个字符是不是数字，如果是数字就继续扫描，如果是运算符则入栈
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        // keepNum清空
                        keepNum = "";
                    }
                }

            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        while (true){
            // 如果符号栈为空，则计算结束，数栈中只有一个数字【结果】
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s = %d",expression,numStack.pop());

    }

    // 先创建一个栈
    static class ArrayStack2{
        private int maxSize;
        private int[] data;
        private int top = -1;

        public ArrayStack2(int maxSize){
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
        public int peek(){
            if (isEmpty()){
                throw new EmptyStackException();
            }
            return data[top];
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
        // 返回运算符的优先级，优先级是程序员来确定，优先级用数字表示
        // 数字越大，优先级越高
        public int priority(int oper){
            // 假定目前的运算符只有+，-，*，/
            if (oper == '*' || oper == '/'){
                return 1;
            }else if (oper == '+'|| oper == '-'){
                return 0;
            }else {
                return -1;
            }
        }
        // 判断是不是一个运算符
        public boolean isOper(char val){
            return val == '+' || val == '-' || val == '*' || val == '/';
        }
        public int cal(int num1,int num2,int oper){
            int res = 0;
            switch (oper){
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
                default:
                    break;
            }
            return res;
        }
    }
}

