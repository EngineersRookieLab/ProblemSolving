import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length / 2;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            hashSet.add(num);
        }
        
        return size >= hashSet.size() ? hashSet.size() : size;
    }
}