package raul.bintree;

import raul.node.Node;

public class BinTree<E> {

    private Node<E> root;

    public String preOrder(){
        String temp = null;
        return temp;

    }
    public void preOrderRun(Node<E> node, String temp) {
        if (node != null) {
            temp += node.getRoot();
            preOrderRun(node.getLeft(), temp);
            preOrderRun(node.getRight(), temp);
        }
    }

    public Linked

}
