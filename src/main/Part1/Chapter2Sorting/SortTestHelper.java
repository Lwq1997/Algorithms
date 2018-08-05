package main.Part1.Chapter2Sorting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    /**
     * 生成有n个元素的几乎有序随机数组
     */
    public static Integer[] generateRandomArray(int n,int swapTime){
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = i;
        }
        for(int i = 0; i < swapTime; i ++){
            int x = (int) (Math.random()*n);
            int y = (int) (Math.random()*n);
            swap(arr,x,y);
        }
        return arr;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(Object[] arr){
        int n = arr.length;
        for(Object o :arr){
            System.out.print(o+" ");
        }
        System.out.println();
    }

    /**
     * 测试sortClassName所对应的排序算法arr数组所得到结果的正确性和算法运行时间
     *
     * @param sortClassName 排序类的类名称，可使用反射获取这个类的实例
     * @param arr           待排序数组
     */
    public static void testSort(String sortClassName,Comparable[] arr) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class sortClass = Class.forName(sortClassName);
        // 通过排序函数的Class对象获得排序方法.name表示排序类中的排序方法名。第二个参数表示sort函数的入参
        Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
        Object[] params = new Object[]{arr};
        long startTime = System.currentTimeMillis();
        sortMethod.invoke(sortClass,params);
        long endTime = System.currentTimeMillis();
        assert isSorted(arr);
        printArray(arr);
        System.out.println(sortClass.getSimpleName()+":"+(endTime-startTime));
    }

    private static boolean isSorted(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return  true;
    }
}

