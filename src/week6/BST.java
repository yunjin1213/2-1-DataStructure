//자료구조(6065) 과제 #5 (60241180 김윤진)
package week6;

public class BST<Key extends Comparable<Key>, Value> {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public BST(Key newId, Value newName) {
        root = new Node(newId, newName);
    }

    public Value get(Key k) {
        return get(root, k);
    }

    public Value get(Node n, Key k) {
        if (n == null) return null;

        int t = n.getKey().compareTo(k);

        if (t > 0) {
            return get(n.getLeft(), k);
        } else if (t < 0) {
            return get(n.getRight(), k);
        } else {
            return (Value) n.getValue();
        }
    }

    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    public Node put(Node n, Key k, Value v) {
        if (n == null) {
            return new Node(k, v);
        }

        int t = n.getKey().compareTo(k);

        if (t > 0) {
            n.setLeft(put(n.getLeft(), k, v));
        } else if (t < 0) {
            n.setRight(put(n.getRight(), k, v));
        } else {
            n.setValue(v);
        }
        return n;
    }

    public Key min() {
        if (root == null) {
            return null;
        }
        return (Key) min(root).getKey();
    }

    public Node min(Node n) {
        if (n.getLeft() == null) {
            return n;
        }
        return min(n.getLeft());
    }

    public void deleteMin() {
        if (root == null) {
            System.out.println("empty 트리");
        }
        root = deleteMin(root);
    }

    public Node deleteMin(Node n) {
        if (n.getLeft() == null) {
            return n.getRight();
        }
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    public void delete(Key k) {
        root = delete(root, k);
    }

    public Node delete(Node n, Key k) {
        if (n == null) return null;

        int t = n.getKey().compareTo(k);
        if (t > 0) {
            n.setLeft(delete(n.getLeft(), k));
        } else if (t < 0) {
            n.setRight(delete(n.getRight(), k));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();

            Node target = n;
            n = min(target.getRight());
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }
        return n;
    }

    public Key max() {
        if (root == null) {
            return null;
        }
        return (Key) max(root).getKey();
    }

    private Node max(Node n) {
        if (n.getRight() == null) return n;
        return max(n.getRight());
    }

    public void deleteMax() {
        if (root == null) {
            System.out.println("empty 트리");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node n) {
        if (n.getRight() == null) {
            return n.getLeft();
        }
        n.setRight(deleteMax(n.getRight()));
        return n;
    }
}