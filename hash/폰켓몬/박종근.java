import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<Integer>();

    public int solution(int[] nums) {
        int answer = 0;
        for(Integer num : nums) {
            set.add(num);
        }
        
        answer = set.size() > (nums.length/2) ? (nums.length/2) : set.size(); 
        return answer;
    }
}
