import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int index = 0;
        int time = 0;
        int answer = 0;
        int done = 0;
        while(done < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index++]);
            }
            
            if(pq.isEmpty()) {
                time = jobs[index][0];
                continue;
            }
            
            int[] current = pq.poll();
            time += current[1];
            answer += time - current[0];
            done++;
        }
        
        return answer / jobs.length;
    }
}
