import java.util.*;
class Solution {
  
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int tempNode1 = wires[i][0];
            int tempNode2 = wires[i][1];
            // 전선 잘라
            wires[i][0] = 0;
            wires[i][1] = 0;
            // 전력망 노드 개수 차이 구해
            boolean[] visited = new boolean[n + 1];
            int count1 = dfs(tempNode1, wires, visited, n);
            int count2 = n - count1;
            min = Math.min(min, Math.abs(count1 - count2));
            // 전선 복구
            wires[i][0] = tempNode1;
            wires[i][1] = tempNode2;
        }
        return min;
    }
    
    public int dfs(int node, int[][] wires, boolean[] visited, int n) {
        visited[node] = true;
        int count = 1;
        for (int[] wire : wires) {
            if (wire[0] == node && !visited[wire[1]]) {
                count += dfs(wire[1], wires, visited, n);
            } else if (wire[1] == node && !visited[wire[0]]) {
                count += dfs(wire[0], wires, visited, n);
            }
        }
        return count;
    }
}

// for문 돌면서 전선 1개 잘라 -> dfs로 두 전력망 노드 개수 차이 구해 -> Min 갱신 -> min 리턴
