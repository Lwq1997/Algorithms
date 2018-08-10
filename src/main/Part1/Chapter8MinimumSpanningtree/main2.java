package main.Part1.Chapter8MinimumSpanningtree;

import java.util.List;

/**
 * @author etouch
 * @create 2018-08-10 18:39
 * @desc 测试最小生成树算法
 **/
public class main2 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter8MinimumSpanningtree\\graph1.txt";

        SparseWeightedGraph graph = new SparseWeightedGraph(8,false);

        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(graph,filename);

        System.out.println("graph1 in Sparse WeightedGraph:");
        graph.show();
        System.out.println();
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(graph);
        List<Edge> list = lazyPrimMST.mstEdges();
        for(int i = 0; i <list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("The weight of MST is : "+lazyPrimMST.result());
        System.out.println();
    }
}
