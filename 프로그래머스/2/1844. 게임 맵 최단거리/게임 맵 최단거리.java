import java.util.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] {0,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(maps[nx][ny] == 1){
                        maps[nx][ny] = maps[x][y] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
        
        answer = maps[n-1][m-1];
        if(answer == 1){
            answer = -1;
        }
        
        return answer;
    }
}