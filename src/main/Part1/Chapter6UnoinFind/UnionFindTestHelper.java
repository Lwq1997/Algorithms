package main.Part1.Chapter6UnoinFind;

/**
 * @author etouch
 * @create 2018-08-08 19:17
 * @desc 测试并查集的辅助类
 **/
public class UnionFindTestHelper {
    public static void testUF(int n){
        UnionFind uf = new UnionFind(n);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            uf.unionElements(a,b);
            uf.isConnected(a,b);
        }

        for(int i = 0; i < n ; i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }

    public static void testUF2(int n){
        UnionFind2 uf = new UnionFind2(n);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            uf.unionElements(a,b);
        }

        for(int i = 0; i < n ; i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF2, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }

    public static void testUF3(int n){
        UnionFind3 uf = new UnionFind3(n);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            uf.unionElements(a,b);
        }

        for(int i = 0; i < n ; i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF3, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }
    public static void testUF4(int n){
        UnionFind4 uf = new UnionFind4(n);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            uf.unionElements(a,b);
        }

        for(int i = 0; i < n ; i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF3, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }

    public static void testUF5(int n){
        UnionFind5 uf = new UnionFind5(n);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            uf.unionElements(a,b);
        }

        for(int i = 0; i < n ; i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF3, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }
    public static void testUF6(int n){
        UnionFind6 uf = new UnionFind6(n);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            uf.unionElements(a,b);
        }

        for(int i = 0; i < n ; i++){
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF3, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }
    public static void main(String[] args) {
//        UnionFindTestHelper.testUF(100000);
//        UnionFindTestHelper.testUF2(100000);
        UnionFindTestHelper.testUF3(1000000);
        UnionFindTestHelper.testUF4(1000000);
        UnionFindTestHelper.testUF5(1000000);
        UnionFindTestHelper.testUF6(1000000);
    }
}
