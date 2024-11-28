def solution(name):
    answer = 0
    length = len(name)
    
    for n in range(length):
        # 알파벳을 목표로 가는 횟수 계산
        not_reverse = int(ord(name[n]) -ord('A'))
        reverse = int(ord('Z')-ord(name[n]))+1
        answer += min(not_reverse,reverse)
    
    # 좌우 이동 계산
    # 순방향으로 이동시 최대 움직이는 횟수
    min_move = length-1
    
    # 그 외의 경우 처리
    for i in range(length):
        next_idx = i+1
        
        # 건너 뛸 연속된 'A'계산
        while next_idx <length and name[next_idx] == 'A':
            next_idx+=1
        
        # 뒤로 돌아가는 경우
        # 두 가지 방향으로 이동할 수 있는 거리 계산
        move_forward = i  # 처음부터 끝까지 가는 거리
        move_backward = length - next_idx  # 연속된 'A' 이후 끝까지 가는 거리
        # 두 방향 중 더 적은 이동 거리 선택
        min_move_direction = min(move_forward, move_backward)
        # 좌우 이동 거리 합산
        move = min_move_direction + move_forward + move_backward

        
        # 최소 이동 횟수 갱신
        min_move = min(min_move, move)  
        
    answer+=min_move
    
    return answer
