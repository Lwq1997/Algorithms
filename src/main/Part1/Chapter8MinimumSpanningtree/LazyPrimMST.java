package main.Part1.Chapter8MinimumSpanningtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author etouch
 * @create 2018-08-10 18:02
 * @desc 最小生成树的Lazy Prim算法
 **/
public class LazyPrimMST <Weight extends Number & Comparable>{
    private WeightedGraph<Weight> weightedGraph;
    /**
     * pq:priority queue 优先队列，其实就是最x堆
     */
    private MinHeap<Edge> pq;
    /**
     * 用于标记各个元素是否已经被标记，被标记了说明已经被划分到了另外一个分割区
     */
    private boolean[] marked;
    /**
     * 存储组成最小生成树的v-1条边
     */
    private List<Edge> mst;
    /**
     * 最小生成树的权值.一般是double类型(这里写成NUmber是因为double、int 、flot都继承自Number类型)
     */
    private Number mstWeight;

    LazyPrimMST(WeightedGraph graph){
        this.weightedGraph = graph;
        pq = new MinHeap<>(graph.E());
        marked = new boolean[graph.V()];
        mst = new ArrayList<>();

        visit(0);

        while (!pq.isEmpty()){
            Edge edge = pq.popMin();
            if(marked[edge.v()]==marked[edge.w()]){
                // 弹出来的最小边的两个顶点都已经被访问过了(现在肯定都在横切边的左侧或右侧了)，不能用切分定理了，直接跳过这个点
                continue;
            }
            // 当是横切边的情况下，弹出的最小值一定是最小生成树v-1条边中的一条了，加入到mst中
            mst.add(edge);
            if(!marked[edge.v()]){
                visit(edge.v());
            }else {
                visit(edge.w());
            }

            mstWeight = mst.get(0).wt();
            for(int i = 1; i < mst.size();i++){
                mstWeight = mstWeight.doubleValue() + mst.get(i).wt().doubleValue();
            }
        }
    }

    private void visit(int i) {
        assert (!marked[i]);
        marked[i] = true;
        for(Edge edge:weightedGraph.adj(i)){
           if(!marked[edge.order(i)]){
               pq.insert(edge);
           }
        }
    }

    /**
     * 获取最小生成树的所有的边
     */
    List<Edge> mstEdges() {
        return mst;
    }

    /**
     * 获取最小生成树的总权重
     */
    Number result() {
        return mstWeight;
    }
}
