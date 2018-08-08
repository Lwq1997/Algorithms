package main.Part1.Chapter6UnoinFind;

/**
 * @author Lwq
 * @create 2018-08-08 18:35
 * @desc  并查集
 **/
public class UnionFind {
    //id[i] 是 i 属于的组
    private int[] id;
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for(int i = 0; i < n;i++){
            id[i] = i;
        }
    }

    /**
     * 返回P属于的组
     * @param p
     * @return
     */
    public int find(int p){
        if(p<0&&p>count){
            System.out.println("索引有误 ");
        }
        return id[p];
    }

    public void unionElements(int p,int q){
        int pId = find(p); //p属于的组
        int qId = find(q);  //q属于的组
        if(pId==qId){
            return;
        }
        for( int i = 0; i < count; i ++){
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }

    /**
     * 判断下标为p和q的点之间是否存在连接
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
