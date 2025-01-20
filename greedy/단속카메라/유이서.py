def solution(routes):
    answer = 0
    
    routes.sort(key = lambda x:x[1])
    
    camera = 0
    last_camera = -30001
    
    for start,end in routes:
        if start > last_camera:
            camera+=1
            last_camera = end
            
            
    return camera
