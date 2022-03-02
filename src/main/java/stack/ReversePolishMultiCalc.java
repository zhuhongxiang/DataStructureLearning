package stack;

import java.util.*;
import java.util.regex.Pattern;

public class ReversePolishMultiCalc {
    /**
     * 匹配 + - * / ( ) 运算符
     */
    static final String SYMBOL = "\\+|\\-|\\*|\\/|\\(|\\)";
    static final String LEFT = "(";
    static final String RIGHT = ")";
    static final String ADD = "+";
    static final String MINUS = "-";
    static final String TIMES = "*";
    static final String DIVISION = "/";
    static final Pattern PATTERN = Pattern.compile("^[-\\+]?[.\\d]*$");

    /**
     * 加减优先级
     */
    static final int LEVEL_01 = 1;

    /**
     * 乘除优先级
     */
    static final int LEVEL_02 = 2;

    /**
     * 最大值
     */
    static final int LEVEL_MAX = Integer.MAX_VALUE;

    static Stack<String> stack = new Stack<>();
    static List<String>  data = Collections.synchronizedList(new ArrayList<>());

    /**
     * 去除所有空白字符
     * @param s
     * @return
     */
    public static String replaceAllBlank(String s){
        // \\s+ 匹配任何空白字符，包括空格、制表符、换页符等，等价于[ \f\n\r\t\v ]
        return s.replaceAll("\\s+","");
    }

    /**
     * 判断是不是数字int double long float
     * @param s
     * @return
     */
    public static boolean isNumber(String s){

        return PATTERN.matcher(s).matches();
    }

    /**
     * 判断是不是运算符
     * @param s
     * @return
     */
    public static boolean isSymbol(String s){
        return s.matches(SYMBOL);
    }

    /**
     * 匹配运算等级
     * @param s
     * @return
     */
    public static int calcLevel(String s){
        if ("+".equals(s) || "-".equals(s)){
            return LEVEL_01;
        }else if ("*".equals(s) || "/".equals(s)){
            return LEVEL_02;
        }
        return LEVEL_MAX;
    }

    public static List<String> doMatch(String s) throws Exception{
        if (s == null || "".equals(s.trim())){
            throw new RuntimeException("data is empty");
        }
        if (!isNumber(s.charAt(0)+"")){
            throw new RuntimeException("data illegal,start not with a number");
        }

        s = replaceAllBlank(s);

        String each;
        int start = 0;

        for (int i = 0;i < s.length();i++){
            if (isSymbol(s.charAt(i)+"")){
                each = s.charAt(i)+"";
                if (stack.isEmpty() || LEFT.equals(each)
                        || ((calcLevel(each)>calcLevel(stack.peek())&&(calcLevel(each)<LEVEL_MAX)))){
                    stack.push(each);
                }else if (!stack.isEmpty() && calcLevel(each)<calcLevel(stack.peek())){
                    while (!stack.isEmpty() && calcLevel(each)<calcLevel(stack.peek())){
                        if (calcLevel(stack.peek()) == LEVEL_MAX){
                            break;
                        }
                        data.add(stack.pop());
                    }
                    stack.push(each);
                }else if (RIGHT.equals(each)){
                    while (!stack.isEmpty()){
                        if (LEVEL_MAX == calcLevel(stack.peek())){
                            stack.pop();
                            break;
                        }
                        data.add(stack.pop());
                    }

                }
                // 前一个运算符位置
                start = i;
            }else if (i == s.length()-1 || isSymbol(s.charAt(i+1)+"")){
                each = start == 0?s.substring(start,i+1):s.substring(start+1,i+1);
                if (isNumber(each)){
                    data.add(each);
                    continue;
                }
                throw new RuntimeException("data not match number");
            }
        }
        // 如果栈中还有元素，元素需要依次出栈入列
        Collections.reverse(stack);
        data.addAll(new ArrayList<>(stack));

        System.out.println("data = "+data);
        return data;
    }

    /**
     * 运算
     * @param s1
     * @param s2
     * @param symbol
     * @return
     */
    public static Double doTheMath(String s1,String s2,String symbol){
        Double result;
        switch (symbol){
            case ADD:
                result = Double.parseDouble(s1) + Double.parseDouble(s2);
                break;
            case MINUS:
                result = Double.parseDouble(s1) - Double.parseDouble(s2);
                break;
            case TIMES:
                result = Double.parseDouble(s1) * Double.parseDouble(s2);
                break;
            case DIVISION:
                result = Double.parseDouble(s1) / Double.parseDouble(s2);
                break;
            default:
                result = null;
                break;
        }
        return result;
    }
    public static Double doCalc(List<String> list){
        Double d = 0d;
        if (list == null || list.isEmpty()){
            return null;
        }
        if (list.size()==1){
            System.out.println(list);
            d = Double.parseDouble(list.get(0));
            return d;
        }
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0;i < list.size();i++){
            list1.add(list.get(i));
            if (isSymbol(list.get(i))){
                Double d1 = doTheMath(list.get(i - 2),list.get(i - 1),list.get(i));
                list1.remove(i);
                list1.remove(i-1);
                list1.set(i-2,d1+"");
                list1.addAll(list.subList(i+1,list.size()));
                break;
            }
        }
        doCalc(list1);
        return d;
    }

    public static void main(String[] args) {
        String math = "12.8 + (2 - 3.55)*4+10/5.0";
        try {
            doCalc(doMatch(math));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
