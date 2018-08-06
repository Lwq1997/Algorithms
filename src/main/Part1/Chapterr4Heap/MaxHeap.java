package main.Part1.Chapterr4Heap;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 19:52
 * @Version 1.0
 * @Describe
 */
public class MaxHeap <T extends Comparable>{
    /**
     * 最大堆中的数据
     */
    protected T[] data;

    /**
     * 最大堆中的元素个数
     */
    protected int count;

    /**
     * 数组容量
     */
    protected int capacity;

    public MaxHeap(int capacity){
        // 不能直接声明泛型数组，只能先声明再强制转换
        this.data = (T[]) new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(T arr[]){
        int n = arr.length;
        data = (T[]) new Comparable[n+1];
        capacity=n;
        for(int i = 0; i < n;i++){
            data[i+1] = arr[i];
        }
        count=n;
        for(int i = count/2;i>=1;i--){
            shifDown(i);
        }
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    private void swap(int i,int j){
        T t = data[i];
        data[i]=data[j];
        data[j]=t;
    }

    public void insert(T t){
        if(count+1>capacity){
            System.out.println("堆已经满了");
            return;
        }
        data[++count]=t;
        shifUp(count);
    }

    public T popMax(){
        if(count<=0){
            System.out.println("堆已经满了");
            return null;
        }
        //最大元素是第一个元素
        T max = data[1];
        swap(1,count);
        count--;
        shifDown(1);
        return max;
    }

    private void shifUp(int k){
        //比较k位置的数据和其父节点的数据的大小,k/2是父节点
        while (k>1&&data[k/2].compareTo(data[k])==-1){
            swap(k,k/2);
            k /= 2;
        }
    }

    private void shifDown(int k){
        // 当当前k节点有子节点的时候(有左孩子不一定有右孩子，但有右孩子一定有左孩子。因为生成堆得时候是从左向右地)
        while (2*k<=count){
            int j = 2*k;
            //得到两个孩子中值比较大的孩子
            if(j+1<=count&&data[j+1].compareTo(data[j])==1){
                j++;
            }
            // 父节点比两个子节点的较大值还大，那么不需要交换
            if(data[k].compareTo(data[j])>=0){
                break;
            }
            swap(k,j);
            // 把换后的子节点作为父节点，接着往下走
            k=j;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(53);
        maxHeap.insert(50);
        maxHeap.insert(15);
        maxHeap.insert(56);
        maxHeap.insert(53);
        maxHeap.insert(10);
        System.out.println(maxHeap.data[1]);
    }
}
