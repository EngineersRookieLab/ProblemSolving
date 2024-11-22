def solution(brown, yellow):
    answer = []
    
    # brown = (yellow_y)*2 + (yellow_x)*2 + 4(테두리)
    yellow_y,yellow_x = 0,0
    
    for i in range(1,yellow+1):
        if yellow % i ==0:
            yellow_y = i
            yellow_x = int(yellow/i)
            
            if yellow_y*2+yellow_x*2+4==brown:
                answer.append(yellow_x+2)
                answer.append(yellow_y+2)
                
                return answer
    return answer
