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

    public static void main(String[] args) {
        UnionFindTestHelper.testUF(10);
    }
}
