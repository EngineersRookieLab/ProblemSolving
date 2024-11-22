from itertools import product

def solution(word):
    alpha = ['A', 'E', 'I', 'O', 'U']
    dictionary = []

    # 모든 가능한 단어 조합 생성 (최대 길이 5)
    for i in range(1, 6):
        # itertools의 product => 데카르트의 곱을 반환
        dictionary.extend(''.join(comb) for comb in product(alpha, repeat=i))

    # 사전순 정렬
    dictionary.sort()

    # 입력 단어의 인덱스 반환
    return dictionary.index(word) + 1
