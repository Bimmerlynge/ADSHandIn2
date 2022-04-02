package binarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BinaryTreePrint;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    BinarySearchTree tree;
    BinaryTreePrint printer;
    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree();
        printer = new BinaryTreePrint();
    }

    @Test
    void TestInsertFirstValueInsertsIntoRoot() {
        tree.insert(69);
        assertFalse(tree.isEmpty());
    }

    @Test
    void TestInsertFirstRightValue(){
        tree.insert(42);
        assertEquals(42,tree.getRoot().getElement());
    }

    @Test
    void TestInsertValueLowerThanRootIsLeftChild(){
        tree.insert(69);
        tree.insert(42);

        assertEquals(42, tree.getRoot().getLeftChild().getElement());
    }
    @Test
    void TestInsert(){
        tree.insert(69);
        tree.insert(40);
        tree.insert(46);
        tree.insert(32);
        tree.insert(45);
        tree.insert(80);

        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree(tree.getRoot());
    }

    @Test
    void TestRemoveLeafElement(){
        tree.insert(69);
        tree.insert(40);

        tree.insert(80);
        tree.insert(100);
        tree.insert(85);
        tree.insert(82);
        tree.insert(81);
        tree.insert(83);


        assertTrue(tree.contains(40));
        tree.removeElement(40);
        assertFalse(tree.contains(40));
    }

    @Test
    void TestRemoveElementWithOneChild(){
        tree.insert(69);
        tree.insert(40);

        tree.insert(80);
        tree.insert(100);
        tree.insert(85);
        tree.insert(82);
        tree.insert(81);
        tree.insert(83);


        assertTrue(tree.contains(100));
        tree.removeElement(100);
        assertFalse(tree.contains(100));
    }

    @Test
    void TestRemoveElementWithTwoChildren(){
        tree.insert(69);
        tree.insert(40);

        tree.insert(80);
        tree.insert(100);
        tree.insert(85);
        tree.insert(82);
        tree.insert(81);
        tree.insert(83);


        assertTrue(tree.contains(69));
        tree.removeElement(69);
        assertFalse(tree.contains(69));
    }

    @Test
    void TestFindMin(){
        tree.insert(69);
        tree.insert(40);

        tree.insert(21);
        tree.insert(35);
        tree.insert(16);
        tree.insert(23);
        tree.insert(6);
        tree.insert(20);

        assertEquals(6, (int)tree.findMin());

    }

    @Test
    void TestFindMax(){
        tree.insert(69);
        tree.insert(40);

        tree.insert(21);
        tree.insert(35);
        tree.insert(120);
        tree.insert(119);
        tree.insert(122);

        assertEquals(122, (int)tree.findMax());
    }


    @Test
    void Height(){
        tree.insert(69);
        tree.insert(20);
        tree.insert(19);
        System.out.println("Height: " + tree.height());
    }

    @Test
    void Rebalance(){
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);

        printer.printTree(tree.getRoot());

        tree.rebalance();

        printer.printTree(tree.getRoot());
    }
}