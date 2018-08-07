package main.Part1.Chapter5BinartSearch;

/**
 * @author Lwq
 * @create 2018-08-07 13:23
 * @desc  在查找过程中，floor函数用于返回小于target的最大值在数组中的索引 ceil函数用于返回大于target的最小值在数组中的索引
 **/
public class CeilFloor {
    public static int floor(Comparable[] arr,Comparable target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid].compareTo(target)!=-1){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return right;
    }

    public static int ceil(Comparable[] arr,Comparable target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid].compareTo(target)!=1){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,10,10,10,95,365,1520};
        System.out.println(floor(arr,10));
        System.out.println(ceil(arr,10));
    }
}
