package main.Part1.Chapter6UnoinFind;

/**
 * @author Lwq
 * @create 2018-08-08 18:35
 * @desc  并查集
 **/
public class UnionFind4 {
    //parent[i] 是 i 属于的组
    private int[] parent;
    private int[] rank;   //rank[i]表示i为根的集合的层数
    private int count;

    public UnionFind4(int n) {
        count = n;
        rank=new int[n];
        parent = new int[n];
        for(int i = 0; i < n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 返回P属于的组
     * @param p
     * @return
     */
    public int find(int p){
        if(p<0&&p>=count){
            System.out.println("索引有误");
        }
        while(p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    public void unionElements(int p,int q){
        int pRoot = find(p); //p属于的组
        int qRoot = find(q);  //q属于的组
        if(pRoot==qRoot){
            return;
        }
        // p所在的并查集元素数小于q所在的并查集元素数，p指向q
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot]>rank[qRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }

    /**
     * 判断下标为p和q的点之间是否存在连接
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
