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

        public Node(Node node) {
            // key是唯一地，不能重复
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
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

    /**
     * 寻找最小的键值
     */
    public Key min(){
        Node minNode = min(root);
        return minNode.key;
    }

    private Node min(Node node) {
        if(node.left==null){
            return node;
        }
        return min(node.left);
    }

    /**
     * 寻找最大的键值
     */
    public Key max() {
        assert (count != 0);
        Node maxNode = max(root);
        return maxNode.key;
    }

    private Node max(Node node) {
        if(node.right==null){
            return node;
        }
        return min(node.right);
    }

    /**
     * 删除最大值对应的节点
     */
    public void deleteMax(){
        if(root!=null){
            root = deleteMax(root);
        }
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            // 没有右节点了，就要看看左节点是否存在
            Node leftNode = node.left;
            node.left = null;
            count--;
            // 不管rightNode是否为空，都可以直接返回地
            return leftNode;
        }
        // 好好体验递归
        node.right = deleteMax(node.right);
        return node;
    }

    /**
     * 删除最小值对应的节点
     */
    public void deleteMin(){
        if (root!=null){
            root = deleteMin(root);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            // 没有左节点了，当前节点就是最小节点，就要看看右节点是否存在
            Node rightNode = node.right;
            node.right = null;
            count--;
            // 不管rightNode是否为空，都可以直接返回，这个节点就是新的根节点
            return rightNode;
        }
        // 好好体验递归
        node.left = deleteMin(node.left);
        return node;
    }

    public void deleteNode(Key key){
        root = deleteNode(root,key);
    }

    private Node deleteNode(Node node, Key key) {
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)>0){
            node.right = deleteNode(node.right,key);
            return node;
        }else if(key.compareTo(node.key)<0){
            node.left = deleteNode(node.left,key);
            return node;
        }else {  //key == node.key
            if(node.left==null){
                // 左子树为空，看右子树，删除节点后，所有右子树节点前提一位
                Node rightNode = node.right;
                node = null;
                count--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node = null;
                count--;
                return leftNode;
            }
            //左右子树都不为空
            Node successor = new Node(min(node.right));
            // 这里++，在下面的deleteMin会--
            count++;
            successor.right = deleteMin(node.right);
            successor.left = node.left;
            node = null;
            count -- ;
            return successor;
        }
    }

    /**
     * 寻找key的floor值，递归算法，不存在返回null
     */
    public Key floor(Key key){
        if(count==0||key.compareTo(min())<0){
            return null;
        }
        Node floorNode = floor(root,key);
        return floorNode.key;
    }

    private Node floor(Node node, Key key) {
        if(node==null){
            return null;
        }

        if(node.key == key){
            return node;
        }

        if(node.key.compareTo(key)>0){
            return floor(node.left,key);
        }

        if(node.key.compareTo(key)<0){
            return floor(node.right,key);
        }

        // 如果node.key < key，则node可能是key的floor节点，也有可能不是，因为node的右子树中可能还存在比node.key
        // 大但是小于key的其余节点),需要尝试着在node的右子树中寻找一下
        Node tmpNode = floor(node.right,key);
        if(tmpNode!=null){
            return tmpNode;
        }
        return node;
    }

    public Key ceil(Key key){
        if(count==0||key.compareTo(max())>0){
            return null;
        }
        Node ceilNode = ceil(root,key);
        return ceilNode.key;
    }

    private Node ceil(Node node, Key key) {
        if(node == null){
            return null;
        }
        if(node.key==key){
            return node;
        }
        if(node.key.compareTo(key)<0){
            return ceil(node.right,key);
        }
        if (node.key.compareTo(key)>0){
            return ceil(node.left,key);
        }
        // 如果node->key > key，则node可能是key的ceil节点，也有可能不是，因为node的左子树中可能还存在比node-key
        // 小但是大于key的其余节点),需要尝试着在node的左子树中寻找一下
        Node tmpNode = ceil(node.left,key);
        if(tmpNode!=null){
            return tmpNode;
        }
        return node;
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

//        System.out.println("test removemin:");
//        while (!bst.isEmpty()){
//            System.out.print("min: "+bst.min()+",");
//            bst.deleteMin();
//            System.out.println("after removemin,size = "+bst.size());
//        }
//        System.out.println();

        // 输出的元素应该是从大到小排列的
        System.out.println("Test removeMax: ");
        while (!bst.isEmpty()) {
            System.out.print("max: " + bst.max() + " , ");
            bst.deleteMax();
            System.out.println("After removeMax, size = " + bst.size());
        }

        System.out.println("Test removeNode:");
        for(int i = 0; i < 10; i ++){
            bst.insert(i,i);
        }
        System.out.println(bst.size());
        bst.deleteNode(5);
        System.out.println(bst.size());

    }
}
