// 자료구조(6065) 과제 #3 60241180 김윤진
package week4;

public class Main {
    public static void main(String[] args) {
        SList<String> s = new SList<>();


        System.out.println("<< 자료구조(6065) 과제 #3 60241180 김윤진 >>");
        System.out.println("---------------------------------------");
        System.out.println();

        System.out.println("1> insertFront()로 orange/peach/banana & addLast()로 apple/mango/grape 추가 후 ");
        s.insertFront("orange");
        s.insertFront("peach");
        s.insertFront("banana");
        s.addLast("apple");
        s.addLast("mango");
        s.addLast("grape");
        System.out.println(s);
        System.out.println();

        System.out.println("2> search(\"mango\") = " + s.search("mango"));
        System.out.println("3> mango 뒤에 blueberry 삽입 - getNode()와 insertAfter() 이용");
        Node mangoNode = s.getNode(s.search("mango"));
        s.insertAfter("blueberry", mangoNode);
        System.out.println(s);
        System.out.println();

        System.out.println("4> search(\"orange\") = " + s.search("orange"));
        System.out.println("5> orange 노드 위치에 strawberry 삽입 - add() 이용");
        s.add("strawberry", 2);
        System.out.println(s);
        System.out.println();

        System.out.println("6> search(\"apple\") = " + s.search("apple"));
        System.out.println("7> apple 뒤의 노드를 삭제 - getNode()와 deleteAfter() 이용");
        Node appleNode = s.getNode(s.search("apple"));
        s.deleteAfter(appleNode);
        System.out.println(s);
        System.out.println();

        System.out.println("9> peach 항목 삭제 - deleteItem() 이용");
        s.deleteItem("peach");
        System.out.println(s);
        System.out.println();

        System.out.println("10> index 3 항목 삭제 - delete() 이용");
        s.delete(3);
        System.out.println(s);
        System.out.println();

        System.out.println("11> 맨 앞의 원소 3개 제거 - deleteFront() 이용");

        for (int i = 0; i < 3; i++) {
            s.deleteFront();
        }
        System.out.println(s);

    }
}
