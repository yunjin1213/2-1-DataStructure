// 자료구조(6065) 과제 #4 60241180 김윤진
package week5;

import java.util.Scanner;

public class PostfixCalculator {

    public static int evaluatePostfix(String exp) {
        ListStack<Integer> stack = new ListStack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                int num = Integer.parseInt(String.valueOf(ch));
                stack.push(num);
            } else {
                int b = stack.pop();
                int a = stack.pop();

                int result = 0;
                switch (ch) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("자료구조(6065) 과제 #4 60241180 김윤진");
        System.out.print("후위 표기 수식을 입력하세요 (예: 23*54+9-): ");
        String input = sc.nextLine();
        int result = evaluatePostfix(input);

        System.out.println("계산 결과: " + result);
        sc.close();
    }
}