import java.util.*;

class Solution {
 public int solution(int n, int[] lost, int[] reserve) {
PriorityQueue<Integer> l_pq = new PriorityQueue<>();
        PriorityQueue<Integer> r_pq = new PriorityQueue<>();

        for (int i = 0; i < lost.length; i++) {
            l_pq.add(lost[i]);
        }
        for (int i = 0; i < reserve.length; i++) {
            r_pq.add(reserve[i]);
        }
        // 교집합 제거
        PriorityQueue<Integer> intersection = new PriorityQueue<>(l_pq);
        intersection.retainAll(r_pq);
        l_pq.removeAll(intersection);
        r_pq.removeAll(intersection);
     
        int count = l_pq.size();
        while(!l_pq.isEmpty()) {
            int l = l_pq.poll();
            if (r_pq.contains(l)) {
                while (!r_pq.isEmpty() && r_pq.peek().equals(l)) {
                    r_pq.poll();
                }
                count--;
                continue;
            }
            if (r_pq.contains(l-1)) {
                while (!r_pq.isEmpty() && r_pq.peek().equals(l-1)) {
                    r_pq.poll();
                }
                count--;
                continue;
            }
            if (r_pq.contains(l+1)) {
                while (!r_pq.isEmpty() && r_pq.peek().equals(l+1)) {
                    r_pq.poll();
                }
                count--;
            }
        }
        return n - count;
    }
}
