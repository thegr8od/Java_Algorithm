import java.util.*;

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] visited;
    static int r,c;
    public int solution(int[][] maps) {
        int answer = 0;
        r = maps.length;
        c = maps[0].length;
        visited = new int[r][c];
        bfs(0,0,maps);
        answer = visited[r-1][c-1];
        answer = answer > 0 ? answer : -1;
        return answer;
    }
    
    static void bfs(int startX, int startY, int[][] maps){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX,startY});
        visited[startX][startY] = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
      
            
            for(int i=0; i<4; i++){
                int nx = x +dx[i];
                int ny = y +dy[i];
                if(nx>=0 && nx<r && ny>=0 && ny<c){
                  if(maps[nx][ny] == 1 & visited[nx][ny] == 0){
                    visited[nx][ny] = visited[x][y] + 1;
                     queue.add(new int[] {nx,ny});
                  }  
                }
            }
            
        }
    }
}