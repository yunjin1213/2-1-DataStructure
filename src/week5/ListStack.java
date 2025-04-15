// 자료구조(6065) 과제 #4 60241180 김윤진
package week5;

import java.util.EmptyStackException;

public class ListStack<E> {
    private Node<E> top;
    private int size;

    public ListStack() {
        top = null;
        size = 0;
    }

    // 스택 top 항목만을 리턴
    public E peek() {

        if (isEmpty())
            throw new EmptyStackException();

        return top.getItem();
    }


    public boolean isEmpty() {
        return size == 0;
    }

    // 스택의 항목의 수를 리턴
    public int size() {
        return size;
    }

    public void push(E newItem) {
        Node newNode = new Node(newItem, top);

        top = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();

        E topItem = top.getItem();
        top = top.getNext();
        size--;

        return topItem;
    }

}
