import java.util.*;

class Solution {
    private boolean[][] visited;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // rectangle 순회하면서 내부는 2으로 테두리는 1로 설정해서 테두리만 탐색할 수 있도록 한다.
        // 근데 길이 1짜리는 내부에 2를 칠할 수 없으니까 2배 해준다.
        characterX = 2 * characterX;
        characterY = 2 * characterY;
        itemX = 2 * itemX;
        itemY = 2 * itemY;
        int map[][] = new int[102][102];
        visited = new boolean[102][102];
        // map에 테두리 그리기
        for(int[] rec : rectangle) {
            int x1 = rec[0] * 2; // 왼쪽 아래 x
            int y1 = rec[1] * 2; // 왼쪽 아래 y
            int x2 = rec[2] * 2; // 오른쪽 위 x
            int y2 = rec[3] * 2; // 오른쪽 위 y
            for (int i = x1; i <= x2; i++) {
                if (map[i][y2] != 2) map[i][y2] = 1; // 윗면
                if (map[i][y1] != 2) map[i][y1] = 1; // 밑면
            }
            for (int i = y1; i <= y2; i++) {
                if (map[x1][i] != 2) map[x1][i] = 1; // 왼쪽
                if (map[x2][i] != 2) map[x2][i] = 1;// 오른쪽
            }
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 2;
                }
            }
        }
        // BFS로 탐색
        return bfs(map, itemX, itemY, characterX, characterY);
    }
    
    private int bfs(int[][] map, int itemX, int itemY, int characterX, int characterY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {characterX, characterY, 0});
        visited[characterX][characterY] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int distance = poll[2];
            // 아이템 위치에 도달했으면 거리 리턴
            if (x == itemX && y == itemY) {
                return distance / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny, distance + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
