package main.Part1.Chapter2Sorting;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 14:46
 * @Version 1.0
 * @Describe  排序的辅助类
 */
public class SortTestHelper {
    /**
     * 生成有n个元素的随机数组(仅限于整型数组)，每个元素的随机范围为[rangeL, rangeR)
     */
    public static Integer[] generateRandomArray(int n,int rangeL,int rangeR){
        assert(rangeL<rangeR);
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = (int)(Math.random()*(rangeR-rangeL+1)+rangeL);
        }
        return arr;
    }

    public static void printArray(Object[] arr){
        int n = arr.length;
        for(Object o :arr){
            System.out.print(o+" ");
        }
        System.out.println();
    }
}

