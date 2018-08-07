package main.Part1.Chapter4Heap;

/**
 * @author Lwq
 * @create 2018-08-07 9:49
 * @desc 索引最大堆
 **/
public class IndexMaxHeap<Item extends Comparable> {
    protected Item[] data;

    protected int[] indexes;

    protected int count;

    protected int capacity;

    IndexMaxHeap(int capacity){
        data = (Item[])new Comparable[capacity+1];
        indexes = new int[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    //item是要比较的数组中的元素，i是内部维护索引数组里面的值
    public void insert(Item item,int i){
        if(count+1>capacity){
            System.out.println("堆已经满了");
            return;
        }
        if(i+1<1){
            System.out.println("索引错误，应该大于等于0");
            return;
        }
        if(i+1>capacity){
            System.out.println("索引越界");
            return;
        }
        i+=1;
        data[i] = item;
        // 插入新元素，元素数加1,之所以用++count而不用count++是因为数组下标从1开始
        indexes[++count] = i;
        // 把新加入的元素的index(在indexes中的位置)向上浮动到合适位置
        shiftup(count);//count相当于内部维护索引数组的索引
    }

    private void shiftup(int k) {
        while (k>1&&data[indexes[k/2]].compareTo(data[indexes[k]])<0){
            // 如果当前元素的父元素(在数组中的下表为整除2)比当前元素还小，
            // 则不符合最大堆的定义，那么就交换一下
            swapIndex(k/2,k);
            k/=2;
        }
    }

    private void shiftDown(int k){
        while (2*k<=count){
            int j = 2*k;
            if(j+1<=count && data[indexes[j+1]].compareTo(data[indexes[j]])>0){
                j++;
            }
            // 父节点比两个子节点的较大值还大，那么不需要交换
            if(data[indexes[k]].compareTo(data[indexes[j]])>=0){
                break;
            }
            swapIndex(k,j);
            k = j;
        }
    }

    private void swapIndex(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }

    public Item popMax(){
        if(count<=0){
            System.out.println("堆是空的");
            return null;
        }
        Item max = data[indexes[1]];
        swapIndex(1,count);
        count--;
        shiftDown(1);
        return max;
    }

    public int popmaxIndex(){
        if(count<=0){
            System.out.println("堆是空的");
            return -1;
        }
        int maxIndex = indexes[1];
        swapIndex(1,count);
        count--;
        shiftDown(1);
        // 外面的用户数组索引是从0开始的，内部堆数组是从1开始地，所以需要减1
        return maxIndex-1;
    }

    // 获取最大元素(堆中最上面的元素，即索引中为1的值)，但是并不删除
    public Item getMax(){
        if(count<=0){
            System.out.println("堆是空的");
            return null;
        }
        return data[indexes[1]];
    }

    // 获取最大元素在数组中的索引。注意减去1
    int getMaxIndex() {
        assert (count > 0);
        return indexes[1] - 1;
    }

    public void update(int i,Item item){
        i++;
        data[i] = item;
//        先找到index[j]==i
        for(int j = 1; j <= count ; j++){
            if(indexes[j]==i){
                shiftup(j);
                shiftDown(j);
                return;
            }
        }
    }


    public static void main(String[] args) {
        int N = 100;
        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<>(N);
        System.out.print("插入随机数组是：");
        for(int i = 0; i < N ; i++){
            int j = (int)(Math.random()*N*2);
            System.out.print(j+" ");
            indexMaxHeap.insert(j,i);
        }
        System.out.println();
        System.out.print("内部维护的索引数组的值是：");
        for(int i = 1; i < N ; i ++){
            System.out.print(indexMaxHeap.indexes[i]+" ");
        }
    }
}
