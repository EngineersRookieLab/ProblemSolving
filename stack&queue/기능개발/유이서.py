import math
def solution(progresses, speeds):
    answer = []
    
    days=[]
    for i in range(len(speeds)):
        days.append(math.ceil((100-progresses[i])/speeds[i]))
    
    
    front = 0
    for idx in range(len(days)):
        
        if days[idx] > days[front]:
            answer.append(idx-front)
            front = idx
    answer.append(len(days)-front)

    
    return answer
