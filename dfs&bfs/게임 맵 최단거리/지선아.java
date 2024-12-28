import java.util.*;
class Solution {
    private int[][] visited;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];
        bfs(0, 0, maps);
        if (visited[n-1][m-1] == 0) {
            return -1;
        }
        return visited[n-1][m-1];
    }
    
    private void bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[currentX][currentY] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
