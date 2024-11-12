import java.util.*;

class Solution {
   public int solution(int bridge_length, int weight, int[] truck_weights) {
       Queue<Integer> waitQueue = new LinkedList<>();
        // 트럭 무게, 현재 다리에서의 위치
        Queue<int[]> bridge = new LinkedList<>();
        // 대기열 생성
        for (int i = 0; i < truck_weights.length; i++) {
            waitQueue.offer(truck_weights[i]);
        }
        int passedTruckCount = 0;
        int bridgeWeightSum = 0;
        int time = 0;
        while (passedTruckCount < truck_weights.length) {
            time += 1;
            // 다리에 있는 트럭들 한칸씩 이동
            bridge.stream().forEach(arr -> arr[1]+=1);
            // 다리끝에 있는 트럭이 있다면 건너
            int[] peek = bridge.peek();
            if (peek != null && peek[1] == bridge_length) {
                int[] poll = bridge.poll();
                bridgeWeightSum -= poll[0];
                passedTruckCount+=1;
            }
            // 대기열에 있는 트럭 다리로 입장
            Integer currentTruck = waitQueue.peek();
            if(currentTruck!= null && bridge.size() + 1 <= bridge_length && bridgeWeightSum + currentTruck <= weight) {
                bridgeWeightSum += currentTruck;
                bridge.offer(new int[]{waitQueue.poll(), 0});
            }
        }
        return time;
    }
}
