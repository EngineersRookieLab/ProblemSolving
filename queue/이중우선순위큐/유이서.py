import heapq

def solution(operations):
    min_heap = []  # 최소 힙
    max_heap = []  # 최대 힙 (음수 사용)

    for operation in operations:
        command, number = operation.split(' ')
        number = int(number)

        if command == 'I':
            # 최소 힙과 최대 힙에 동시 삽입
            heapq.heappush(min_heap, number)
            heapq.heappush(max_heap, -number)

        elif command == 'D':
            if number > 0 and max_heap:  # 최대값 삭제
                max_value = -heapq.heappop(max_heap)
                min_heap.remove(max_value)
                heapq.heapify(min_heap)  # 최소 힙 복구
                
            elif number < 0 and min_heap:  # 최소값 삭제
                min_value = heapq.heappop(min_heap)
                max_heap.remove(-min_value)
                heapq.heapify(max_heap)  # 최대 힙 복구


    if not min_heap:
        return [0, 0]
    else:
        return [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
