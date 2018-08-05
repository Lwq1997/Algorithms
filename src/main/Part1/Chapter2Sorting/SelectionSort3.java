package main.Part1.Chapter2Sorting;


/**
 * @Author: Lwq
 * @Date: 2018/8/5 14:55
 * @Version 1.0
 * @Describe
 */
public class SelectionSort3 {
    public static void main(String[] args) {
        int n = 20;
        Integer[] arr= SortTestHelper.generateRandomArray(n,0,200);
        sort(arr,n);
        SortTestHelper.printArray(arr);
    }

    private static void sort(Integer[] arr, int n) {
        for(int i = 0 ; i < n ; i ++){
            int mindex = i;
            for(int j =i+1; j < n ; j++){
                mindex = arr[j]<arr[mindex]?j:mindex;
            }
            swap(arr,i,mindex);
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
