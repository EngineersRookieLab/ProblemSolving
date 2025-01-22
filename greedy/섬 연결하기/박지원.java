import java.util.*;

class Solution {
    
    int[] parent;
    
    static class Node {
        int v1;
        int v2;
        int cost;
        
        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
    
    public int find(int v) {
        if(parent[v] == v) {
            return parent[v];
        }
        
        return parent[v] = find(parent[v]);
    }
    
    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        parent[parentB] = parentA;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        ArrayList<Node> islands = new ArrayList<>();
        for(int[] cost : costs) {
            islands.add(new Node(cost[0], cost[1], cost[2]));
        }
        Collections.sort(islands, (n1, n2) -> {
            return n1.cost - n2.cost;
        });
        
        for(Node node : islands) {
            int findA = find(node.v1);
            int findB = find(node.v2);
            if(findA != findB) {
                union(findA, findB);
                answer += node.cost;
            }
        }
        
        return answer;
    }
}
