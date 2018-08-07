package main.Part1.Chapterr4Heap;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Lwq
 * @create 2018-08-06 18:31
 * @desc
 **/
public class HeapSort2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("main.Part1.Chapterr4Heap.HeapSort2",arr);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;

        for(int i = (n-1)/2;i>=0;i--){
            shifDown(arr,n,i);
        }

        for(int i = n-1 ; i > 0;i--){
            System.out.print(arr[0]+" ");
            swap(arr,0,i);
            shifDown(arr,i,0);
        }
        System.out.println();
    }

    private static void shifDown(Comparable[] arr, int n, int k) {
        while (2*k + 1<n){
            int j = 2*k+1;
            if(j+1<n && arr[j+1].compareTo(arr[j])>0){
                j++;
            }
            if(arr[k].compareTo(arr[j])>=0){
                break;
            }
            // 父节点小于孩子节点的较大值，那么就和较大值的子节点交换
            swap(arr, k, j);
            // 把换后的子节点作为父节点，接着往下走
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
