// 자료구조(6065) 과제 #3 60241180 김윤진
package week4;

public class Node<E extends Comparable<E>> {
    private E item;
    private Node<E> next;

    // 생성자
    public Node(E newItem, Node<E> p) {
        this.item = newItem;
        this.next = p;
    }

    // get 메서드와 set 메서드
    public E getItem() {
        return item;
    }

    public void setItem(E newItem) {
        item = newItem;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> n) {
        next = n;
    }
}