package raul.Model.noLineales.binTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import raul.Model.linkedlist.doubly.circular.LinkedList;
import raul.Model.noLineales.node.Node;
import raul.Model.util.Iterator.Iterator;

public class BinTreeTest {

    private BinTree<Integer> tree;

    @BeforeEach
    public void setUp() {
        /*
                  1
                /   \
               2     3
              / \   /
             4   5 6
        */
        tree = new BinTree<>(1);
        Node<Integer> root = tree.getRoot();
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));
        root.getLeft().setLeft(new Node<>(4));
        root.getLeft().setRight(new Node<>(5));
        root.getRight().setLeft(new Node<>(6));
    }

    @Test
    public void testPreOrder() {
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        expected.add(6);

        LinkedList<Integer> actual = tree.preOrder();
        compareLinkedLists(expected, actual);
    }

    @Test
    public void testInOrder() {
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(4);
        expected.add(2);
        expected.add(5);
        expected.add(1);
        expected.add(6);
        expected.add(3);

        LinkedList<Integer> actual = tree.InOrder();
        compareLinkedLists(expected, actual);
    }

    @Test
    public void testPostOrder() {
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(4);
        expected.add(5);
        expected.add(2);
        expected.add(6);
        expected.add(3);
        expected.add(1);

        LinkedList<Integer> actual = tree.postOrder();
        compareLinkedLists(expected, actual);
    }

    @Test
    public void testLevelOrder() {
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);

        LinkedList<Integer> actual = tree.levelOrder();
        compareLinkedLists(expected, actual);
    }

    @Test
    public void testDepthSearch() {
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        expected.add(6);

        LinkedList<Integer> actual = tree.depthSearch();
        compareLinkedLists(expected, actual);
    }

    @Test
    public void testHeight() {
        Assertions.assertEquals(3, tree.height());
    }

    @Test
    public void testIsComplete() {
        Assertions.assertTrue(tree.isComplete());
    }

    @Test
    public void testDepthInsert() {
        tree.depthInsert(7);
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        expected.add(6);
        expected.add(7);

        LinkedList<Integer> actual = tree.preOrder();
        compareLinkedLists(expected, actual);
    }

    @Test
    public void testDelete() {
        tree.delete(1); // Eliminar el elemento 1
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        expected.add(6);

        LinkedList<Integer> actual = tree.preOrder();
        compareLinkedLists(expected, actual);
    }


    // Método para comparar dos LinkedList utilizando iteradores
    private void compareLinkedLists(LinkedList<Integer> expected, LinkedList<Integer> actual) {
        Iterator<Integer> expectedIterator = expected.iterator();
        Iterator<Integer> actualIterator = actual.iterator();

        while (expectedIterator.hasNext() && actualIterator.hasNext()) {
            Integer expectedValue = expectedIterator.next();
            Integer actualValue = actualIterator.next();
            Assertions.assertEquals(expectedValue, actualValue);
        }

        Assertions.assertFalse(expectedIterator.hasNext(), "La lista esperada tiene más elementos de lo esperado");
        Assertions.assertFalse(actualIterator.hasNext(), "La lista actual tiene más elementos de lo esperado");
    }
}
