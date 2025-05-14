package PalindromeChecker;

import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        int mid = len / 2;

        // 1. 전반부 push
        for (int i = 0; i < mid; i++) {
            stack.push(s.charAt(i));
        }

        // 2. 홀수면 중간 문자 건너뛰기
        int start = (len % 2 == 0) ? mid : mid + 1;

        // 3. 후반부 pop과 비교
        for (int i = start; i < len; i++) {
            if (stack.pop() != s.charAt(i)) {
                return false;  // 다르면 회문 아님
            }
        }

        return stack.isEmpty();  // 전부 같으면 회문
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("noon"));    // true
        System.out.println(isPalindrome("hello"));   // false
    }
}

