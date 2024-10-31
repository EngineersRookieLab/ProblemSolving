def solution(phone_book):
    answer = True
    dict={}
    for pNumber in phone_book:
        dict[pNumber]=1
    for pNumber in phone_book:
        temp = ''
        for p in pNumber:
            temp+=p
            if temp in dict and temp != pNumber:
                answer=False
    return answer
