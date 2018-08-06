package main.Part1.Chapterr4Heap;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Lwq
 * @create 2018-08-06 12:52
 * @desc   利用最大堆进行排序
 **/
public class HeapSort1 {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.popMax() + " ");
        }
//        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
//        while (!maxHeap.isEmpty()) {
//            System.out.print(maxHeap.popMax() + " ");
//        }
        System.out.println();
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // 测试自定义的算法辅助函数
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        // 测试数组是否有序
        // sort函数一定不要穿数组长度，要不老会报错
        SortTestHelper.testSort("main.Part1.Chapterr4Heap.HeapSort1", arr);
    }
}
