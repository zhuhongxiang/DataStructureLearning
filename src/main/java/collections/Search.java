package collections;

public class Search {
    public static int search(int[] a, int first, int size, int target){
        int middle;
        if (size <= 0){
            return -1;
        }else {
            middle = first + size/2;
            if (target == a[middle]){
                return middle;
            }else if (target < a[middle]){
                return search(a,first,size/2,target);
            }else{
                return search(a,middle+1,(size-1)/2,target);
            }
        }
    }
    public static int orderSearch(int[] a, int first, int size, int target){
        int n = a.length;
        int i = 0;
        boolean found = false;
        if (first > n){
            throw new IllegalArgumentException("first is too big");
        }
        while (i < size && !found){
            if (target == a[first + i]){
                found = true;
            }else {
                i++;
            }
        }
        if (found){
            return first+i;
        }else {
            return -1;
        }
    }
    public static int comparableSearch(Comparable[] a, int first, int size, Comparable target){
        int middle;
        int comparison;

        if (size <= 0){
            return -1;
        }else {
            middle = first + size/2;
            comparison = target.compareTo(a[middle]);
            if (comparison == 0){
                return middle;
            }else if (comparison < 0){
                return comparableSearch(a,first,size/2,target);
            }else {
                return comparableSearch(a,middle+1,(size-1)/2,target);
            }
        }
    }
    public static int indexSearch(int[] a, int first,int last, int target){
        int middle;
        if (first >= last){
            return -1;
        }else {
            middle = first + (last - first)/2;
            if (target == a[middle]){
                return middle;
            }else if (target < a[middle]){
                return indexSearch(a, first, (last - first)/2,target);
            }else {
                return indexSearch(a, middle+1,(last - first -1)/2,target);
            }
        }
    }
}
