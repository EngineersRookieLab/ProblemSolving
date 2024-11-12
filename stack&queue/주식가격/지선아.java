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
            Optional<int[]> first = queue.stream().filter(arr -> arr[0] < currentStock[0]).findFirst();
            int remainTime = prices.length - currentStock[1] - 1;
            if (first.isPresent()) {
                int[] drop = first.get();
                remainTime = drop[1] - currentStock[1];
            }
            remainTimes[currentStock[1]] = remainTime;
        }
        return remainTimes;
    }
}
