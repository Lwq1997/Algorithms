package main.Part1;

/**
 * @author etouch
 * @create 2018-08-17 15:07
 * @desc 找到数组中出现次数大于数组一半长度数字
 **/
public class findMosttNumber {
    public static int find(int[] a,int length){
        int cand = a[0];
        int times = 1;
        for(int i = 1;  i < length; i++){
            if(times==0){
                cand = a[i];
                times = 1;
            }
            if(cand == a[i]){
                times++;
            }else {
                times--;
            }
        }
        return cand;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,2,5,9,9,9,9,3};
        System.out.println(find(a,a.length));
    }
}
