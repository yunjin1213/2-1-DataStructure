// 자료구조(6065) 과제 #4 60241180 김윤진
package week5;

public class Node<E> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setItem(E newItem) {
        item = newItem;
    }

    public void seNext(Node<E> newNext) {
        next = newNext;
    }
}