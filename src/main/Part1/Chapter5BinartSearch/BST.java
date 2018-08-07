package main.Part1.Chapter5BinartSearch;

import java.util.LinkedList;

/**
 * @author Lwq
 * @create 2018-08-07 17:37
 * @desc  二分搜索树
 **/
public class BST <Key extends Comparable<Key>, Value>{
    /**
     * 内部节点类
     */
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;

        Node(Key key,Value value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void insert(Key key,Value value){
        root = insert(root,key,value);
    }

    /**
     * 向以node为根节点的二叉树搜索树种，插入节点(key,value)
     * 返回插入新节点后的二叉搜索树的根
     */
    private Node insert(Node node, Key key, Value value) {
        if(node == null){
            count++;//没有节点
            return new Node(key,value);
        }
        //新加的节点小于根节点
        if (key.compareTo(node.key)<0){
            node.left = insert(node.left,key,value);
        }else if (key.compareTo(node.key)>0){
            node.right = insert(node.right,key,value);
        }else {
            node.value = value;
        }
        return node;
    }
    
    public boolean contaion(Key key){
        return contaion(root,key);
    }

    private boolean contaion(Node node, Key key) {
        if(node==null){
            return false;
        }
        if(key.compareTo(node.key)>0){
            return contaion(node.right,key);
        }else if(key.compareTo(node.key)<0){
            return contaion(node.left,key);
        }else {
            return true;
        }
    }
    
    public Value search(Key key){
        return search(root,key);
    }

    private Value search(Node node, Key key) {
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)>0){
            return search(node.right,key);
        }else if (key.compareTo(node.key)<0){
            return search(node.left,key);
        }else {
            return node.value;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key+"-->");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 对以node为根的二叉搜索树进行中序遍历
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key+"-->");
            inOrder(node.right);
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 对以node为根的二叉搜索树进行后序遍历
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key+"-->");
        }
    }

    //层序遍历
    public void levelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.key+"-->");
            if(node.left!=null){
                queue.push(node.left);
            }
            if(node.right!=null){
                queue.push(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = (int) (Math.random() * M);
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder 中序排序可用于排序(升序)
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder  后序遍历可用于释放二叉搜索树
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

        // 层序遍历
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();
    }
}
