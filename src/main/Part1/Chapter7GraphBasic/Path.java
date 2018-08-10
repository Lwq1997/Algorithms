package main.Part1.Chapter7GraphBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Lwq
 * @create 2018-08-09 18:35
 * @desc 寻找起点s到所有其他顶点的路径
 **/
public class Path {
    private Graph graph;

    //起始点
    private int source;

    private boolean[] visited;

    //from[i]  表示访问的i节点是从哪个节点过来的
    private int[] from;

    private void dfs(int v){
        visited[v] = true;
        //遍历领接点
        for(Integer i:graph.adj(v)){
            if(!visited[i]){
                from[i] = v;
                dfs(i);
            }
        }
    }

    public Path(Graph graph,int source) {
        this.graph = graph;
        // 确保source在合适的范围内
        assert (source >= 0 && source < graph.V());

        visited = new boolean[graph.V()];
        from = new int[graph.V()];

        for(int i = 0; i <graph.V() ; i++){
            visited[i] = false;
            from[i] = -1;
        }

        this.source = source;
        //从source开始遍历
        dfs(source);

    }

    /**
     * 起点source到点w之间是否有路径存在
     */
    public boolean hasPathTo(int w){
        // 保证w不越界
        assert (w >= 0 && w < graph.V());
        return visited[w];
    }

    /**
     * 获取source到w的路径到vec中
     */
    public List<Integer> pathTo(int w){
        assert (hasPathTo(w));
        // 因为路径是倒推地，所以先压入栈中，然后再弹出到vector中顺序就正常了
        Stack<Integer> pathStack = new Stack<>();
        // 路径上的点初始化
        int pathPoint = w;
        while (pathPoint!=-1){
            pathStack.push(pathPoint);
            pathPoint = from[pathPoint];
        }
        List<Integer> vec = new ArrayList<>();
        while (!pathStack.isEmpty()){
            vec.add(pathStack.pop());
        }
        return vec;
    }

    /**
     * 打印处source到w的路径
     */
    public void showPath(int w){
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
}
