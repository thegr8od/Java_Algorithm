import java.util.*;

class Solution {
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0){
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length){
                    if(visited[nx][ny] == 0 && maps[nx][ny]== 1){
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
            
        }
    }
}