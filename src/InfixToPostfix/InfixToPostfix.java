package InfixToPostfix;

import java.util.Stack;

public class InfixToPostfix {
    public static String convert(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // 1. 피연산자 → 바로 출력
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            }
            // 2. 왼쪽 괄호 → 스택에 push
            else if (ch == '(') {
                stack.push(ch);
            }
            // 3. 오른쪽 괄호 → '(' 나올 때까지 pop → 출력
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // 왼쪽 괄호 제거
            }
            // 4. 연산자 → 우선순위 확인하고 pop or push
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 5. 남은 연산자 전부 pop
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    // 연산자 우선순위 정의
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // 테스트용 메인 함수
    public static void main(String[] args) {
        String infix = "A*(B+C)/D";
        System.out.println("후위표기식: " + convert(infix));  // ABC+*D/
    }
}

