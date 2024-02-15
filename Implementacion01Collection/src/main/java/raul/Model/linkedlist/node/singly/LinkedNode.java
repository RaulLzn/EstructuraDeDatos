package raul.Model.linkedlist.node.singly;

import raul.Model.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E>{
    private LinkedNode<E> next;

    public LinkedNode(LinkedNode<E> next) {
        this.next = next;
    }

    public LinkedNode(E element, LinkedNode<E> next) {
        super(element);
        this.next = next;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }


}
