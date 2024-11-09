import java.util.*;

public class Solution {
      public int[] solution(int[] arr) {
          Deque<Integer> deque = new LinkedList<>();
        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.add(num);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (!deque.isEmpty()) {
            answer.add(deque.pollFirst());
        }
        return answer
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
      }
}
