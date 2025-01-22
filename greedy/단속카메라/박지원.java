import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        int point = routes[0][1];
        for(int[] route : routes) {
            if(point < route[0]) {
                point = route[1];
                answer++;
            }
        } 
        
        return answer;
    }
}
