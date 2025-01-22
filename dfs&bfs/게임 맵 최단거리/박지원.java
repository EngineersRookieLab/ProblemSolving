import java.util.*;

class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int n;
    public int m;
    
    public boolean isBound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= m;
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];
            
            if(x == n-1 && y == m-1){
                return cnt;
            }
            
            for(int i = 0;i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(!isBound(nx, ny) && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt+1});
                }
            }
        }
        return -1;
    }
}
