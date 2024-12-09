import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) { // 젤 왼쪽
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                } else if (j == i) { // 가장 오른쪽 열
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                } else { // 중간 열
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
    }
}
