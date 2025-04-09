//자료구조(6065) 과제1 (60241180 김윤진)
package week2;

public class Hanoi {

    public static void move(int n, char from, char left, char to) {
        if (n == 1) {
            System.out.println("Move Disk 1 " + from + " to " + to);
            return;
        }
        move(n - 1, from, to, left);

        System.out.println("Move Disk " + n + " " + from + " to " + to);

        move(n - 1, left, from, to);
    }

    public static void main(String[] args) {
        int n = 3;
        int j = 4;

        System.out.println("원반이 3개인 경우");
        System.out.println("(원반 이름 크기가 작은 -> 큰 순서 : 1 - 2 - 3)");
        move(n, 'A', 'B', 'C');

        System.out.println();

        System.out.println("원반이 4개인 경우");
        System.out.println("(원반 이름 크기가 작은 -> 큰 순서 : 1 - 2 - 3 - 4)");
        move(j, 'A', 'B', 'C');

    }

}
