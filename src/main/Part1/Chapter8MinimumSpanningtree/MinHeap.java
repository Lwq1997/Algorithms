package main.Part1.Chapter8MinimumSpanningtree;

import java.util.Iterator;

/**
 * @author Lwq
 * @create 2018-08-10 18:03
 * @desc 最小堆
 **/
public class MinHeap<T extends Comparable> {
    protected T[] data;
    protected int count;
    protected int capacity;

    MinHeap(int capacity){
        data = (T[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    MinHeap(T arr[]){
        int n = arr.length;

        data = (T[]) new Comparable[n+1];
        capacity = n;
        for(int i = 0;i < n;i++){
            data[i+1] = arr[i];
        }
        count = n;
        for(int i = count/2; i >=1 ;i--){
            shiftDown(i);
        }
    }

    private void shiftDown(int k) {
        while (2*k<=count){
            int j = 2*k;
            if(j+1<=count && data[j+1].compareTo(data[j])<0){
                j++;
            }
            if(data[k].compareTo(data[j])<0){
                break;
            }
            swap(k,j);
            k=j;
        }
    }


    /**
     * 交换堆中索引为i和j的两个元素
     */
    private void swap(int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    /**
     * 获取最小堆的大小
     */
    int size() {
        return count;
    }

    /**
     * 判断最小堆是否为空
     */
    boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入元素
     */
    void insert(T item) {
        // 防止后面的++count越界
        assert (count + 1 <= capacity);
        // 插入新元素，元素数加1,之所以用++count而不用count++是因为数组下标从1开始
        data[++count] = item;
        // 把新加入的元素向上浮动到合适位置
        shiftUp(count);
    }

    private void shiftUp(int count) {
        while (count>1 && data[count/2].compareTo(data[count])>0){
            swap(count/2,count);
            count/=2;
        }
    }

    /**
     * 弹出最小值(根节点的对象)
     */
    T popMin() {
        // 保证堆不为空
        assert (count > 0);
        // 最小元素为第一个元素
        T min = data[1];
        // 移出最小元素后，需要把最下面的元素移到上面去
        swap(1, count);
        // 少了最后一个元素
        count--;
        // 将换上去(到最上面了,根元素，下标为1)的最后一个元素下移
        shiftDown(1);
        return min;
    }

    // 获取堆中的最小元素(即堆顶元素)
    T getMin() {
        assert (count > 0);
        return data[1];
    }

    /**
     * 测试 MinHeap
     */
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        // 堆中元素个数
        int N = 100;
        // 堆中元素取值范围[0, M)
        int M = 100;
        for (int i = 0; i < N; i++) {
            minHeap.insert(new Integer((int) (Math.random() * M)));
        }

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = minHeap.popMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for (int i = 1; i < N; i++) {
            assert arr[i - 1] <= arr[i];
        }
    }
}
