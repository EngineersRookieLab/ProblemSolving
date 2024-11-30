import java.util.Stack;

/**
"최적의 숫자 조합을 만든다" → 탐욕적으로 처리
"숫자를 제거한다" → 직전 값과 비교하며 처리 필요

직전 숫자를 빠르게 비교하고 제거해야 한다면 → 스택 활용
*/
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();

        for (int i = 0; i < len; i++) {
            char digit = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }

        return sb.toString();
    }
}

