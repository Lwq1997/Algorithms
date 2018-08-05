package main.Part1.Chapter2Sorting;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 14:02
 * @Version 1.0
 * @Describe  选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,4,8,9,5,6,3,1,5,6,10};
        sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        for( int i = 0; i < n-1 ;i++){
            int mindex = i;
            for(int j = i+1 ; j < n ; j++){
                mindex = arr[j]<arr[mindex]?j:mindex;
            }
            swap(arr,i,mindex);
        }
    }

    private static void swap(int[] arr, int i, int mindex) {
        int tmp = arr[i];
        arr[i] = arr[mindex];
        arr[mindex] = tmp;
    }
}
