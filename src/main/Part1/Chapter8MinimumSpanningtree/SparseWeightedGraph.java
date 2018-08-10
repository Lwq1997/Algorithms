package main.Part1.Chapter8MinimumSpanningtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author lwq
 * @create 2018-08-10 15:36
 * @desc 加权稀疏图--领接表
 **/
public class SparseWeightedGraph<Weight extends Number&Comparable> implements WeightedGraph{
    //图的顶点
    private int vertices;

    //图的边数
    private int edges;

    private boolean directed;

    private List<Edge>[] adj;

    SparseWeightedGraph(int vertices,boolean directed){
        this.vertices = vertices;
        this.edges = 0;
        this.directed = directed;
        adj = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            adj[i] = new ArrayList<>();
        }
    }

    @Override
    public int V() {
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

        adj[edge.v()].add(new Edge(edge));

        if(edge.v()!=edge.w()&&!directed){
            adj[edge.w()].add(new Edge(edge.w(),edge.v(),edge.wt()));
        }
        edges++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert (v<vertices&&v>=0);
        assert (w<vertices&&w>=0);
        for(int i = 0; i < adj[v].size() ; i++){
            if(adj[v].get(i).order(v)==w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for(int i = 0; i < vertices; i++){
            System.out.print("vertex " + i + ":\t");
            for(int j = 0; j < adj[i].size() ; j++){
                Edge edge = adj[i].get(j);
                System.out.print("( to:" + edge.order(i) + ", weight: " + edge.wt() + " )\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge> adj(int v) {
        assert (v>=0 && v <vertices);
        return adj[v];
    }
}
