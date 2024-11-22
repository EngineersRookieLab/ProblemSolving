import java.util.*;
import java.util.stream.Collectors;
class Solution {
    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int[] numberArray = numbers.chars()
                .map(c -> c - '0')
                .toArray();
        boolean[] visited = new boolean[numberArray.length];
        dfs(numberArray, visited, "");
        return set.size();
    }

    private void dfs(int[] numbers, boolean[] visited, String currentNumber) {
        if (!currentNumber.isEmpty()) {
            Integer num = Integer.valueOf(currentNumber);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, visited, currentNumber + numbers[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
