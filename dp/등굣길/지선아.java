class Solution {
    private static final int NUM = 1000000007;
    int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m][n];
        // 초기값 설정
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        // 웅덩이 설정
        for (int[] puddle : puddles) {
            dp[puddle[0] - 1][puddle[1] - 1] = 0;
        }
        dp[0][0] = 1;
        return dfs(m-1, n-1);
    }

    public int dfs(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = (dfs(x - 1, y) + dfs(x, y-1)) % NUM;
        return dp[x][y];
    }
}
