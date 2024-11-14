def solution(citations):
    citations = sorted(citations)
    index = len(citations)
    for i in range(index):
        if citations[i]>=index-i:
            return index-i
    return 0
