import java.util.Stack;

class Solution {
    private static final String open = "(";
    private static final String close = ")";

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == close.charAt(0) && stack.peek() == open.charAt(0)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

