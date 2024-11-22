import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return pq.peek();
    }

    public void dfs(int currentK, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentK >= dungeons[i][0]) {
                visited[i] = true;
                dfs(currentK - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        pq.offer(count);
    }
}
