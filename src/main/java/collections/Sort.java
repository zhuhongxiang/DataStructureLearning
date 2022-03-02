package collections;

public class Sort {
    public static void mergeSort(int[] data, int first, int n){
        int n1;
        int n2;
        if (n > 1){
            n1 = n / 2;
            n2 = n - n1;

            mergeSort(data,first,n1);
            mergeSort(data,first+n1,n2);
            merge(data,first,n1,n2);
        }
    }
    private static void merge(int[] data, int first, int n1, int n2){
        int[] temp = new int[n1+n2];
        int copied = 0;
        int copied1 = 0;
        int copied2 = 0;
        int i;
        while (copied1 < n1 && copied2 < n2){
            if (data[first + copied1] < data[first+n1+copied2]){
                temp[copied++] = data[first + (copied1++)];
            }else {
                temp[copied++] = data[first+n1 + (copied2++)];
            }
        }
        while (copied1 < n1){
            temp[copied++] = data[first + (copied1++)];
        }
        while (copied2 < n2){
            temp[copied++] = data[first+n1 + (copied2++)];
        }
        for (i = 0;i < n1+n2;i++){
            data[first+i] = temp[i];
        }
    }
    public static void quickSort(int[] data, int first, int n){
        int pivotIndex;
        int n1;
        int n2;

        if (n > 1){
            pivotIndex = partition(data, first, n);

            n1 = pivotIndex - first;
            n2 = n - n1 -1;
            quickSort(data,first,n1);
            quickSort(data,pivotIndex+1, n2);
        }
    }

    private static  int partition(int[] data, int first, int n){
        int pivot;
        int tooBigIndex;
        int tooSmallIndex;
        pivot = data[first];
        tooBigIndex = first+1;
        tooSmallIndex = first+n-1;
        while (tooBigIndex <= tooSmallIndex){
            if (tooBigIndex < first+n-1 && data[tooBigIndex] <= pivot){
                tooBigIndex++;
            }else if (data[tooSmallIndex] > pivot){
                tooSmallIndex--;
            }else if (tooBigIndex < tooSmallIndex){
                int temp = data[tooBigIndex];
                data[tooBigIndex] = data[tooSmallIndex];
                data[tooSmallIndex] = temp;
            }else {
                break;
            }

        }
        data[first] = data[tooSmallIndex];
        data[tooSmallIndex] = pivot;
        return tooSmallIndex;
    }
    public static void heapSort(int[] data, int n){
        int unsorted;
        int temp;

        makeHeap(data, n);

        unsorted = n;

        while (unsorted > 1){
            unsorted--;

            temp = data[0];
            data[0] = data[unsorted];
            data[unsorted] = temp;

            reheapifyDown(data, unsorted);
        }
    }
    private static void makeHeap(int[] data,int n){
        int i;
        int k;
        for (i = 1;i<n;i++){
            //新元素下标
            k = i;
            while (k>0 && data[k] > data[parent(k)]){
                int temp = data[k];
                data[k] = data[parent(k)];
                data[parent(k)] = temp;
                k = parent(k);
            }
        }
    }
    private static int parent(int k){
        return (k-1)/2;
    }
    private static void reheapifyDown(int[] data, int n){
        int current;
        int bigChildIndex = 0;
        boolean heapOkay;

        current = 0;
        heapOkay = false;
        while ((!heapOkay) && (2*current+1 <= n-1)){
            if (2*current+2 <= n-1){
                int child1 = data[2*current+1];
                int child2 = data[2*current+2];
                if (child1 >= child2){
                    bigChildIndex = 2*current+1;
                }else {
                    bigChildIndex = 2*current+2;
                }
            }else{
                bigChildIndex = 2*current+1;
            }
            if (data[current] < data[bigChildIndex]){
                int temp = data[current];
                data[current] = data[bigChildIndex];
                data[bigChildIndex] = temp;
                current = bigChildIndex;
            }else {
                heapOkay = true;
            }
        }
    }
    public static void main(String[] args) {
        final String BLANKS = "  ";
        int i;
        int[] data = {80, 10, 50, 90, 60, 70, 20, 30, 40, 0};
        int[] data2 = {21, 35, 22, 27, 23, 45, 42, 19, 4, 5};

        //排序之前打印数组
        System.out.println("Here is the original array:");
        for (i = 0; i < data2.length; i++){
            System.out.print(data2[i] + BLANKS);
        }
        System.out.println();
        //排序并打印结果
        heapSort(data2, data2.length);
        System.out.println("Here is the sorted array:");
        for (i = 0; i < data2.length; i++){
            System.out.print(data2[i] + BLANKS);
        }
        System.out.println();
    }

}
