import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1])); // 끝나는 지점으로 정렬
        int count = 0;
        int lastCam = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            if (lastCam < route[0]) {
                count++;
                lastCam = route[1];
            }
        }
        return count;   
    }
}
