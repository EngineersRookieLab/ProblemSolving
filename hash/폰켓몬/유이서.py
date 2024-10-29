def solution(nums):
    answer = 0
    dictionary = {}
    
    for n in nums:
        if not n in dictionary:
            dictionary[n] = 1
        else:
            dictionary[n] +=1
    
    if len(dictionary) >= len(nums)//2:
        answer = len(nums)//2
    else:
        answer = len(dictionary)
    
    return answer
