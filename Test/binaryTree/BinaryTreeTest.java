package binaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BinaryTreePrint;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree tree;
    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
    }

    @Test
    void TestGetRootIsNullOnInit() {
        assertNull(tree.getRoot());
    }

    @Test
    void TestSetRootInsertsNode(){
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(42);

        tree.setRoot(node);

        assertNotNull(tree.getRoot());
    }

    @Test
    void TestSetRootInsertsRightNode(){
        int expectedVal = 42;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(expectedVal);

        tree.setRoot(node);
        int root = (int)tree.getRoot().getElement();

        assertEquals(root, expectedVal);
    }

    @Test
    void TestIsEmptyOnInit(){
        assertTrue(tree.isEmpty());
    }

    @Test
    void TestIsEmptyFalseAfterFirstInsert(){
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(42);
        tree.setRoot(node);

        assertFalse(tree.isEmpty());
    }

    @Test
    void TestSizeIsZeroOnInit(){
        assertEquals(0,tree.size());
    }

    @Test
    void TestSizeIncreaseByOne(){
        int before = tree.size();
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(42);
        tree.setRoot(node);
        int after = tree.size();
        assertEquals(before +1, after);
    }

    @Test
    void TestSizeIncreaseByTwo(){
        int before = tree.size();
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(42);
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
        node.addLeftChild(leftChild);
        tree.setRoot(node);
        int after = tree.size();

        assertEquals(before + 2, after);

    }

    @Test
    void TestSizeIncreaseBy6(){
        int before = tree.size();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(42);
        BinaryTreeNode<Integer> lChild1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rChild1 = new BinaryTreeNode<>(3);
        root.addLeftChild(lChild1);
        root.addRightChild(rChild1);
        BinaryTreeNode<Integer> lChild2 = new BinaryTreeNode<>(4);
        lChild1.addLeftChild(lChild2);
        BinaryTreeNode<Integer> rChild3 = new BinaryTreeNode<>(7);
        lChild2.addRightChild(rChild3);

        tree.setRoot(root);
        int after = tree.size();
        assertEquals(before+5, after);
    }

    @Test
    void TestContainsElementIfExpected(){
        createATree();
        assertTrue(tree.contains(4));
    }

    @Test
    void TestInOrderTraversal(){
        createATree();
        ArrayList<Integer> actual = tree.inOrder();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );

        assertEquals(expected, actual);
    }

    @Test
    void TestPreOrderTraversal(){
        createATree();
        ArrayList<Integer> actual = tree.preOrder();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(4,2,1,3,5)
        );
        assertEquals(expected, actual);
    }

    @Test
    void TestPostOrderTraversal(){
        createATree();
        ArrayList<Integer> actual = tree.postOrder();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(1,3,2,5,4)
        );
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelOrderTraversal(){
        createATree();
        ArrayList<Integer> actual = tree.levelOrder();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(4,2,5,1,3)
        );
        assertEquals(expected, actual);
    }

    @Test
    void TestHeightOnEmptyTree(){
        assertEquals(-1,tree.height());
    }

    @Test
    void TestHeightOnRootOnly(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        tree.setRoot(root);

        assertEquals(0, tree.height());
    }

    @Test
    void TestHeightOnTreeWithChild(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(2);
        root.addLeftChild(l1);
        tree.setRoot(root);

        assertEquals(1,tree.height());
    }


    private void createATree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> l2 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> r2 = new BinaryTreeNode<>(3);
        root.addLeftChild(l1);
        l1.addLeftChild(l2);
        l1.addRightChild(r2);
        root.addRightChild(r1);
        tree.setRoot(root);
    }


}