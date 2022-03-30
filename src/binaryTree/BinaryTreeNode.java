package binaryTree;

public class BinaryTreeNode<E> {
    private E element;
    private BinaryTreeNode<E> leftChild, rightChild;

    public BinaryTreeNode(E element){
        this.element = element;
    }

    public void setElement(E element){
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public E getElement(){
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> leftChild) {
        if (this.leftChild == null)
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode<E> rightChild) {
        if (this.rightChild == null)
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }
}
