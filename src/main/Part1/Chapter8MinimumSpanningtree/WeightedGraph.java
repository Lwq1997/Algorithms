package main.Part1.Chapter8MinimumSpanningtree;

/**
 * @author Lwq
 * @create 2018-08-10 13:33
 * @desc
 **/
public interface WeightedGraph<Weight extends Number & Comparable>  {
    int V();

    int E();

    void addEdge(Edge<Weight> edge);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Edge<Weight>> adj(int v);
}
