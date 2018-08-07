package main.Part1.Chapter4Heap;

import java.lang.reflect.InvocationTargetException;

/**
 * @author etouch
 * @create 2018-08-07 9:46
 * @desc 利用索引堆进行排序
 **/
public class IndexHeapSort {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("main.Part1.Chapter4Heap.IndexHeapSort",arr);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<>(n);
        for(int i = 0; i < n;i++){
            indexMaxHeap.insert(arr[i],i);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = indexMaxHeap.popMax();
            System.out.print(arr[i]+" ");
        }
    }
}
