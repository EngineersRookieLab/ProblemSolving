class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
         
        return answer;
    }
    
    public void dfs(int node, int[][] computers) {
        visited[node] = true;
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i, computers);
            }
            
        }
    }
}
