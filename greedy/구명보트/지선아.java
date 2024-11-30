import java.util.*;

class Solution {
     public int solution(int[] people, int limit) {
         Arrays.sort(people);
         int left = 0;
         int right = people.length - 1;
         int b_count = 0;
         while (left <= right) {
             if (people[left] + people[right] <= limit) {
                 left++; // 둘다 태워
             }
             right--; // 무거운 사람만 태워
             b_count++;
         }
         return b_count;
    }
}
