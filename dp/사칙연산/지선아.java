import java.util.*; 

class Solution {
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2;
        int[] numbers = new int[n];
        char[] operators = new char[n -1];

        // 숫자 연산자 분리
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            } else {
                operators[i / 2] = arr[i].charAt(0);
            }
        }

        // maxDP[i][j] : 구간 i ~ j의 최대값
        // minDP[i][j] : 구간 i ~ j의 최솟값
        // dp 테이블 초기화
        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];
        for (int[] row : maxDP) Arrays.fill(row, Integer.MIN_VALUE);
        for (int[] row : minDP) Arrays.fill(row, Integer.MAX_VALUE);

        // 길이 1인 구간 초기화
        for (int i = 0; i < n; i++) {
            maxDP[i][i] = numbers[i];
            minDP[i][i] = numbers[i];
        }
        // 길이 2 이상인 구간 계산
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) { // 시작 인덱스
                int j = i + len; // 끝 인덱스
                for (int k = i; k < j; k++) { // 중간 연산자 (i -> k -> j)
                    char op = operators[k];
                    if (op == '+') {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k+1][j]);
                    } else if (op == '-') {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k+1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k+1][j]);
                    }
                }
            }
        }
        return maxDP[0][n - 1];
    }
}
