def solution(genres, plays):
    answer = []
    total_hash = {}
    match_hash = {}
    
    for i in range(len(genres)):
        key = genres[i]
        if not key in total_hash:
            total_hash[key] = plays[i]
        else:
            total_hash[key] += plays[i]
        
        if not key in match_hash:
            match_hash[key] = [(plays[i],i)]
        else:
            match_hash[key] += [(plays[i],i)]
    
    # 전체 장르 내림차순
    sort_total_hash = sorted(total_hash.items(),key=lambda x:x[1], reverse=True)

    # 장르 재생횟수 내림차순
    for genre in match_hash:
        match_hash[genre] = sorted(match_hash[genre], key=lambda x: x[0], reverse=True)
    
    # 장르 순서대로 상위 두 곡의 인덱스를 answer에 추가
    for genre, _ in sort_total_hash:
        top_songs = match_hash[genre][:2]  # 상위 두 곡 선택
        for play, idx in top_songs:
            answer.append(idx)

    return answer
