def solution(participant, completion):
    answer = ''
    
    ## dictionary 초기화
    dictionary = {}
    
    for p in participant:
        ## dictionary에 존재하지 않을 때
        if p not in dictionary:
            dictionary[p] = 1
        ## 이미 존재한다면 인원수 추가
        else:
            dictionary[p] += 1
    
    for c in completion:
        if dictionary[c] == 1:
            del dictionary[c]
        ## 동명이인 존재시
        else:
            dictionary[c] -=1
        
    ## dictionary에 남은 키 값 확인
    for i in dictionary.keys():
        answer = i
            
    return answer
