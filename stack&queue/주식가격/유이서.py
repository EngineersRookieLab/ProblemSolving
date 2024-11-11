def solution(prices):
    answer = []
    
    for i in range(len(prices)):
        seconds = 0
        for j in range(i+1, len(prices)):
            seconds+=1
            if prices[i]>prices[j]:
                break
        answer.append(seconds)
        
    return answer
