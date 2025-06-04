// 자료구조(6065) 과제 #8 (60241180 김윤진)

package week9;

public class Chaining<K, V> {
    private int M = 23;
    private Node[] a = new Node[M];

    public static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object newKey, Object newData, Node ref) {
            key = newKey;
            value = newData;
            next = ref;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수 (음수되는거 방지함)
    }

    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (V) x.value;
            }
        }
        return null;
    }

    public void put(K key, V data) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = data;
                return;
            }
        }
        a[i] = new Node(key, data, a[i]);
    }

    public void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print(i + ": ");
            Node x = a[i];
            while (x != null) {
                System.out.print(x.key + " -> ");
                x = x.next;
            }
            System.out.println("null");
        }
    }
}
