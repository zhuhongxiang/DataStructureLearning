package BasicLearning;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class WordCounter {
    public static final Pattern UNSIGNED_DOUBLE =
            Pattern.compile("((\\d+\\.?+\\d*)|(\\.\\d+))([Ee][-+]?\\d)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");
    private static int getCount(String word, TreeMap<String,Integer>frequencyData){
        if (frequencyData.containsKey(word)){
            return frequencyData.get(word);
        }else {
            return 0;
        }
    }

    private static void printAllCounts(TreeMap<String,Integer> frequencyData){
        System.out.println("----------------------------------");
        System.out.println("    Occurrences    Word");

        for (String word:frequencyData.keySet()){
            System.out.printf("%15d    %s\n",frequencyData.get(word),word);
        }
        System.out.println("----------------------------------");
    }
    private static void readWordFile(TreeMap<String,Integer> frequencyData){
        Scanner wordFile;
        String word;
        Integer count;

        try {
            wordFile = new Scanner(new FileReader("src\\main\\java\\words.txt"));
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return;
        }
        while (wordFile.hasNext()){
            word = wordFile.next();
            count = getCount(word,frequencyData)+1;
            frequencyData.put(word,count);
        }
    }

    public static void main(String[] args) {
        TreeMap<String,Integer> frequencyData = new TreeMap<String,Integer>();
        readWordFile(frequencyData);
        printAllCounts(frequencyData);
    }

    public static boolean isBalanced(String expression){
        final char LEFT_NORMAL = '(';
        final char RIGHT_NORMAL = ')';
        final char LEFT_CURLY = '{';
        final char RIGHT_CURLY = '}';
        final char LEFT_SQUARE = '[';
        final char RIGHT_SQUARE = ']';

        Stack<Character> store = new Stack<Character>();
        // 字符串的索引
        int i;
        // 不匹配时为true
        boolean failed = false;
        for (i=0;!failed && i<expression.length();i++){
            switch (expression.charAt(i)){
                case LEFT_NORMAL:
                case LEFT_CURLY:
                case LEFT_SQUARE:
                    store.push(expression.charAt(i));
                    break;
                case RIGHT_NORMAL:
                    if (store.isEmpty()||(store.pop()!=LEFT_NORMAL)) {
                        failed = true;
                    }
                    break;
                case RIGHT_CURLY:
                    if (store.isEmpty()||(store.pop()!=LEFT_CURLY)) {
                        failed = true;
                    }
                    break;
                case RIGHT_SQUARE:
                    if (store.isEmpty()||(store.pop()!=LEFT_SQUARE)) {
                        failed = true;
                    }
                    break;
                default:
                    break;
            }
        }
        return (store.isEmpty()&&!failed);
    }
    public static double evaluate(String expression){
        Stack<Double> numbers = new Stack<Double>();
        Stack<Character> operations = new Stack<Character>();

        Scanner input = new Scanner(expression);
        String next;
        while (input.hasNext()){
            if (input.hasNext(UNSIGNED_DOUBLE)){
                next = input.findInLine(UNSIGNED_DOUBLE);
                numbers.push(new Double(next));
            }else {
                next = input.findInLine(CHARACTER);
                switch (next.charAt(0)){
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        operations.push(next.charAt(0));
                        break;
                    case ')':
                        evaluateStackTops(numbers,operations);
                        break;
                    case '(':
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal Character");
                }
            }
        }
        if (numbers.size()!=1){
            throw new IllegalArgumentException("Illegal input expression");
        }
        return numbers.pop();
    }
    public static void evaluateStackTops(Stack<Double> numbers,Stack<Character> operations){
        Double operand1, operand2;
        if ((numbers.size()<2)||(operations.isEmpty())){
            throw new IllegalArgumentException("Illegal expression");
        }
        operand2 = numbers.pop();
        operand1 = numbers.pop();
        switch (operations.pop()){
            case '+':
                numbers.push(operand1+operand2);
                break;
            case '-':
                numbers.push(operand1-operand2);
                break;
            case '*':
                numbers.push(operand1*operand2);
                break;
            case '/':
                numbers.push(operand1/operand2);
                break;
            default:
                throw new IllegalArgumentException("Illegal operation");
        }
    }
}
