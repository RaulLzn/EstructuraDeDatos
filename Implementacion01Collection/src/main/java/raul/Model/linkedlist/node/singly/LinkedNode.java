package raul.Model.linkedlist.node.singly;

import raul.Model.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E> {

        private LinkedNode<E> next;

        public LinkedNode() {
            super();
            this.next = null;
        }

        public LinkedNode(E element) {
            super(element);
            this.next = null;
        }

        public LinkedNode(E element, LinkedNode<E> next) {
            super(element);
            this.next = next;
        }

        public void setNext(LinkedNode<E> next) {
            this.next = next;
        }

        public LinkedNode<E> getNext() {
            return next;
        }

        @Override
        public LinkedNode<E> clone() {
            return new LinkedNode<>(element, next);
        }

        @Override
        public String toString() {
            return element.toString();
        }
}
