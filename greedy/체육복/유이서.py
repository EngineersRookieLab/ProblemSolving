def solution(n, lost, reserve):
    answer = -1 # array 크기를 +1 해서 생성하기 때문에
    # 모든 학생의 체육복 상태 초기화
    clothes = [0] * (n + 1)
    
    for l in lost:
        clothes[l] -= 1  # 도난당한 학생
    for r in reserve:
        clothes[r] += 1  # 여벌을 가진 학생
    
    # 체육복 빌려주기
    for i in range(1, n + 1):
        if clothes[i] == -1:  # 체육복이 없는 학생
            if i > 1 and clothes[i - 1] == 1:  # 왼쪽 학생이 여벌이 있는 경우
                clothes[i] += 1
                clothes[i - 1] -= 1
            elif i < n and clothes[i + 1] == 1:  # 오른쪽 학생이 여벌이 있는 경우
                clothes[i] += 1
                clothes[i + 1] -= 1

    # 체육복이 0 이상인 학생 수 계산
    for cloth in clothes:
        if cloth >=0:
            answer+=1

    return answer
