package main.Part1.Chapter2Sorting;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 14:34
 * @Version 1.0
 * @Describe    做成了一个公共的选择排序
 */
public class SelectionSort2 {
    public static void main(String[] args) {
        //对整形数组
        Integer[] a = {10,3,6,5,7,1,2,8,9,5};
        sort(a);
        for (int i = 0 ; i < 10 ; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        // 2.对浮点数进行排序
        Float[] b = {2.2f, 1.1f, 4.4f, 3.3f};
        sort(b);
        for (int i = 0; i < 4; ++i) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        Character[] c = {'B', 'A', 'D', 'C'};
        sort(c);
        for (int i = 0; i < 4; ++i) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
        // 5.自定义对象排序
        Student[] students = new Student[4];
        students[0] = new Student("B", 78);
        students[1] = new Student("A", 86);
        students[2] = new Student("G", 34);
        students[3] = new Student("D", 78);
        sort(students);
        for (int i = 0; i < 4; i++) {
            System.out.println(students[i]);
        }
        System.out.println();
    }

    private static void sort(Comparable[] a) {
        int n = a.length;
        for(int i = 0 ; i < n ; i++){
            int mindex = i;
            for(int j = i+1; j < n;j++){
                mindex = a[j].compareTo(a[mindex])<0?j:mindex;
            }
            swap(a,i,mindex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
