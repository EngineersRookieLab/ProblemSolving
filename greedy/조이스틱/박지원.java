class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            // 알파벳 변경 비용
            char ch = name.charAt(i);
            int up = ch - 'A';
            int down = 'Z' - ch + 1;
            answer += Math.min(up, down);

            // 이동 비용
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + length - next + Math.min(i, length - next));
        }

        answer += move;
        return answer;
    }
}

