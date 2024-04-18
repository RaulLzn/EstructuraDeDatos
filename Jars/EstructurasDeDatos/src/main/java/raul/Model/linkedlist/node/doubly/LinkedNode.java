package raul.Model.linkedlist.node.doubly;

import raul.Model.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E>{

    LinkedNode<E> next;
    LinkedNode<E> previous;

    public LinkedNode() {
        this.next = null;
        this.previous = null;
    }

    public LinkedNode( E element, LinkedNode<E> next, LinkedNode<E> previous) {
        super(element);
        this.next = next;
        this.previous = previous;
    }

    public LinkedNode(E element) {
        super(element);
        this.next = null;
        this.previous = null;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }

    public LinkedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode<E> previous) {
        this.previous = previous;
    }

}
