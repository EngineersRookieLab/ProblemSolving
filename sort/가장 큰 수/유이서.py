def solution(numbers):
    answer=0
    numbers = list(map(str,numbers))
    ## numbers의 범위가 3자리이므로 3자리까지만 비교
    numbers.sort(key = lambda x : x*3, reverse=True)
    
    return str(int(''.join(numbers)))
