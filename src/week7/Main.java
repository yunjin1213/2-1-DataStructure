//자료구조(6065) 과제 #6 (60241180 김윤진)
package week7;

public class Main {
    public static void main(String[] args) {
        System.out.println("자료구조(6065) 과제 #6 (60241180 김윤진)");

        AVL<Integer, String> tree = new AVL<>();
        Object[][] items = {
                {30, "Apple"}, {15, "Banana"}, {40, "Melon"}, {10, "Orange"},
                {25, "Tangerine"}, {22, "Kiwi"}, {20, "Grape"}, {50, "Strawberry"},
                {17, "Cherry"}, {19, "Mango"}
        };

        System.out.println("[삽입 과정]");
        for (Object[] item : items) {
            Integer key = (Integer) item[0];
            String val = (String) item[1];
            System.out.println("삽입: " + key + ", " + val);
            tree.put(key, val);
        }

        System.out.println("\n[삽입 후 전위순회]");
        tree.printPreOrder();

        System.out.println("\n[삽입 후 중위순회]");
        tree.printInOrder();

        System.out.println("\n[특정 키 값 조회]");
        printKey(tree, 15);
        printKey(tree, 50);
        printKey(tree, 33);

        System.out.println("\n[삭제 과정]");
        int[] delKeys = {15, 10, 50, 25};
        for (int key : delKeys) {
            System.out.println("삭제: " + key);
            tree.delete(key);
        }

        System.out.println("\n[삭제 후 전위순회]");
        tree.printPreOrder();

        System.out.println("\n[삭제 후 중위순회]");
        tree.printInOrder();
    }

    private static void printKey(AVL<Integer, String> tree, int key) {
        String value = tree.get(key);
        if (value != null) {
            System.out.println("Key: " + key + " → Value: " + value);
        } else {
            System.out.println("Key: " + key + " → 존재하지 않음");
        }
    }
}

