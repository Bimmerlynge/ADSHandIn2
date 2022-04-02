package binarySearchTree;

import binaryTree.BinaryTreeNode;

public class BinarySearchNode<E> extends BinaryTreeNode<E> implements Comparable  {


    public BinarySearchNode(E element) {
        super(element);

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
