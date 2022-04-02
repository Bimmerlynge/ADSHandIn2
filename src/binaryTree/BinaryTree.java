package binaryTree;


import stack.LinkedStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void sizeInc(){
        size++;
    }

    public void sizeDec(){size--;}

    public int size(){return size;}

    public <E> boolean contains(E element){
        return contains(root, element);
    }


    public <E> ArrayList<E> inOrder(){
        if (root == null) {return null;}
        ArrayList<E> toReturn = new ArrayList<>();
        visitInOrderIterative(root, toReturn);

        return toReturn;
    }

    private <E> void visitInOrderRecursive(BinaryTreeNode<E> node, ArrayList<E> list){
        if (node == null) {return;}

        visitInOrderRecursive(node.getLeftChild(), list);
        list.add(node.getElement());
        visitInOrderRecursive(node.getRightChild(), list);
    }

    private <E> void visitInOrderIterative(BinaryTreeNode<E> node, ArrayList<E> list){
        LinkedStack<BinaryTreeNode<E>> stack = new LinkedStack<>();
        BinaryTreeNode<E> buffer = node;
        while (true){
            while(buffer != null){
                stack.push(buffer);
                buffer = buffer.getLeftChild();
            }
            if (stack.isEmpty())
                return;
            buffer = stack.pop();
            list.add(buffer.getElement());
            buffer = buffer.getRightChild();
        }
    }

    public <E> ArrayList<E> preOrder(){
        if (root == null) {return null;}
        ArrayList<E> toReturn = new ArrayList<>();
        visitPreOrderIterative(root, toReturn);
        return toReturn;
    }

    private <E> void visitPreOrderRecursive(BinaryTreeNode<E> node, ArrayList<E> list){
        if (node == null){return;}
        list.add(node.getElement());
        visitPreOrderRecursive(node.getLeftChild(),list);
        visitPreOrderRecursive(node.getRightChild(),list);
    }

    private <E> void visitPreOrderIterative(BinaryTreeNode<E> node, ArrayList<E> list){
        LinkedStack<BinaryTreeNode<E>> stack = new LinkedStack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            BinaryTreeNode<E> currentNode = stack.pop();
            list.add(currentNode.getElement());

            if (currentNode.getRightChild() != null)
                stack.push(currentNode.getRightChild());
            if (currentNode.getLeftChild() != null)
                stack.push(currentNode.getLeftChild());
        }
    }

    public <E> ArrayList<E> postOrder(){
        if (root == null){return null;}
        ArrayList<E> list = new ArrayList<>();
        visitPostOrderRecursive(root, list);
        return list;
    }

    private <E> void visitPostOrderRecursive(BinaryTreeNode<E> node, ArrayList<E> list){
        if (node == null){return;}

        visitPostOrderRecursive(node.getLeftChild(), list);
        visitPostOrderRecursive(node.getRightChild(),list);
        list.add(node.getElement());
    }

    private <E> void visitPostOrderIterative(BinaryTreeNode<E> node, ArrayList<E> list){
        LinkedStack<BinaryTreeNode<E>> stack = new LinkedStack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            BinaryTreeNode<E> current = stack.peek();
            if (current.getLeftChild() ==null && current.getRightChild() == null){

            }
        }
    }

    public <E> ArrayList<E> levelOrder(){
        if (root == null){return null;}
        ArrayList<E> list = new ArrayList<>();
        visitLevelOrderIterative(root,list);
        return list;
    }

    private <E> void visitLevelOrderIterative(BinaryTreeNode<E> node, ArrayList<E> list){
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            BinaryTreeNode<E> buffer = queue.poll();
            list.add(buffer.getElement());
            if (buffer.getLeftChild() != null)
                queue.add(buffer.getLeftChild());
            if (buffer.getRightChild() != null)
                queue.add(buffer.getRightChild());
        }
    }

    private <E> void visitLevelOrderRecursive(BinaryTreeNode<E> node, ArrayList<E> list){
        if (node == null){return;}
        if (node == root)
            list.add(node.getElement());
        if (node.getLeftChild() != null)
            list.add(node.getLeftChild().getElement());
        if (node.getRightChild() != null)
            list.add(node.getRightChild().getElement());
        visitLevelOrderRecursive(node.getLeftChild(),list);
        visitLevelOrderRecursive(node.getRightChild(),list);
    }

    public int height(){
        if (root == null){return -1;}
        return height(root)-1;
    }

    private <E> int height(BinaryTreeNode<E> node){
        if (node == null){return 0;}
        int leftHeight = height(node.getLeftChild());
        int rightHeight = height(node.getRightChild());
        return leftHeight > rightHeight ? leftHeight +1 : rightHeight + 1;
    }


    private <E> boolean contains(BinaryTreeNode node, E element){
        if (node == null) {return false;}
        boolean thisNode = node.getElement() == element;
        return thisNode || contains(node.getLeftChild(), element) || contains(node.getRightChild(), element);
    }

    private int size(BinaryTreeNode node){
        if (node == null) {return 0;}
        return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
    }
}
