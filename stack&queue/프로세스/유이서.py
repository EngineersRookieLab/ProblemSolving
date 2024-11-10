from collections import deque
def solution(priorities, location):
    answer = 0
    
    #어떻게 location을 체크하는가? enumerate이용 (python에서는 idx, val순)
    dque = deque([(val,idx) for idx,val in enumerate(priorities)])
    
    #첫번째 원소가 max보다 작을땐 목록의 뒤로 / max보다 클 땐 바로 출력
    while len(dque):
        J  = dque.popleft()
        if dque and max(dque)[0] > J[0]:
            dque.append(J)
        
        else:
            answer+=1
            if J[1] == location:
                break
                
            
    return answer
