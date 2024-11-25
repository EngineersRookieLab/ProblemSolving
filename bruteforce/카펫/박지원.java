class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int col = 1; true; col++) {
            if ((((brown / 2) + 2 - col ) * col) == total) {
                answer[1] = col;
                answer[0] = total / answer[1];
                return answer;
            }
        } 
    }
}
