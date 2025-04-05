// 자료구조(6065) 과제 #2 60241180 김윤진
package week3;

import java.util.NoSuchElementException;

public class ArrList<E> {
    private E a[];
    private int size;


    public ArrList() {
        a = (E[]) new Object[1];
        size = 0;
    }

    public E peek(int k) {
        if (isEmpty())
            throw new NoSuchElementException();
        return a[k];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertLast(E newItem) {
        if (size == a.length)
            resize(2 * a.length);
        a[size++] = newItem;
    }

    public void insert(E newItem, int k) {
        if (size == a.length)
            resize(2 * a.length);
        for (int i = size - 1; i >= k; i--)
            a[i + 1] = a[i];
        a[k] = newItem;
        size++;
    }

    public E delete(int k) {
        if (isEmpty())
            throw new NoSuchElementException();
        E item = a[k];

        for (int i = k; i < size - 1; i++)
            a[i] = a[i + 1];
        a[size - 1] = null;
        size--;

        if (size > 0 && size == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int find(E item) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(item))
                return i;
        }
        return -1;
    }

    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(item))
                return true;
        }
        return false;
    }

    public void clear() {
        a = (E[]) new Object[1];
        size = 0;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            E temp = a[i];
            a[i] = a[size - 1 - i];
            a[size - 1 - i] = temp;
        }
    }

    public void removeDuplicates() {
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            while (j < size) {
                if (a[i].equals(a[j])) {
                    delete(j);
                } else {
                    j++;
                }
            }
        }
    }

    public void rotateRight(int k) {
        if (size == 0 || k % size == 0) return;
        k = k % size;

        for (int r = 0; r < k; r++) {
            E last = a[size - 1];
            for (int i = size - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = last;
        }
    }

    public void set(int index, E item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        a[index] = item;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(a[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();

    }

    private void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < size; i++)
            t[i] = a[i];
        a = (E[]) t;
    }
}