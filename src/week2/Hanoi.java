package week2;

// 자료구조(6065) 과제 1 60241180 김윤진
public class Hanoi {

    public static void hanoi(int numDisks, char source, char auxiliary, char destination) {
        if (numDisks == 1) {
            System.out.println("Move Disk 1 from " + source + " to " + destination);
            return;
        }
        hanoi(numDisks - 1, source, destination, auxiliary);
        System.out.println("Move Disk " + numDisks + " from " + source + " to " + destination);
        hanoi(numDisks - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        System.out.println("자료구조(6065) 과제 1 60241180 김윤진");

        System.out.println("\nn = 3일 경우:");
        System.out.println("(원반 이름 크기가 작은 -> 큰 순서 : 1 - 2 - 3)");
        hanoi(3, 'A', 'B', 'C');

        System.out.println("\nn = 4일 경우:");
        System.out.println("(원반 이름 크기가 작은 -> 큰 순서 : 1 - 2 - 3 - 4)");
        hanoi(4, 'A', 'B', 'C');
    }

}
