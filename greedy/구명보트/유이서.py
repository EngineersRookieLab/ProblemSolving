from collections import deque
def solution(people, limit):
    answer = 0
    people = deque(sorted(people,reverse=True))
    
    while len(people)>1:
        if people[-1]+people[0]<=limit:
            people.pop()
            people.popleft()
            answer+=1
        else:
            people.popleft()
            answer+=1
            
    if len(people)==1:
        answer+=1

    return answer
