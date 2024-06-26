package raul.Model.noLineales.node;

public class Node<E> implements Cloneable {
    private E root;
    private Node<E> right;
    private Node<E> left;

    public Node(E root) {
        this.root = root;
        this.right = null;
        this.left = null;
    }

    public Node(E root, Node<E> right, Node<E> left) {
        this.root = root;
        this.right = right;
        this.left = left;
    }

    public Node() {
        this.root = null;
        this.right = null;
        this.left = null;
    }

    public E getRoot() {
        return root;
    }

    public void setRoot(E root) {
        this.root = root;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }
}
