package main.Part1.Chapter8MinimumSpanningtree;

import main.Part1.Chapter7GraphBasic.SparseGraph;

/**
 * @author etouch
 * @create 2018-08-10 17:56
 * @desc
 **/
public class main {
    public static void main(String[] args) {
        String filename = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter8MinimumSpanningtree\\graph1.txt";
        SparseWeightedGraph g1 = new SparseWeightedGraph(8,false);

        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(g1,filename);

        System.out.println("graph1 in Sparse WeightedGraph:");
        g1.show();

        System.out.println();

        DenseWeightedGraph g2 = new DenseWeightedGraph(8, false);
        ReadWeightedGraph readWeightedGraph2 = new ReadWeightedGraph(g2, filename);
        System.out.println("graph1 in Dense WeightedGraph:");
        g2.show();

        System.out.println();
    }
}
