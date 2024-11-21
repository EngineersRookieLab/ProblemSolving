import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int w_max = 0;
        int h_max = 0;
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            int w = size[0];
            int h = size[1];
            if (w < h) { // 세로가 더 길면 가로로 돌려
                w_max = Math.max(h, w_max);
                h_max = Math.max(w, h_max);
            } else {
                w_max = Math.max(w, w_max);
                h_max = Math.max(h, h_max);
            }
        }
        return w_max * h_max;
    }
}
