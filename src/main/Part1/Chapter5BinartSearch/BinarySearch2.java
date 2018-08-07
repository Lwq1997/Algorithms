package main.Part1.Chapter5BinartSearch;

/**
 * @author Lwq
 * @create 2018-08-07 13:17
 * @desc    递归二分查找
 **/
public class BinarySearch2 {
    public static int binarySearch(Comparable[] arr,int key){
        int n = arr.length;
        return binarySearch(arr,0,n-1,key);
    }

    private static int binarySearch(Comparable[] arr, int left, int right, int key) {
        if(left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if(arr[mid].compareTo(key)==0){
            return mid;
        }else if(arr[mid].compareTo(key)==-1){
            return binarySearch(arr,mid+1,right,key);
        }else {
            return binarySearch(arr,left,right-1,key);
        }
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N ; i++){
            arr[i] = i;
        }
        int k = 151;
        if(binarySearch(arr,k)==k){
            System.out.println(true);
        }
    }
}
