//자료구조(6065) 과제 #5 (60241180 김윤진)
package week6;

public class Main {
    public static void main(String[] args) {

        BST<Integer, String> tree = new BST<>(50, "Apple");

        tree.put(60, "Banana");
        tree.put(20, "Melon");
        tree.put(10, "Orange");
        tree.put(40, "Tangerine");
        tree.put(25, "Kiwi");
        tree.put(15, "Grape");
        tree.put(80, "Strawberry");
        tree.put(70, "Cherry");
        tree.put(35, "Lemon");

        System.out.println("//자료구조(6065) 과제 #5 (60241180 김윤진)");
        System.out.println("1. 키와 값 10개 삽입 후 >>");
        printTraversalAndHeight(tree);

        tree.put(40, "Mango");
        System.out.println("\n키(40)의 값 = " + tree.get(40));
        System.out.println("키(80)의 값 = " + tree.get(80));
        System.out.println("키(77)의 값 = " + tree.get(77));
        System.out.println("최소 키값 = " + tree.min());
        System.out.println("최대 키값 = " + tree.max());

        tree.delete(15);
        tree.delete(35);
        System.out.println("\n2. 15, 35 삭제 후 >>");
        printTraversalAndHeight(tree);

        tree.deleteMin();
        System.out.println("\n3. 최소 키 삭제 후 >>");
        printTraversalAndHeight(tree);

        tree.deleteMax();
        System.out.println("\n4. 최대 키 삭제 후 >>");
        printTraversalAndHeight(tree);
    }

    public static void printTraversalAndHeight(BST<Integer, String> tree) {
        System.out.print("inorder: ");
        inorder(tree.getRoot());
        System.out.println();

        System.out.print("preorder: ");
        preorder(tree.getRoot());
        System.out.println();

        System.out.println("높이 = " + height(tree.getRoot()));
    }

    public static void inorder(Node<Integer, String> n) {
        if (n == null) return;
        inorder(n.getLeft());
        System.out.print(n.getKey() + " ");
        inorder(n.getRight());
    }

    public static void preorder(Node<Integer, String> n) {
        if (n == null) return;
        System.out.print(n.getKey() + " ");
        preorder(n.getLeft());
        preorder(n.getRight());
    }

    public static int height(Node<Integer, String> n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }
}

