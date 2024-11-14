import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(h <= citations[i]) 
                return h;
        }
        return 0;
    }
}
