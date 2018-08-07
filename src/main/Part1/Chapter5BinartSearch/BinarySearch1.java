package main.Part1.Chapter5BinartSearch;



/**
 * @author Lwq
 * @create 2018-08-07 12:44
 * @desc 非递归的二分查找
 **/
public class BinarySearch1 {
    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n;i++){
            arr[i] = i;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2 * n; i++) {
            int v = binarySearch(arr, i);
            if (i < n) {
                System.out.println(i==v);
            } else {
                assert (v == -1);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Binary Search(Without Recursion): " + (endTime - startTime) + " ms");

    }

    public static int binarySearch(Comparable[] arr,Comparable target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid].compareTo(target)==-1){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

//    查找第一个相等的元素，也就是说等于查找key值的元素有好多个，返回这些元素最左边的元素下标。
    public static int findFirstEqual(Comparable[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        // 这里必须是 <=
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (arr[mid] .compareTo(key) !=-1) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if(left<arr.length&&arr[left].compareTo(key)==1){
            return left;
        }
        return -1;
    }

//    查找最后一个与key相等的元素
    public static int findLastEqual(Comparable[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid].compareTo(key)!=1){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        if(right>=0&&right<arr.length&&arr[right].compareTo(key)==1){
            return right;
        }
        return -1;
    }

//    查找第一个等于或者大于key的元素
    public static int findLastEqualSmaller(Comparable[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid] .compareTo(key) !=-1) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if(right>=0&&right<arr.length&&arr[right].compareTo(key)==1){
            return right;
        }
        return -1;
    }
}
