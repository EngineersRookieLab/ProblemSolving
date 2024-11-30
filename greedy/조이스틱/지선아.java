class Solution {
    public int solution(String name) {
        int count = 0;
        int n = name.length();
        int move = n - 1; // 정방향으로 가는 경우 커서 조작 횟수
        
        for (int i = 0; i < n; i++) {
            char ch = name.charAt(i);
            int up_count = ch - 'A';
            int down_count = 'Z' - ch + 1;
            count += Math.min(up_count, down_count); // 알파벳 조작 횟수
            
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') { // 다음 글자가 A일 때, A의 끝으로 가기 위해 필요한 커서 횟수 구해
                next++;
            }
            // 정방향과 뒤로 돌아가는 경우 커서 횟수 비교 (왔던걸 다시 되돌아 가는 횟수 : i * 2 + 뒤에서 A 끝나는 지점까지 가는거 : n - next)
            move = Math.min(move, i * 2 + n - next);
            // 처음부터 맨 뒤에서 시작하는 커서 횟수
            move = Math.min(move, (n - next) * 2 + i);
        }
        return count + move;
    }
}
