import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    public int dfs(int[] numbers, int index, int current, int target) {
        if (index == numbers.length) {
            if (current == target) {
                return 1;
            }
            return 0;
        }
        int plus_num = dfs(numbers, index+1, current + numbers[index], target);
        int minus_num = dfs(numbers, index+1, current - numbers[index], target);
        return plus_num + minus_num;
    }
}
