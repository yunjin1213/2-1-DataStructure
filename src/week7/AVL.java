//자료구조(6065) 과제 #6 (60241180 김윤진)
package week7;

public class AVL<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    private Node rotateRight(Node n) {
        Node x = n.left;
        n.left = x.right;
        x.right = n;

        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node n) {
        Node x = n.right;
        n.right = x.left;
        x.left = n;

        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }

    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    private Node put(Node n, Key k, Value v) {
        if (n == null) return new Node(k, v, 1);

        int t = k.compareTo((Key) n.id);
        if (t < 0) n.left = put(n.left, k, v);
        else if (t > 0) n.right = put(n.right, k, v);
        else {
            n.name = v;
            return n;
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;

        return balance(n);
    }

    private Node balance(Node n) {
        int balance = bf(n);
        if (balance > 1) {
            if (bf(n.left) < 0) {
                System.out.println("LR 회전이 발생한 키: " + n.id + ", bf: " + balance);
                n.left = rotateLeft(n.left);
                return rotateRight(n);
            } else {
                System.out.println("LL 회전이 발생한 키: " + n.id + ", bf: " + balance);
                return rotateRight(n);
            }
        } else if (balance < -1) {
            if (bf(n.right) > 0) {
                System.out.println("RL 회전이 발생한 키: " + n.id + ", bf: " + balance);
                n.right = rotateRight(n.right);
                return rotateLeft(n);
            } else {
                System.out.println("RR 회전이 발생한 키: " + n.id + ", bf: " + balance);
                return rotateLeft(n);
            }
        }
        return n;
    }

    private int bf(Node n) {
        return height(n.left) - height(n.right);
    }

    private int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    private int tallerHeight(int x, int y) {
        if (x > y) return x;
        else return y;
    }

    public void delete(Key k) {
        root = delete(root, k);
    }

    private Node delete(Node n, Key k) {
        if (n == null) return null;
        int t = k.compareTo((Key) n.id);

        if (t < 0) n.left = delete(n.left, k);
        else if (t > 0) n.right = delete(n.right, k);
        else {
            if (n.left == null) return n.right;
            else if (n.right == null) return n.left;
            else {
                Node target = n;
                n = min(target.right);
                n.right = deleteMin(target.right);
                n.left = target.left;
            }
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n);
    }

    public void deleteMin() {
        if (root == null) System.out.println("empty 트리");

        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if (n.left == null) return n.right;
        n.left = deleteMin(n.left);
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;

        return balance(n);
    }

    public Key min() {
        if (root == null) return null;
        return (Key) min(root).id;
    }

    private Node min(Node n) {
        if (n.left == null) return n;
        return min(n.left);
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(Node<Key, Value> n) {
        if (n == null) return;
        System.out.println("Key: " + n.id + ", Value: " + n.name + ", Height: " + n.height);
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node<Key, Value> n) {
        if (n == null) return;
        printInOrder(n.left);
        System.out.println("Key: " + n.id + ", Value: " + n.name + ", Height: " + n.height);
        printInOrder(n.right);
    }

    public Value get(Key k) {
        return get(root, k);
    }

    private Value get(Node<Key, Value> n, Key k) {
        if (n == null) return null;
        int cmp = k.compareTo(n.id);
        if (cmp < 0) return (Value) get(n.left, k);
        else if (cmp > 0) return (Value) get(n.right, k);
        else return n.name;
    }
}

