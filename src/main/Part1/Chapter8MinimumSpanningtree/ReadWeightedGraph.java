package main.Part1.Chapter8MinimumSpanningtree;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author etouch
 * @create 2018-08-10 17:29
 * @desc 从文件中读取来构造加权图
 **/
public class ReadWeightedGraph {
    private Scanner scanner;

    public ReadWeightedGraph(WeightedGraph<Double> weightedGraph, String filename){
        readFile(filename);

        int V = scanner.nextInt();
        if(V<0){
            throw new IllegalArgumentException("number of vertices in a WeightedGraph must be nonnegative");
        }

        assert V == weightedGraph.V();

        int E = scanner.nextInt();
        if (E < 0) {
            throw new IllegalArgumentException("number of edges in a WeightedGraph must be nonnegative");
        }

        for(int i = 0; i < E; i++){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            Double weight = scanner.nextDouble();

            assert v>=0&&v<V;
            assert w>=0&&w<V;

            weightedGraph.addEdge(new Edge<Double>(v,w,weight));

        }
    }

    private void readFile(String filename) {
        assert (filename!=null);
        File file = new File(filename);
        if(file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
