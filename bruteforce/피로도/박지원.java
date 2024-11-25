import java.util.*;
class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int result, int k, int[][] dg) {
        for (int i = 0 ; i < dg.length; i++) {
            if(visited[i] || dg[i][0] > k) continue;
            visited[i] = true;
            dfs(result + 1, k - dg[i][1], dg);
            visited[i] = false;
        }
        answer = Math.max(result, answer);
    }
}
