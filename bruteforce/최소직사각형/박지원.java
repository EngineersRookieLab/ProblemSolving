import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxV = 0;
        int maxH = 0;
        for(int[] item : sizes) {
            maxV = Math.max(maxV, Math.max(item[0], item[1]));
            maxH = Math.max(maxH, Math.min(item[0], item[1]));
        }
        return maxV * maxH;
    }
}
