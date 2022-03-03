package collections;

public class Select {
    public static void selectionSort(int[] data, int first, int n){
        int i,j;
        int temp;
        int big;
        for (i = n-1; i>0; i--){
            big = first;
            for (j = first+1; j<=first+i;j++){
                if (data[j]>data[big]){
                    big = j;
                }
            }
            temp = data[first + i];
            data[first + i] = data[big];
            data[big] = temp;
        }
    }
    public static void insertSort(int[] data, int first, int n){
        int i,j;
        int entry;
        for (i = 1; i < n; i++){
            entry = data[first+i];
            for (j = first+i; j>first && data[j-1]>entry; j--){
                data[j] = data[j-1];
            }
            data[j] = entry;
        }
    }
    public static void selectionSort(String[] data, int first, int n){
        int i,j;
        String temp;
        int big;
        int comparison;
        for (i = n-1; i>0; i--){
            big = first;
            for (j = first+1; j<=first+i;j++){
                comparison = data[j].compareTo(data[big]);
                if (comparison > 0){
                    big = j;
                }
            }
            temp = data[first + i];
            data[first + i] = data[big];
            data[big] = temp;
        }
    }

    public static void main(String[] args) {
        final String BLANKS = "  ";
        int i;
        int[] data = {80, 10, 50, 90, 60, 70, 20, 30, 40, 0};
        String[] strings = {"f", "g", "a", "d", "c", "e", "h", "k", "j", "i"};

        //排序之前打印数组
        System.out.println("Here is the original array:");
        for (i = 0; i < data.length; i++){
            System.out.print(strings[i] + BLANKS);
        }
        System.out.println();
        //排序并打印结果
        selectionSort(strings,0, strings.length);
        System.out.println("Here is the sorted array:");
        for (i = 0; i < data.length; i++){
            System.out.print(strings[i] + BLANKS);
        }
        System.out.println();
    }
}
