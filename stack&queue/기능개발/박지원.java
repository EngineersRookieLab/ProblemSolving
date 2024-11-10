import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain % speeds[i] == 0) ? (remain / speeds[i]) : (remain / speeds[i] + 1);
            queue.offer(day);
        }
        
        while(!queue.isEmpty()) {
            int frist = queue.poll();
            int count = 1;
            while(!queue.isEmpty()) {
                if(queue.peek() > frist)
                    break;
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
