from itertools import permutations

def solution(k, dungeons):
    answer = 0
    # 모든 순열을 생성
    orders = list(permutations(dungeons, len(dungeons)))

    for order in orders:
        remaining_k = k  # 각 순열마다 초기 피로도 설정
        steps = 0        # 탐험한 던전 횟수 초기화

        for needs, usage in order:
            if remaining_k >= needs:
                steps += 1
                remaining_k -= usage
            else:
                break  # 남은 피로도가 부족하면 더 이상 탐험 불가
        
        # 최대 탐험 횟수 갱신
        answer = max(answer, steps)
        
    return answer
