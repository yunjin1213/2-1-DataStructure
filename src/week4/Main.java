// 자료구조(6065) 과제 #3 60241180 김윤진
package week4;

public class Main {
    public static void main(String[] args) {
        SList<String> s = new SList<>();
        s.insertFront("orange");
        s.insertFront("peach");
        s.insertFront("banana");
        s.addLast("apple");
        s.addLast("mango");
        s.addLast("grape");


        System.out.println("<< 자료구조(6065) 과제 #3 60241180 김윤진 >>");
        System.out.println("---------------------------------------");
        System.out.println();

        System.out.println("1> insertFront()로 orange/peach/banana & addLast()로 apple/mango/grape 추가 후 ");
        System.out.println(s);
        System.out.println();

        System.out.println("2> search('mango') = " + s.search("mango"));
    }
}
