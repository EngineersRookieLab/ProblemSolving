import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        
        for(String operation : operations) {
            String[] op = operation.split(" ");
            
            char command = op[0].charAt(0);
            int num = Integer.parseInt(op[1]);
            
            if(command == 'I') {
                maxpq.add(num);
                minpq.add(num);
            } else if(command == 'D') {
                if (maxpq.isEmpty() || minpq.isEmpty()) {
                    continue;
                }
                
                if(num == 1) {
                    minpq.remove(maxpq.poll());
                } else if(num == -1) {
                    maxpq.remove(minpq.poll());
                }
            }
        }
        
        int[] answer = new int[2];
        if (!maxpq.isEmpty()) {
            answer[0] = maxpq.poll();
            answer[1] = minpq.poll();
        }

        return answer;
    }
    
}
