def solution(sizes):
    answer = 0
    
    height, width = 0,0
    for size in sizes:
        size.sort()
        height = max(height,size[1])
        width = max(width,size[0])
    answer = height*width

    return answer
