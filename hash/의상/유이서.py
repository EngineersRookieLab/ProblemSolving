from itertools import combinations

def solution(clothes):
    answer = 1
    dictionary = {}
    
    # 각 종류 별 옷의 수 저장
    for name, kind in clothes:
        if kind in dictionary.keys():
            dictionary[kind] += 1
        else:
            dictionary[kind] = 1
    
    # 종류별로 옷을 입지 않은 경우를 포함하여 나올 수 있는 가지수 추가
    for kind in dictionary:
        answer *= (dictionary[kind]+1)      
    
    # 모든 종류에서 입지 않은 경우를 제외
    return answer-1
