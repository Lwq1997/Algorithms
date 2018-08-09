package main.Part1.Chapter7GraphBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lwq
 * @create 2018-08-09 9:34
 * @desc 稠密图，邻接矩阵
 **/
public class DenseGraph implements Graph{
//    图的顶点数
    private int vertices;

//    图的边数
    private int edges;

//    有向图还是无向图
    private boolean directed;

//    领接矩阵
    private boolean[][]  adj;

    DenseGraph(int vertices,boolean directed){
        this.vertices = vertices;
        this.directed = directed;
        this.edges = 0;
        adj = new boolean[vertices][vertices];
    }

//    返回顶点数
    public int V(){
        return vertices;
    }

//    返回边数
    public int E(){
        return edges;
    }

//    添加边(在v和w之间建立一条边)
    public void addEdge(int v,int w){
        assert (v>=0&&v<vertices);
        assert (w>=0&&w<vertices);

        if(hasEdge(v,w)){
            return;
        }

        adj[v][w] = true;
        if(!directed){
            //无向图实际是双向图
            adj[w][v] = true;
        }
        edges++;
    }

    public boolean hasEdge(int v, int w) {
        assert (v>=0&&v<vertices);
        assert (w>=0&&w<vertices);
        return adj[v][w];
    }

    /**
     * 返回顶点v的所有边
     */
    public Iterable<Integer> adj(int v){
        assert (v>=0&&v<vertices);
        List<Integer> adjV = new ArrayList<>();
        for(int i = 0; i < vertices ; i++){
            if(adj[v][i]){
                adjV.add(i);
            }
        }
        return adjV;
    }

    /**
     * 展示领接矩阵的方法
     */
    public void show(){
        for(int i = 0; i < vertices; i ++){
            for(int j = 0; j < vertices;j++){
                System.out.print(adj[i][j]+" \t");
            }
            System.out.println();
        }
    }
}
