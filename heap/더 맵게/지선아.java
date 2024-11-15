import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        int count = 0;;
        while(pq.size() >= 2) {
            if (pq.peek() >= K) {
                return count;
            }
            count += 1;
            int food1 = pq.poll();
            int food2 = pq.poll();
            int newFood = food1 + 2 * food2;
            pq.offer(newFood);
            if (pq.peek() >= K) {
                return count;
            }
        }
        return -1;
    }
}
