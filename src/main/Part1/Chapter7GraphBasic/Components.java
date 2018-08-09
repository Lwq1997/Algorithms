package main.Part1.Chapter7GraphBasic;

/**
 * @author lwq
 * @create 2018-08-09 15:33
 * @desc 图中连通分量的获取
 **/
public class Components {
    private Graph graph;

    private boolean[] visited;

    private int ccount;
    private int[] id;

    void dfs(int v){
        // 上来先把v设置为已访问
        visited[v] = true;
        // 同一个连通分量内，其parent(即为id[i]的值)设置为当前连通分量的顺序号即可
        id[v] = ccount;
        // 遍历邻接点
        for(Integer i : graph.adj(v)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    Components(Graph graph){
        this.graph = graph;
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        ccount = 0;
        for(int i = 0; i <graph.V() ; i++){
            visited[i] = false;
            id[i] = -1;
        }
        for(int i = 0; i < graph.V(); i ++){
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }

    /**
     * 返回连通分量的个数
     */
    public int count() {
        return ccount;
    }

    /**
     * 判断两点之间是否连通
     */
    public boolean isConnected(int v, int w) {
        // 检测元素是否过界
        assert (v >= 0 && v < graph.V());
        assert (w >= 0 && w < graph.V());
        return id[v] == id[w];
    }
}
