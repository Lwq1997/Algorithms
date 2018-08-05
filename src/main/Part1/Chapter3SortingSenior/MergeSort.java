package main.Part1.Chapter3SortingSenior;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 17:02
 * @Version 1.0
 * @Describe
 */
public class MergeSort {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("main.Part1.Chapter3SortingSenior.MergeSort",arr);
    }

    public static void sort(Comparable[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int mid = l+((r-l)>>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
//        归并排序的算法优化(判断arr[mid]大于arr[mid+1],再接着往下进行merge)
        if(arr[mid].compareTo(arr[mid+1])>0){
            merge(arr,l,mid,r);
        }
    }

    private static void merge(Comparable[] arr, int left, int middle, int right) {
        Comparable[] aux = new Comparable[right - left + 1];
        // 开始合并
        int index = 0;
        // 左侧游标
        int i = left;
        // 右侧游标
        int j = middle + 1;
        while (i<=middle&&j<=right){
            aux[index++] = arr[i].compareTo(arr[j])==-1?arr[i++]:arr[j++];
        }
        while (i<=middle){
            aux[index++] = arr[i++];
        }
        while (j<=right){
            aux[index++] = arr[j++];
        }
        for(index = 0;index<aux.length;index++){
            arr[left+index]=aux[index];
        }
    }
}
