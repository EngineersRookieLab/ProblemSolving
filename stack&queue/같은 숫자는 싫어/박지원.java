import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i : arr) {
            if (!stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
