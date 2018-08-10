package main.Part1.Chapter8MinimumSpanningtree;

/**
 * @author lwq
 * @create 2018-08-10 13:26
 * @desc 加权图的边
 **/
public class Edge<Weight extends Number&Comparable> implements Comparable<Edge>{
    //边的两个顶点
    private int a,b;

    //边的权值
    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> edge){
        this.a = edge.a;
        this.b = edge.b;
        this.weight = edge.weight;
    }

    public int v(){
        return a;
    }

    public int w(){
        return b;
    }

    public Weight wt() {
        return weight;
    }

    //给定一个顶点，返回另一个顶点
    public int order(int x){
        assert x == a || x == b;
        return x==a?b:a;
    }

    public String toString(){
        return a+"--"+b+":"+weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return weight.compareTo(edge.weight);
    }
}
