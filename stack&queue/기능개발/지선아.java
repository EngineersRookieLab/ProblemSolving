import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
                Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remains = ((100 - progresses[i]) % speeds[i]);
            int days = ((100 - progresses[i]) / speeds[i]);
            if (remains != 0) {
                days += 1;
            }
            queue.offer(days);
        }
        int current = 0;
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            count = 0;
            current = queue.poll();
            count+=1;
            while(!queue.isEmpty() && current >= queue.peek()) {
                queue.poll();
                count+=1;
            }
            answer.add(count);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

