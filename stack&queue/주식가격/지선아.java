import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<int[]> queue = new LinkedList<>();
        int[] remainTimes = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            queue.add(new int[] {prices[i], i});
        }
        while (!queue.isEmpty()) {
            int[] currentStock = queue.poll();
            int remainTime = prices.length - currentStock[1] - 1;
            for (int i = currentStock[1] + 1; i < prices.length; i++) {
                if (prices[i] < currentStock[0]) {
                    remainTime = i- currentStock[1];
                    break;
                }
            }
            remainTimes[currentStock[1]] = remainTime;
        }
        return remainTimes;
    }

}

// stack 활용
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
       int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 스택에는 가격이 떨어지지 않은 인덱스만 저장해!!!
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - index - 1;
        }
        return answer;
    }

}
