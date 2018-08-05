package main.Part1.Chapter3SortingSenior;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 19:25
 * @Version 1.0
 * @Describe 快速排序
 */
public class QuickSort {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("main.Part1.Chapter3SortingSenior.QuickSort",arr);
    }

    public static void sort(Comparable[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(Comparable[] arr, int left, int right) {
        if(left<right){
            int[] p = parttion(arr,left,right);
            quickSort(arr,left,p[0]-1);
            quickSort(arr,p[1]+1,right);
        }
    }

    private static int[] parttion(Comparable[] arr, int left, int right) {
        int less = left-1;
        int more = right;
        int index = left;
        while (index<more){
            if(arr[index].compareTo(arr[right])==-1){
                swap(arr,++less,index++);
            }else if(arr[index].compareTo(arr[right])==1){
                swap(arr,--more,index);
            }else {
                index++;
            }
        }
        swap(arr,more,right);
        return new int[]{less+1,more};
    }
    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
