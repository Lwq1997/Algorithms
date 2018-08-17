package main.Part1;

import main.Part2.ArrayQueue;
import main.Part2.Queue;

/**
 * @author etouch
 * @create 2018-08-17 11:24
 * @desc 二叉树的深度
 **/
public class treeDepth<K>{

//    这个可以使用递归，分别求出左子树的深度、右子树的深度，两个深度的较大值+1即可。
    public static int getMaxDepth(Node root) {
        if (root == null) {
            return 0;
        }else {
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            return 1+Math.max(left,right);
        }
    }

//    使用队列，层次遍历二叉树。在上一层遍历完成后，
// 下一层的所有节点已经放到队列中，此时队列中的元素个数就是下一层的宽度。
// 以此类推，依次遍历下一层即可求出二叉树的最大宽度。
    public static int getMaxWidth(Node root){
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new ArrayQueue<>();
        int maxWidth = 1;
        queue.enqueue(root);
        while (true){
            int len = queue.getSize();   //当前层的节点个数
            if(len==0){
                break;
            }
            while (len>0){   // 如果当前层，还有节点
                Node t = queue.dequeue();
                len--;
                if (len == 0)
                    break;
                if(t.left!=null){
                    queue.enqueue(t.left);
                }
                if(t.right!=null){
                    queue.enqueue(t.right);
                }
            }
            maxWidth = Math.max(maxWidth,queue.getSize());
        }
        return maxWidth;
    }
}

class Node<K>{
    K k;
    Node left = null;
    Node right = null;

    public Node(K k, Node left, Node right) {
        this.k = k;
        this.left = left;
        this.right = right;
    }

    public Node(K k) {
        this.k = k;
    }
}
