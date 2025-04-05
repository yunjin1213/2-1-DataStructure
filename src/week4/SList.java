// 자료구조(6065) 과제 #3 60241180 김윤진
package week4;

import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {

    protected Node head; // 연결 리스트의 첫 노드 가리킴
    private int size;

    public SList() { // 연결 리스트 생성자
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node p = head;
        for (int k = 0; k < size; k++) {
            if (target.equals(p.getItem())) return k;
            p = p.getNext();
        }
        return -1;
    }

    public void insertFront(E NewItem) {
        head = new Node(NewItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) throw new NoSuchElementException();

        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public Node<E> getNode(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p;
    }

    public void add(E newItem, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            insertFront(newItem);
        } else {
            Node p = getNode(index - 1);
            insertAfter(newItem, p);
        }
    }

    public void addLast(E newItem) {
        if (size == 0) {
            insertFront(newItem);
        } else {
            Node p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(new Node(newItem, null));
            size++;
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            deleteFront();
        } else {
            Node p = getNode(index - 1);
            deleteAfter(p);
        }
    }

    public void deleteItem(E item) {
        if (isEmpty()) throw new NoSuchElementException();
        if (head.getItem().equals(item)) {
            deleteFront();
        } else {
            Node p = head;
            while (p.getNext() != null && !p.getNext().getItem().equals(item)) {
                p = p.getNext();
            }
            if (p.getNext() != null) {
                deleteAfter(p);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("항목수(").append(size).append("): ");

        Node p = head;
        while (p != null) {
            sb.append(p.getItem());
            if (p.getNext() != null) {
                sb.append(" ");
            }
            p = p.getNext();
        }

        return sb.toString();
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
