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
