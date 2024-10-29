package programmers.review.hash;

import java.util.*;

public class Sol1845 {

    public int solution(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer currentValue = hashMap.getOrDefault(num, 0);
            hashMap.put(num, currentValue + 1);
        }
        if (hashMap.size() >= nums.length / 2) {
            return nums.length / 2;
        }
        return hashMap.size();
    }

    public static void main(String[] args) {
        Sol1845 sol1845 = new Sol1845();
        int solution = sol1845.solution(new int[]{3, 3, 3, 2, 2, 4});
        System.out.println("solution = " + solution);
    }
}
