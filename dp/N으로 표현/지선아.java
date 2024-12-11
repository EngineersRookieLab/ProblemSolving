import java.util.*;

class Solution {
    /**
    * 최대 8번까지만 사용할 수 있음
    * dp[i] : N을 i번 사용해서 만들 수 있는 숫자 집합
    * dp[i] = dp[j] +/*- dp[j-i] 
    **/
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        // 숫자 집합 구하기
        for (int i = 1; i <= 8; i++) {
            int repeatedNumber = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedNumber);
        }
        // DP로 사칙 연산 
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) dp.get(i).add(num1 / num2);
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
