import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                return -1;
            }
            int food1 = pq.poll();
            int food2 = pq.poll();
            int mixed = food1 + (food2 * 2);
            pq.offer(mixed);
            answer++;
        }
        return answer;
    }
}
