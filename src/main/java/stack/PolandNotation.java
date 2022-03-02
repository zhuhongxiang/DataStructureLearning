package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //完成将一个中缀表达式转换成后缀表达式的功能
        // 1. 1+((2+3)*4)-5 =>1 2 3 + 4 * + 5 -
        // 2. 因为直接对string操作不方便，因此先将"1+((2+3)*4)-5"=>中缀表达式对应的List
        // 3. 将得到的中缀表达式对应的List =>后缀表达式对应的List

        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println("前缀表达式list="+list);
        List<String> suffixExpressionList  = parseSuffixExpressionList(list);
        System.out.println("后缀表达式list="+suffixExpressionList);

        System.out.printf("expression=%d",calculate(suffixExpressionList));



        // 先定义逆波兰表达式
        // (3+4)*5-6 => 3 4 + 5 * 6 - =>29
        // 4 * 5 -8 + 60 + 8 /2 => 4 5 * 8 - 60 + 8 2 / + => 76
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //思路
        //1. 先将"3 4 + 5 * 6 - "=>放到ArrayList中
        //2. 将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算

//        List<String> respList = getListString(suffixExpression);
//        System.out.println("respList="+respList);
//
//        int res = calculate(respList);
//        System.out.println("计算的结果是"+res);
    }

    /**
     * 将得到的中缀表达式对应的List =>后缀表达式对应的List
     * @param list 中缀表达式对应的List
     * @return 后缀表达式对应的List
     */
    public static List<String> parseSuffixExpressionList(List<String> list){
        // 定义两个栈
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        //遍历list
        for (String item: list){
            // 如果是一个数就加入到s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if ("(".equals(item)){
                s1.push(item);
            }else if (")".equals(item)){
                while (!"(".equals(s1.peek())){
                    s2.add(s1.pop());
                }
                // 将(弹出s1栈
                s1.pop();
            }else {
                //当item的优先级小于等于s1的栈顶的运算符，将s1栈顶的运算符加入到s2中，循环
                //缺少比较优先级高低的方法
                while (s1.size()!=0 && Operation.getValue(s1.peek())>Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出加入到s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    /**
     * 将一个中缀表达式，依次将数据和运算符放到ArrayList中
     * @param s 一个中缀表达式
     * @return ArrayList
     */
    public static  List<String> toInfixExpressionList(String s){
        List<String> list = new ArrayList<String>();
        // 指针，遍历扫描s
        int i = 0;
        // 多位数的拼接
        String str;
        //每遍历到一个字符就放入到c
        char c;
        do {
            // 如果c是一个非数字。就加入到list
            if ((c=s.charAt(i)) < 48 || ((c=s.charAt(i)) > 57)){
                list.add(""+c);
                i++;
            }else {
                // 如果是一个数，需要考虑多位数
                str = "";
                while (i < s.length()&&(c=s.charAt(i)) >= 48 && ((c=s.charAt(i)) <= 57)){
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());
        return list;
    }

    /**
     * 将一个逆波兰表达式，依次将数据和运算符放到ArrayList中
     * @param suffixExpression 一个逆波兰表达式
     * @return ArrayList
     */
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele: split){
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     * @param list
     * @return
     */
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<String>();
        // 遍历list
        for (String item: list){
            if (item.matches("\\d+")){
                //入栈
                stack.push(item);
            }else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)){
                    res = num1 + num2;
                }else if ("-".equals(item)){
                    res = num1 - num2;
                }else if ("*".equals(item)){
                    res = num1 * num2;
                }else if ("/".equals(item)){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有错");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

// 编写一个类Operation 可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
