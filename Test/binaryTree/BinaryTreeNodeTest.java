package binaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> node;
    @BeforeEach
    void setUp() {
        node = new BinaryTreeNode<>(69);
    }

    @Test
    void TestGetElementOnSetupNode() {
        int i = node.getElement();

        assertEquals(69, i);
    }

    @Test
    void TestSetElementInsertsRightElement(){
        int expected = 4;

        node.setElement(expected);
        int actual = node.getElement();

        assertEquals(expected, actual);

    }

    @Test
    void TestSetElementDoesNotThrow() {
        // Arrange
        int i = 5;
        //Act
        node.setElement(i);
        //Assert
        assertDoesNotThrow(()-> node.setElement(i));
    }

    @Test
    void TestAddLeftChildPutsElementInField() {
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>(2);

        node.addLeftChild(child);

        assertNotNull(node.getLeftChild());
    }

    @Test
    void TestAddLeftChildPutsRightElementInField(){
        int expected = 2;
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>(expected);
        //act
        node.addLeftChild(child);
        //Assert
        int actual = node.getLeftChild().getElement();
        assertEquals(expected, actual);
    }

    @Test
    void TestAddRightChildPutsElementInField() {
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>(2);

        node.addRightChild(child);

        assertNotNull(node.getRightChild());
    }

    @Test
    void TestAddRightChildPutsRightElementInField(){
        int expected = 2;
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>(expected);
        //act
        node.addRightChild(child);
        //Assert
        int actual = node.getRightChild().getElement();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetLeftChildWhenNull() {
        assertNull(node.getLeftChild());
    }

    @Test
    void TestGetRightChildWhenNull() {
        assertNull(node.getRightChild());
    }
}