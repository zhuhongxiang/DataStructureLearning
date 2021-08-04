package BasicLearning;

import collections.ArrayBag;

import java.util.Scanner;

public class Author {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        final int WORDS_PER_BAG = 4;
        final int MANY_SENTENCES = 3;

        ArrayBag<String> good = new ArrayBag<String>(WORDS_PER_BAG);
        ArrayBag<String> bad = new ArrayBag<String>(WORDS_PER_BAG);
        ArrayBag<String> names = new ArrayBag<String>(WORDS_PER_BAG);
        int line;

        //用程序用户输入的单词填充三个包
        System.out.println("Help me write the story.\n");
        getWords(good, WORDS_PER_BAG, "adjectives that describle a good mood");
        getWords(bad, WORDS_PER_BAG, "adjectives that describle a bad mood");
        getWords(names, WORDS_PER_BAG, "names first");
        System.out.println("Thank you for kind assistance.\n");

        //使用数据项编写小故事
        System.out.println("LIFE");
        System.out.println("by ZHX.\n");
        for (line = 1;line <= MANY_SENTENCES;line++){
            System.out.print((String) names.grab());
            System.out.print("was feeling");
            System.out.print((String) bad.grab());
            System.out.print(", yet he/she was also ");
            System.out.print((String) good.grab());
            System.out.print(".");
        }
        System.out.println("Life is " + (String) bad.grab() + ".\n");
        System.out.println("The " + (String) good.grab() + " end.");
    }
    public static void getWords(ArrayBag<String> b,int n,String prompt){
        String userInput;
        int i;

        System.out.print("Please type"+ n +" " + prompt);
        System.out.println(", separated by spaces.");
        System.out.println("Press the <return> key after the final entry: ");
        for (i = 0;i <= n;i++){
            userInput = stdin.next();
            b.add(userInput);
        }
        System.out.println();
    }
}
