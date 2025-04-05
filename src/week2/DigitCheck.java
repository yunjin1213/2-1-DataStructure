package week2;// 자료구조(6065) 과제 1 60241180 김윤진

import java.util.Scanner;

public class DigitCheck {

    static int digitCheckSum(int n) {
        if (n < 0) {
            n = -n;
        }
        if (n == 0) {
            return 0;
        }
        return (n % 10) + digitCheckSum(n / 10);
    }

    static int digitCheckCount(int n) {
        if (n < 0) {
            n = -n;
        }
        if (n / 10 == 0) {
            return 1;
        }
        
        return 1 + digitCheckCount(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("자료구조(6065) 과제 1 60241180 김윤진");
        System.out.print("정수를 입력 해 주세요: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("자릿수 합: " + digitCheckSum(n));
        System.out.println("자릿수 개수: " + digitCheckCount(n));
    }
}