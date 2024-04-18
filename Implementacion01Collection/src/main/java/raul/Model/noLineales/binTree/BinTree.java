package raul.Model.noLineales.binTree;

import raul.Model.Stack.list.Stack;
import raul.Model.linkedlist.doubly.circular.LinkedList;
import raul.Model.noLineales.node.Node;
import raul.Model.queue.list.Queue;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinTree<E> {

    private Node<E> root;

    public BinTree() {
        this.root = null;
    }

    public BinTree(E element) {
        this.root = new Node<E>(element);
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * Metodo para recorrer el arbol en preOrden
     * @return Lista con los elementos del arbol en preOrden
     */
    public LinkedList<E> preOrder() {
        LinkedList<E> list = new LinkedList<>();
        preOrderRoot(root, list);
        return list;
    }

    /**
     * Metodo para recorrer el arbol en preOrden
     * @param node Nodo raiz
     * @param list Lista con los elementos del arbol en preOrden
     */
    private void preOrderRoot(Node<E> node, LinkedList<E> list) {
        if (node != null) {
            list.add(node.getRoot());
            preOrderRoot(node.getLeft(), list);
            preOrderRoot(node.getRight(), list);
        }
    }

    //inOrder
    /**
     * Metodo para recorrer el arbol en inOrder
     * @return Lista con los elementos del arbol en inOrder
     */
    public LinkedList<E> InOrder() {
        LinkedList<E> list = new LinkedList<>();
        inOrderRoot(root, list);
        return list;
    }

    /**
     * Metodo para recorrer el arbol en inOrder
     * @param node Nodo raiz
     * @param list Lista con los elementos del arbol en inOrder
     */

    private void inOrderRoot(Node<E> node, LinkedList<E> list) {
        if (node != null) {
            inOrderRoot(node.getLeft(), list);
            list.add(node.getRoot());
            inOrderRoot(node.getRight(), list);
        }
    }

    /**
     * Metodo para recorrer el arbol en postOrden
     * @return Lista con los elementos del arbol en postOrden
     */
    public LinkedList<E> postOrder() {
        LinkedList<E> list = new LinkedList<>();
        try {
            postOrderRoot(root, list);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return list;
    }

    /**
     * Metodo para recorrer el arbol en postOrden
     * @param node Nodo raiz
     * @param list Lista con los elementos del arbol en postOrden
     */
    private void postOrderRoot(Node<E> node, LinkedList<E> list) {
        try {
            if (node != null) {
                postOrderRoot(node.getLeft(), list);
                postOrderRoot(node.getRight(), list);
                list.add(node.getRoot());
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
    }

    /**
     * Metodo para recorrer el arbol en nivel
     * @return Lista con los elementos del arbol en nivel
     */
    public LinkedList<E> levelOrder() {
        LinkedList<E> list = new LinkedList<>();
        Queue<Node<E>> queue = new Queue<>();
        queue.insert(root);
        while (!queue.isEmpty()) {
            Node<E> current = queue.extract();
            list.add(current.getRoot());
            if (current.getLeft() != null) {
                queue.insert(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.insert(current.getRight());
            }
        }
        return list;
    }

    /**
     * Metodo para recorrer el arbol en profundidad
     * @return Lista con los elementos del arbol en profundidad
     */
    public LinkedList<E> depthSearch() {
        LinkedList<E> list = new LinkedList<>();
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        depthSearch(stack, list);
        return list;
    }

    /**
     * Metodo para recorrer el arbol en profundidad
     * @param nodes Cola de nodos
     * @param list Lista con los elementos del arbol en profundidad
     */
    private void depthSearch(Stack<Node<E>> nodes, LinkedList<E> list) {
        if (!nodes.isEmpty()) {
            Node<E> node = nodes.pop();
            list.add(node.getRoot());
            if (node.getRight() != null) {
                nodes.push(node.getRight());
            }
            if (node.getLeft() != null) {
                nodes.push(node.getLeft());
            }
            depthSearch(nodes, list);
        }
    }

    //height of the tree
    /**
     * Metodo para obtener la altura del arbol
     * @return Altura del arbol
     */
    public int height() {
        int height = 0;
        Queue<Node<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        height = countHeight(auxiliar);
        return height;
    }

    /**
     * Metodo para obtener la altura del arbol
     * @param nodes Cola de nodos
     * @return Altura del arbol
     */
    private int countHeight(Queue<Node<E>> nodes) {
        int height = 0;
        if (!nodes.isEmpty()) {
            Queue<Node<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                Node<E> node = nodes.extract();
                if (node.getLeft() != null) {
                    auxiliar.insert(node.getLeft());
                }
                if (node.getRight() != null) {
                    auxiliar.insert(node.getRight());
                }
            }
            height++;
            height += countHeight(auxiliar);
        }
        return height;
    }

    //Saber si el arbol es completo
    /**
     * Metodo para saber si el arbol es completo
     * @return True si el arbol es completo, false en caso contrario
     */
    public boolean isComplete() {
        return isComplete(root);
    }

    /**
     * Metodo para saber si el arbol es completo
     * @param node Nodo raiz
     * @return True si el arbol es completo, false en caso contrario
     */
    private boolean isComplete(Node<E> node) {
        if (node == null) {
            return true;
        }
        int branchCount = branchCount(node);
        if (branchCount == -1) {
            return false;
        }
        return isComplete(node.getLeft()) && isComplete(node.getRight());
    }

    /**
     * Metodo para contar las ramas de un nodo
     * @param node Nodo
     * @return Cantidad de ramas
     */
    private int branchCount(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() != null && node.getRight() != null) {
            return 2; // Ambas ramas presentes
        } else if (node.getLeft() != null) {
            return 1; // Solo rama izquierda presente
        } else if (node.getRight() != null) {
            return -1; // Solo rama derecha presente
        } else {
            return 0; // Sin ramas presentes
        }
    }

    /**
     * Metodo para insertar un nodo en el arbol
     * @param element Elemento a insertar
     */
    public void depthInsert(E element) {
        if (root == null) {
            root = new Node<>(element);
        } else {
            Queue<Node<E>> auxiliar = new Queue<>();
            auxiliar.insert(root);
            depthInsert(element, auxiliar);
        }
    }

    /**
     * Metodo para insertar un nodo en el arbol
     * @param element Elemento a insertar
     * @param nodes Cola de nodos
     */
    private void depthInsert(E element, Queue<Node<E>> nodes) {
        if (!nodes.isEmpty()) {
            Queue<Node<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                Node<E> node = nodes.extract();
                if (node.getLeft() == null) {
                    node.setLeft(new Node<>(element));
                    return;
                } else {
                    auxiliar.insert(node.getLeft());
                }
                if (node.getRight() == null) {
                    node.setRight(new Node<>(element));
                    return;
                } else {
                    auxiliar.insert(node.getRight());
                }
            }
            depthInsert(element, auxiliar);
        }
    }

    /**
     * Metodo para eliminar un nodo del arbol
     * @param element Elemento a eliminar
     */
    public void delete(E element) {
        Queue<Node<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        delete(element, auxiliar);
    }

    /**
     * Metodo para eliminar un nodo del arbol
     * @param element Elemento a eliminar
     * @param nodes Cola de nodos
     */
    private void delete(E element, Queue<Node<E>> nodes) {
        if (!nodes.isEmpty()) {
            Queue<Node<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                Node<E> node = nodes.extract();
                if (node.getLeft() != null) {
                    if (node.getLeft().getRoot().equals(element)) {
                        node.setLeft(null);
                        return;
                    } else {
                        auxiliar.insert(node.getLeft());
                    }
                }
                if (node.getRight() != null) {
                    if (node.getRight().getRoot().equals(element)) {
                        node.setRight(null);
                        return;
                    } else {
                        auxiliar.insert(node.getRight());
                    }
                }
            }
            delete(element, auxiliar);
        }
    }


}
