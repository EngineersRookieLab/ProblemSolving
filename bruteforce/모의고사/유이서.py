def solution(answers):
    student1 = [1, 2, 3, 4, 5] # 5
    student2 = [2, 1, 2, 3, 2, 4, 2, 5] # 8
    student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] # 10
    
    score = [0, 0, 0]
    result = []
    
    for idx, ans in enumerate(answers):
        if student1[idx % 5] == ans:
            score[0] += 1
        if student2[idx % 8] == ans:
            score[1] += 1
        if student3[idx % 10] == ans:
            score[2] += 1

    for idx, s in enumerate(score):
        if s == max(score):
            result.append(idx + 1)

    return result
