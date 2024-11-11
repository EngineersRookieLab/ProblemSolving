import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int[] arr = new int[]{i, priorities[i]};
            queue.offer(arr);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current_priority = poll[1];
            // 꺼냈는데 큐에 이거보다 더 높은 우선순위가 있으면 다시 넣어
            boolean isLow = queue.stream().anyMatch(arr -> arr[1] > current_priority);
            if (isLow) {
                queue.offer(poll);
                continue;
            }
            count += 1;
            if (poll[0] == location) {
                break;
            }
        }
        return count;
    }
}
