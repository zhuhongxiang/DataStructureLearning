package BasicLearning;

import java.util.Scanner;

/**
 * @author 术
 */
public class MaxOfArray {
    public static void main(String[] args) {
        final int MAX_LENGTH = 5;
        int[] num=new int[MAX_LENGTH];
        System.out.println("请输入5个整数：");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MAX_LENGTH;i++) {
            num[i]=sc.nextInt();
        }
        int maxNum = maxOfArray(num);
        System.out.println("数组中的最大值为："+maxNum);
    }


    /**
     * return max num of Array
     * @param a
     *  int[ ]]
     * @precondition
     *  a.length>0
     * @return
     *  max num of a
     * @throws ArrayIndexOutOfBoundsException
     *  indicates the length of a is 0
     */
    public static int maxOfArray(int[] a){
        int answer;
        int i;

        //将answer初始化为a[0]
        answer = a[0];
        for (i = 0; i < a.length; i++) {
            if (a[i]>answer){
                answer = a[i];
            }
        }

        assert contains(a,answer) : "maxOfArray answer is noy equal in the array";
        assert greaterOrEqual(a,answer) : "maxOfArray answer is less than an array element";

        return answer;
    }

    /**
     * 检查返回的值是不是和数组中的某个值相等
     * @param a
     * @param value
     * @return
     * 如果找到了与a的某个值相等，则返回true，否则返回false
     */
    static boolean contains(int[] a, int value){
        int i;
        for (i =0; i < a.length;i++){
            if (a[i]==value){
                return true;
            }
        }
        return false;
    }

    /**
     * 检查返回值是否大于等于数组中的每个元素
     * @param a
     * @param value
     * @return
     * 返回值大于等于数组中的每个元素返回true，否则返回false
     */
    static boolean greaterOrEqual(int[] a , int value){
        int i;
        for (i = 0; i < a.length; i++){
            if (a[i] > value){
                return false;
            }
        }
        return true;
    }
}
