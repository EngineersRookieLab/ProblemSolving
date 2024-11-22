from itertools import permutations

def isPrime(num):
    if num < 2:
        return False

    for i in range(2,num//2+1):
        if num%i ==0:
            return False
    
    return True
        

def solution(numbers):
    answer = 0
    
    # 중복 방지를 위해 set 처리
    arr = set()
    
    # numbers로 만들 수 있는 숫자 조합 생성 후 추가
    for i in range(1, len(numbers) + 1):
        arr.update(int(''.join(perm)) for perm in permutations(numbers, i))
        
    # 소수 판별   
    for a in arr:
        result = isPrime(a)
        if result:
            answer+=1
    
    return answer
