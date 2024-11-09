from collections import deque
def solution(s):
    answer = True
    
    stack=deque()
    for i in s:
        if i==")" and not stack:
            return False
        elif i == ")" and stack[-1] == "(":
            stack.pop()
            
        else:
            stack.append(i)
    
    if not stack:
        return True
    else:
        return False

    return True
