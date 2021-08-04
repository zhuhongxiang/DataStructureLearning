package BasicLearning;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
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
}
