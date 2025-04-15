// 자료구조(6065) 과제 #4 60241180 김윤진
package week5;

import java.util.Scanner;

public class CheckParentheses {

    public static boolean isValid(String input) {
        ListStack<Character> stack = new ListStack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;

                char open = stack.pop();

                if ((ch == ')' && open != '(') ||
                        (ch == '}' && open != '{') ||
                        (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("자료구조(6065) 과제 #4 60241180 김윤진");
        Scanner sc = new Scanner(System.in);
        System.out.print("수식을 입력하세요: ");
        String input = sc.nextLine();

        if (isValid(input)) {
            System.out.println("올바른 괄호입니다.");
        } else {
            System.out.println("올바르지 않은 괄호입니다.");
        }
    }
}
