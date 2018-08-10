package main.Part1.Chapter7GraphBasic;

import java.util.*;

/**
 * @author lwq
 * @create 2018-08-10 12:43
 * @desc 广度优先遍历
 **/
public class ShortestPath {
    private Graph graph;
    //起始点
    private int source;

    private boolean[] visited;

    //from[i]表示i是从哪个节点过来的
    private int[] from;

    //source节点到每个节点的最短路径
    private int[] order;

    ShortestPath(Graph graph,int source){
        //先初始化参数
        this.graph = graph;
        assert(source>=0&&source<graph.V());

        visited = new boolean[graph.V()];

        from = new int[graph.V()];

        order = new int[graph.V()];

        for(int i = 0; i < graph.V(); i ++){
            visited[i] = false;
            from[i] = -1;
            order[i] = -1;
        }

        this.source = source;

        //无向图的最短路径，类似BST的层序遍历(重点)
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);//相当于add
        visited[source] = true;
        order[source] = 0;

        while (!q.isEmpty()){
            int v = q.poll();//出队列
            for(Integer i:graph.adj(v)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    from[i] = v;
                    order[i] = order[v]+1;
                }
            }
        }
    }

    /**
     * 起点到w之间是否联通
     */
    public boolean hasPathTo(int w){
        assert(w>=0&&w<graph.V());
        return visited[w];
    }

    /**
     * 获取source到w的路径到vec中
     */
    public List<Integer> pathTo(int w){
        assert (hasPathTo(w));

        Stack<Integer> pathStack = new Stack<>();

        int pathPoint = w;

        while (pathPoint!=-1){
            pathStack.push(pathPoint);
            pathPoint = from[pathPoint];
        }
        List<Integer> vec = new ArrayList<>();
        while (!pathStack.empty()){
            vec.add(pathStack.pop());
        }
        return vec;
    }

    /**
     * 打印出source到w的路径
     */
    void showPath(int w) {
        assert (hasPathTo(w));
        List<Integer> vec = pathTo(w);
        for (int i = 0; i < vec.size(); ++i) {
            System.out.print(vec.get(i));
            if (i == vec.size() - 1) {
                // 到达最后一个元素打个回车就行了
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }

    /**
     * 查询source到w的最短路径的长度
     */
    public int length(int w) {
        // 保证w不越界
        assert (w >= 0 && w < graph.V());
        return order[w];
    }

}
