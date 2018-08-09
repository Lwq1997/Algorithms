package main.Part1.Chapter7GraphBasic;

/**
 * @author lwq
 * @create 2018-08-09 14:35
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter7GraphBasic\\graph1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("graph1 in Sparse Graph:");
        g1.show();

        Components components1 = new Components(g1);
        System.out.println("TestG1.txt, Components Count: " + components1.count());
        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename);
        System.out.println("graph1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter7GraphBasic\\graph2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("graph2 in Sparse Graph:");
        g3.show();
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Components Count: " + component2.count());

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("graph2 in Dense Graph:");
        g4.show();
    }
}
