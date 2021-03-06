package main.Part1.Chapter2Sorting;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 15:44
 * @Version 1.0
 * @Describe  插入排序的优化
 */
public class InsertionSort2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // 测试自定义的算法辅助函数
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        //近乎有序的数组
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,10);
        // 测试数组是否有序
        SortTestHelper.testSort( "main.Part1.Chapter2Sorting.InsertionSort2", arr);
        SortTestHelper.testSort( "main.Part1.Chapter2Sorting.InsertionSort2", arr1);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 注意下标从1开始，不停往前比较，下标为0的元素默认有效
        for (int i = 1; i < n; ++i) {
            // 先把起始位置的元素暂存
            Comparable tmp = arr[i];
            int j ;
            // 从位置i开始，往前挨个比较(前面已经是有序地了，这个是前提)，一直比较到前面的某个元素比自己小就停下
            for (j = i; j > 0 && arr[j-1].compareTo(tmp)==1; j--) {
                // 起始位置元素比前面的小，就把前面的值附到后面来元素上
                arr[j] = arr[j - 1];
            }
            // 一直到j前面的元素j-1小于tmp了，说明升序排列完成，把之前存的起始位置元素tmp插入到此处即可
            arr[j] = tmp;
        }
    }
}
