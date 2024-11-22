from collections import defaultdict, deque

# gpt랑 같이 풀었음..어렵다..
def solution(n, wires):
    def bfs(start, graph, visited):
        queue = deque([start])
        visited[start] = True
        count = 1  # 시작 노드 포함
        while queue:
            node = queue.popleft()
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)
                    count += 1
        return count

    # 그래프 생성
    graph = defaultdict(list)
    for u, v in wires:
        graph[u].append(v)
        graph[v].append(u)

    min_diff = float('inf')

    # 모든 간선을 하나씩 제거
    for u, v in wires:
        # 그래프에서 간선 (u, v) 제거
        graph[u].remove(v)
        graph[v].remove(u)

        # 두 개의 트리로 나누기
        visited = [False] * (n + 1)
        count1 = bfs(1, graph, visited)  # 첫 번째 트리의 노드 개수
        count2 = n - count1  # 두 번째 트리의 노드 개수

        # 차이 계산
        min_diff = min(min_diff, abs(count1 - count2))

        # 간선 복구
        graph[u].append(v)
        graph[v].append(u)

    return min_diff
