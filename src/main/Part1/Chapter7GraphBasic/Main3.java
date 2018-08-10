package main.Part1.Chapter7GraphBasic;

/**
 * @author LWQ
 * @create 2018-08-10 12:38
 * @desc
 **/
public class Main3 {
    public static void main(String[] args) {
        System.out.println("*********稀疏圖*******");
        String fileName1 = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter7GraphBasic\\graph1.txt";
        SparseGraph g1 = new SparseGraph(13,false);
        ReadGraph readGraph1 = new ReadGraph(g1,fileName1);
        g1.show();
        System.out.println();
        Path path1 = new Path(g1,0);
        System.out.print("path of 0 to 3:");
        path1.showPath(3);
        ShortestPath path11 = new ShortestPath(g1, 0);
        System.out.print("BFS shortest path of 0 to 3: ");
        path11.showPath(3);

        System.out.println("*********稠密圖*******");
        String filename2 = "C:\\Users\\etouch\\IdeaProjects\\Algorithms\\src\\main\\Part1\\Chapter7GraphBasic\\graph2.txt";
        DenseGraph g2 = new DenseGraph(7, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        g2.show();
        System.out.println();
        Path path2 = new Path(g2, 0);
        System.out.print("path of 0 to 6 :");
        path2.showPath(6);
        ShortestPath path22 = new ShortestPath(g2, 0);
        System.out.print("BFS shortest path of 0 to 6: ");
        path22.showPath(6);
    }
}
