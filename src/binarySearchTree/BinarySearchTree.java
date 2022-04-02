package binarySearchTree;

import binaryTree.BinaryTree;
import binaryTree.BinaryTreeNode;

import javax.swing.*;
import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {


    public BinarySearchTree() {
        super();
    }

    public <E> boolean insert(E element){
        insertRec(getRoot(),element);
        sizeInc();
        return true;
    }

    private <E> BinaryTreeNode<E> insertRec(BinaryTreeNode<E> node, E element){
        if (getRoot() == null) {
            node = new BinarySearchNode(element);
            setRoot(node);
            return node;
        }
        if (node == null) {
            node = new BinarySearchNode(element);
            return node;
        }
        if ((int)element < (int)node.getElement())
            node.addLeftChild(insertRec(node.getLeftChild(), element));
        if ((int)element >= (int)node.getElement())
            node.addRightChild(insertRec(node.getRightChild(), element));

        return node;
    }




    public <E> boolean removeElement(E element){
        if (!contains(element))
            return false;
        removeElement(getRoot(),(int)element);
        sizeDec();
        return true;
    }

    private <E> BinaryTreeNode<E> removeElement(BinaryTreeNode<E> node, int element){
        if (node == null){return null;}
        if (element < (int)node.getElement()){
            node.addLeftChild(removeElement(node.getLeftChild(),element));
        }else if (element > (int)node.getElement()){
            node.addRightChild(removeElement(node.getRightChild(),element));
        } else {
            if (node.getLeftChild() == null && node.getRightChild() == null){
                node = null;
            } else if (node.getLeftChild() != null && node.getRightChild() != null){
                if (node == getRoot()){
                    BinaryTreeNode pre = preNode(node);
                    node = successorNode(node);
                    node.addLeftChild(pre);
                    setRoot(node);
                } else {
                    BinaryTreeNode pre = preNode(node);
                    node = successorNode(node);
                    node.addLeftChild(pre);
                }
            } else {
                if (node.getRightChild() == null) {
                    return node.getLeftChild();
                } else if (node.getLeftChild() == null){
                    return node.getRightChild();
                }
            }
        }


        return node;
    }

    private <E> BinaryTreeNode<E> successorNode(BinaryTreeNode<E> node){
        BinaryTreeNode child = node.getRightChild();
        while (child.getLeftChild() != null){
            child = child.getLeftChild();
        }
        return child;
    }

    private <E> BinaryTreeNode<E> preNode(BinaryTreeNode<E> node){
        return node.getLeftChild();
    }

    public <E> E findMin(){
        BinaryTreeNode<E> node = findMin(getRoot());
        return node.getElement();
    }

    private <E> BinaryTreeNode<E> findMin(BinaryTreeNode<E> node){
        while (node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node;
    }

    public <E> E findMax(){
        BinaryTreeNode<E> node = findMax(getRoot());
        return node.getElement();
    }

    private <E> BinaryTreeNode<E> findMax(BinaryTreeNode node){
        while (node.getRightChild() != null){
            node = node.getRightChild();
        }
        return node;
    }


    public void rebalance(){
        ArrayList<Integer> list = inOrder();
        ArrayList<BinaryTreeNode> nodes = new ArrayList<>();
        for (Integer integer : list) {
            nodes.add(new BinarySearchNode(integer));
        }
        setRoot(rebalance(nodes,0, list.size()-1));

    }

    private <E> BinaryTreeNode rebalance(ArrayList<BinaryTreeNode> elements, int start, int end){
        if (start > end){
            return null;
        }
        int median =  (start + end) / 2;

        BinaryTreeNode<E> root = elements.get(median);

        root.addLeftChild(rebalance(elements,start,median -1));
        root.addRightChild(rebalance(elements, median + 1, end));
        return root;
    }



}
