import binarySearchTree.BinarySearchTree;
import util.BinaryTreePrint;

public class Main {

    public static void main(String[] args) {
        BinaryTreePrint printer = new BinaryTreePrint();
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);

        printer.printTree(tree.getRoot());

        tree.rebalance();
        System.out.println("\n\n After Rebalance ------------------------------------");
        printer.printTree(tree.getRoot());


    }

}
