import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int total = 0;
        int time = 0;
        
        for(int i = 0; i < truck_weights.length; i++) {
            while(true) {
                if(bridge.size() != bridge_length) {
                    if (total + truck_weights[i] <= weight) {
                        // 자리 있고 무게도 남으면 트럭 올리기
                        bridge.offer(truck_weights[i]);
                        total += truck_weights[i];
                        time++;
                        break;
                    } else {
                        // 자리 있는데 무게 안남아서 시간만 보내기
                        bridge.offer(0);
                        time++;
                    }
                } else {
                    // 자리 없음
                    total -= bridge.poll();
                }
            }
        }
       
        // bridge 에 올라가있는 애들 내려주기
        return time + bridge_length;
    }
