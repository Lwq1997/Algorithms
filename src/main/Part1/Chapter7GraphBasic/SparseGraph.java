package main.Part1.Chapter7GraphBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lwq
 * @create 2018-08-09 9:34
 * @desc 稀疏图  邻接表
 **/
public class SparseGraph {
//    图的顶点数
    private int vertices;

//    图的边数
    private int edges;

//    有向图还是无向图
    private boolean directed;

//    领接矩阵
    private List<Integer>[]  adj;

    SparseGraph(int vertices, boolean directed){
        this.vertices = vertices;
        this.directed = directed;
        this.edges = 0;
        adj = new ArrayList[vertices];
        for(int i = 0; i < adj.length ; i++){
            adj[i] = new ArrayList<>();
        }
    }

//    返回顶点数
    public int V(){
        return vertices;
    }

//    返回边数
    private int E(){
        return edges;
    }

//    添加边(在v和w之间建立一条边)
    public void addEdge(int v,int w){
        assert (v>=0&&v<vertices);
        assert (w>=0&&w<vertices);

        if(hasEdge(v,w)){
            return;
        }
        adj[v].add(w);
        // v=w会生成自环边
        if(v!=w && !directed){
            adj[w].add(v);
        }
        edges++;
    }

    private boolean hasEdge(int v, int w) {
        assert (v>=0&&v<vertices);
        assert (w>=0&&w<vertices);
        for(int i = 0; i < adj[v].size(); i++){
            if(adj[v].get(i) == w){
                return true;
            }
        }
        return false;
    }
}
