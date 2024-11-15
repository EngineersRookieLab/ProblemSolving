import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        // 최소 힙
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        // 최대 힙
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> set = new HashSet<>();

        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (op[0].equals("I")) { // 삽입 연산
                minPq.offer(Integer.parseInt(op[1]));
                maxPq.offer(Integer.parseInt(op[1]));
                set.add(Integer.parseInt(op[1]));
            }
            if (op[0].equals("D")) { // 삭제 연산
                if (op[1].equals("-1")) { // 최소힙 삭제
                    while (!minPq.isEmpty() && !set.contains(minPq.peek())) { // 최대힙에서 지워진건 최소힙에서도 지워
                        minPq.poll();
                    }
                    if (!minPq.isEmpty()) {
                        int min = minPq.poll();
                        set.remove(min);
                    }
                } else { // 최대힙 삭제
                    while (!maxPq.isEmpty() && !set.contains(maxPq.peek())) { // 최소힙에서 지워진건 최대힙에서도 지워
                        maxPq.poll();
                    }
                    if (!maxPq.isEmpty()) {
                        int max = maxPq.poll();
                        set.remove(max);
                    }
                }
            }
        }
        
        while (!minPq.isEmpty() && !set.contains(minPq.peek())) {
            minPq.poll();
        }
        while (!maxPq.isEmpty() && !set.contains(maxPq.peek())) { 
            maxPq.poll();
        }
        if (set.isEmpty()) {
            return new int[] {0, 0};
        }
        return new int[] {maxPq.poll(), minPq.poll()};
    }
}

  
