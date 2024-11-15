import heapq

def solution(scoville, K):
    # 최소 힙으로 변환
    heapq.heapify(scoville)
    answer = 0

    while scoville[0] < K:
        # 힙에 남은 요소가 1개일 때 K 이상이 아니면 불가능하므로 -1 반환
        if len(scoville) < 2:
            return -1
        
        # 가장 맵지 않은 두 개를 꺼내어 섞기
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        new_scoville = first + (second * 2)
        
        # 섞은 음식 다시 힙에 추가
        heapq.heappush(scoville, new_scoville)
        answer += 1  # 섞은 횟수 증가

    return answer
