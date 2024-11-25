import java.util.*;
class Solution {
    int[][] graph;
    public int solution(int n, int[][] wires) {
        // 초기화
        graph = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        int answer = n;
        for (int[] wire : wires) {
            // 전선 끊음
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;

            // 계산
            boolean[] visited = new boolean[n + 1];
            int group1 = dfs(1, visited);
            int group2 = n - group1;
            answer = Math.min(answer, Math.abs(group1 - group2));

            // 전선 복원
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        return answer;
    }

    public int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        // 탐색
        for (int next = 1; next < graph.length; next++) {
            if (graph[node][next] == 1 && !visited[next]) {
                // 연결 된 것 중에 방문 안한 노드
                count += dfs(next, visited);
            }
        }

        return count;
    }
}

