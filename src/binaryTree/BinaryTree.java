package binaryTree;


public class BinaryTree {
    private BinaryTreeNode root;
    private int size;

    public BinaryTree(){
        size = 0;
    }

    public BinaryTreeNode getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode node){
        root = node;
        size = size(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size;
    }

    private int size(BinaryTreeNode node){
        if (node == null) {return 0;}
        return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
    }
}
