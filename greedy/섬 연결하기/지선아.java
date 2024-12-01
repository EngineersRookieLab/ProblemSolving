import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        // 노드와 간선 그래프 구성
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] cost : costs) {
            graph.get(cost[0]).add(new int[] {cost[1], cost[2]});
            graph.get(cost[1]).add(new int[] {cost[0], cost[2]});
        }
        // prim 알고리즘
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n];
        int startNode = costs[0][0]; // 임의의 노드로 시작
        pq.add(new int[]{startNode, 0}); 
        
        int totalCost = 0;
        int connectedNodes = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];
            
            if (visited[node]) continue;
            
            visited[node] = true;
            totalCost += cost;
            connectedNodes++;
            
            if (connectedNodes == n) break;
            
            for (int[] con : graph.get(node)) {
                if (!visited[con[0]]) {
                    pq.add(con);
                }
            }
        }
        return totalCost;
    }
}
