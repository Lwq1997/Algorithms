package main.Part1.Chapter2Sorting;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 15:27
 * @Version 1.0
 * @Describe
 */
public class InsertionSort {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("main.Part1.Chapter2Sorting.InsertionSort",arr);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 1; i < n ;i++){
            //j相当于数组下标
            for(int j = i-1 ; j >= 0 && arr[j].compareTo(arr[j+1])==1 ; j--){
                swap(arr,j+1,j);
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
