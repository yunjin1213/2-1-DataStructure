//자료구조(6065) 과제 #6 (60241180 김윤진)
package week7;

public class Node<Key extends Comparable<Key>, Value> {
    Key id;
    Value name;
    int height;
    Node left, right;

    public Node(Key newId, Value newName, int newHt) {
        id = newId;
        name = newName;
        height = newHt;
        left = right = null;
    }
}
