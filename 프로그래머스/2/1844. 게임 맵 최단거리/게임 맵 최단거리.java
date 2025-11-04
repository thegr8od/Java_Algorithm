import java.util.*;

class Solution {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0});
        
        while(!queue.isEmpty()){
            
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[nx].length){
                    if(maps[nx][ny] == 1){
                        maps[nx][ny] = maps[x][y] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
        
        answer = maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
        return answer;
    }
}