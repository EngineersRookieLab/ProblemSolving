import java.util.*;
class Solution {
     public int solution(int[] money) {
        if (money.length == 1) {
            return money[0];
        }
        if (money.length == 2) {
            return Math.max(money[0], money[1]);
        }
        // 첫번째 집 털고 마지막 집 털지 않는 경우
        int max1 = getMaxMoney(money, 0, money.length - 1);
        int max2 = getMaxMoney(money, 1, money.length);
        return Math.max(max1, max2);
    }

    private int getMaxMoney(int[] money, int start, int end) {
        // dp[i] : i번째 집까지 털었을때의 최대 값
        // dp[i] = max(dp[i-1], dp[i-2] + money[i])
        int[] dp = new int[money.length];
        dp[start] = money[start];
        dp[start + 1] = Math.max(money[start], money[start+1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        return dp[end - 1];
    }
}
