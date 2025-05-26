//자료구조(6065) 과제 #7 (60241180 김윤진)

package week8;

import java.util.HashMap;

public class BHeap<Key extends Comparable<Key>, Value> {
    private Entry[] a;

    public Entry getEntry(int i) {
        return a[i];
    }

    private int N;
    private HashMap<Key, Integer> position = new HashMap<>();

    public BHeap(Entry[] harry, int initialSize) {
        a = harry;
        N = initialSize;

        for (int i = 1; i < N; i++) {
            position.put((Key) a[i].getKey(), i);
        }
    }

    public int size() {
        return N;
    }

    private boolean greater(int i, int j) {
        return a[j].getKey().compareTo(a[i].getKey()) < 0;
    }

    private void swap(int i, int j) {
        Entry temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        position.put((Key) a[i].getKey(), i);
        position.put((Key) a[j].getKey(), j);
    }

    public void creatHeap() {
        for (int i = N / 2; i > 0; i--) {
            downheap(i);
        }
    }

    private void downheap(int i) {
        while (2 * i <= N) {
            int k = 2 * i;
            if (k < N && greater(k, k + 1)) k++;
            if (!greater(i, k)) break;
            swap(i, k);
            i = k;
        }
    }

    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey, newValue);
        a[++N] = temp;
        position.put(newKey, N);
        upheap(N);
    }

    private void upheap(int j) {
        while (j > 1 && greater(j / 2, j)) {
            swap(j / 2, j);
            j = j / 2;
        }
    }

    public Entry deleteMin() {
        Entry min = a[1];
        swap(1, N--);
        downheap(1);
        return min;
    }

    public void delete(Key key) {
        if (!position.containsKey(key)) return;

        int i = position.get(key);
        swap(i, N);
        position.remove(key);
        a[N--] = null;

        if (i <= N) {
            downheap(i);
            upheap(i);
        }
    }

    public void decreaseKey(Key key, Key newKey) {
        if (!position.containsKey(key)) return;

        int i = position.get(key);
        a[i].setKey(newKey);
        position.remove(key);
        position.put(newKey, i);
        upheap(i);
    }

}
