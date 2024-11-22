class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        for (int w = 3; w <= total / 2; w++) {
            for (int h = 3; h <= w; h++) {
                if (w * h == total) {
                    int temp_brown = 2 * (w + h) - 4;
                    int temp_yellow = total - temp_brown;
                    if (temp_brown == brown && temp_yellow == yellow) {
                        answer[0] = w;
                        answer[1] = h;
                        return answer;
                    }
                }   
            }
        }
        return answer;
    }
}
