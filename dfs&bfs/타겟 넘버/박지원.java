class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int count, int total, int[] numbers, int target) {
        if(count == numbers.length) {
            if(total == target) {
                answer++;
            }
            return;
        }
        dfs(count + 1, total + numbers[count], numbers, target);
        dfs(count + 1, total - numbers[count], numbers, target);
    }
}
