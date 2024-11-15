import java.util.*;

class Solution {
    
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int total = citations.length;
        int max = 0;
        for (int i = 1; i < citations[total - 1]; i++) {
            int h = i;
            long hOver = Arrays.stream(citations).filter(a -> a >= h).count();
            long hLow = total - hOver;
            if (hOver >= h && hLow <=h) {
                if (max <= h) {
                    max = h;
                }
            }
        }
        return max;
    }
}
