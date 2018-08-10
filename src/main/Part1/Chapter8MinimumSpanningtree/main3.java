package main.Part1.Chapter8MinimumSpanningtree;

/**
 * @author Lwq
 * @create 2018-08-10 19:34
 * @desc
 **/
public class main3 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter8MinimumSpanningtree\\graph1.txt";

        SparseWeightedGraph graph = new SparseWeightedGraph(8,false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(graph,filename);

        System.out.println("Test Kruskal MST: ");
        long startTime = System.currentTimeMillis();
        KruskalMST<Double> kruskalMST = new KruskalMST<>(graph);
        System.out.println("The weight of Kruskal MST is : "+kruskalMST.result());
        long endTime = System.currentTimeMillis();
        System.out.println("Test to test: " + (endTime-startTime) + "ms.");
        System.out.println();
    }
}
