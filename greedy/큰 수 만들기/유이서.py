def solution(number, k):
    stack = []
    for num in number:
        while stack and stack[-1] < num and k > 0:
            stack.pop()
            k -= 1
        stack.append(num)
    
    # 남은 k만큼 뒤에서 제거
    if k > 0:
        stack = stack[:-k]
    
    return ''.join(stack)


## 실패 코드 - 시간초과 시간복잡도 O(n^(k+1))
#     arr = [int(''.join(comb)) for comb in combinations(number, len(number)-k)]
#     answer = str(max(arr))
