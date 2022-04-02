package binarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchNodeTest {

    @Test
    void compareTo() {
        BinarySearchNode<Integer> node = new BinarySearchNode(10);

        assertEquals(10, node.getElement());

    }
}