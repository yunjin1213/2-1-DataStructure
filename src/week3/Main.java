// 자료구조(6065) 과제 #2 60241180 김윤진
package week3;

public class Main {
    public static void main(String[] args) {
        ArrList<Integer> s = new ArrList<>();

        s.insertLast(10);
        s.insertLast(20);
        s.insertLast(30);
        s.insertLast(20);
        s.insertLast(40);
        s.insertLast(30);
        s.insertLast(50);
        s.insertLast(70);
        s.insertLast(50);

        System.out.println("//자료구조(6065) 과제 #2 60241180 김윤진");
        System.out.println("초기 리스트: " + s);
        System.out.println();

        s.removeDuplicates();
        System.out.println("removeDuplicates() 후: " + s);

        s.reverse();
        System.out.println("reverse() 후: " + s);

        s.rotateRight(2);
        System.out.println("rotateRight(2) 후: " + s);

        s.set(3, 100);
        System.out.println("set(3, 100) 후:" + s);
        System.out.println();

        System.out.println("find(40): " + s.find(40));
        System.out.println("contains(50): " + s.contains(50));

        s.clear();
        System.out.println("clear() 후: " + s);
    }
}
