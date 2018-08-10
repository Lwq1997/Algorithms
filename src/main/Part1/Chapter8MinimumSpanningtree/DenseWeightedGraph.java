package main.Part1.Chapter8MinimumSpanningtree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Lwq
 * @create 2018-08-10 13:21
 * @desc 加权稠密图--领接矩阵
 **/
public class DenseWeightedGraph <Weight extends Number & Comparable> implements WeightedGraph{
    //图的顶点
    private int vertices;

    //图的边数
    private int edges;

    //有向图还是无向图
    private boolean directed;

    //领接矩阵
    private Edge<Weight>[][] adj;

    DenseWeightedGraph(int vertices,boolean directed){
        this.vertices = vertices;
        this.edges = 0;
        this.directed = directed;

        adj = new Edge[vertices][vertices];
        for(int i = 0; i < vertices;i++){
            for(int j = 0; j <vertices; j++){
                adj[i][j] = null;
            }
        }
    }

    public int V(){
        return vertices;
    }

    @Override
    public int E() {
        return edges;
    }

    @Override
    public void addEdge(Edge edge) {
        assert (edge.v()>=0 && edge.v()<vertices);
        assert (edge.w()>=0 && edge.w()<vertices);
        if(hasEdge(edge.v(),edge.w())){
            return;
        }

        adj[edge.v()][edge.w()] = new Edge(edge);
        if(edge.v()!=edge.w() && !directed){
            adj[edge.w()][edge.v()] = new Edge(edge.w(),edge.v(),edge.wt());
        }
        edges++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert (v>=0 && v<vertices);
        assert (w>=0 && w<vertices);
        return adj[v][w] != null;
    }

    @Override
    public void show() {
        for(int i = 0; i < vertices ; i++){
            for(int j = 0; j <vertices ; j++){
                if(adj[i][j] != null){
                    System.out.print(adj[i][j].wt()+" \t");
                }else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge> adj(int v) {
        assert (v>=0 && v < vertices);
        List<Edge> adjV = new ArrayList<>();
        for(int i = 0;i < vertices; i++){
            if(adj[v][i]!=null){
                adjV.add(adj[v][i]);
            }
        }
        return adjV;
    }


}
