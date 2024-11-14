def solution(array, commands):
    answer = []
    
    for i,j,k in commands:
        editArr = sorted(array[i-1:j])
        answer.append(editArr[k-1])
        
    return answer
