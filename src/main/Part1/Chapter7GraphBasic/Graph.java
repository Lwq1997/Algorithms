package main.Part1.Chapter7GraphBasic;

/**
 * @author Lwq
 * @create 2018-08-09 13:20
 * @desc 图的父类
 **/
public interface Graph {
    int V();

    int E();

    void addEdge(int v,int w);

    boolean hasEdge(int v,int w);

    void show();

    Iterable<Integer> adj(int v);
}
