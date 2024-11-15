import heapq
def solution(jobs):
    answer = 0
    
    jobs.sort(key=lambda x : x[0])
    
    # 작업 대기열 큐
    queue = []
    
    # 현재 시간, 전체 작업 시간, 작업번호
    time, total_time, index = 0,0,0
    
    # 아직 요청되지 않은 작업이 남아있거나 처리해야 할 작업이 남아있는가
    while index < len(jobs) or queue:
        
        if index<len(jobs) and jobs[index][0] <= time:
            heapq.heappush(queue, (jobs[index][1], jobs[index][0])) # 소요시간, 요청 시점
            index+=1
            continue
        
        # 대기열
        if queue:
            duration, request_time = heapq.heappop(queue)
            time += duration
            total_time += time - request_time #소요시간 - 요청시간 = 대기시간
        
        else:
            time = jobs[index][0]
    
    return total_time // len(jobs)
