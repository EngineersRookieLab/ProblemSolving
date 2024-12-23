class Solution {
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                count++;
            }
        }
        return count;
    }
     
    private void dfs(int index, int n, int[][] computers) {
        visited[index] = true;
        for (int i = 0; i < n; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(i, n, computers);
            }
        }
    }
}
