import java.util.*; 

class Solution {
    public int solution(int[][] jobs) {
        // int[]{작업 소요 시간, 작업 요청 시각, 작업 번호}
        // 작업 소요 시간 -> 작업 요청 시각 -> 작업 번호
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()         {
            @Override
            public int compare(int[] a, int [] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[2], b[2]);
                }
            }
        });
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        int currentTime = 0;
        int sum = 0;
        int jobIndex = 0;
        int completedJobCount = 0;
        while (completedJobCount < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.offer(new int[] { jobs[jobIndex][1], jobs[jobIndex][0], jobIndex});
                jobIndex++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime += job[0];
                sum += currentTime - job[1];
                completedJobCount += 1;
            } else {
                currentTime = jobs[jobIndex][0];
            }   
        }
        return sum / jobs.length;
    }
           
}
