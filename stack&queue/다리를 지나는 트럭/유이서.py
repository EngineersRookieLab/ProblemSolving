from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = deque([0] * bridge_length)
    current_weight = 0  # 다리 위의 현재 총 무게를 저장
    
    while bridge:
        time += 1
        current_weight -= bridge.popleft()  # 다리를 빠져나간 트럭의 무게를 제거
        
        if truck_weights:
            # 다음 트럭이 다리에 올라갈 수 있는지 확인
            if current_weight + truck_weights[0] <= weight:
                truck = truck_weights.pop(0)
                bridge.append(truck)
                current_weight += truck  # 다리의 총 무게 갱신
            else:
                bridge.append(0)  # 트럭이 못 올라가면 0을 추가해 다리 길이 유지
                
    return time
