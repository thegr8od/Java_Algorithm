import java.util.*;

class Solution {
    static int[][] map;
    static int answer;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        
        map = new int[101][101];
        for(int i=0; i<rectangle.length; i++){
            fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
        }
        
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        return answer;
    }
    
    static void fill(int startX, int startY, int endX, int endY){
        for(int i=startX; i<=endX; i++){
            for(int j=startY; j<=endY; j++){
                if(map[i][j] == 2) continue;
                map[i][j] = 2;
                if(startX == i || startY == j || endX == i || endY == j){
                    map[i][j] = 1;
                }
            }
        }
    }
    
    static void bfs(int x1, int y1, int x2, int y2){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        queue.add(new int[] {x1, y1});
        
        visited[x1][y1] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y+ dy[i];
                if(nx >=0 && nx < 101 && ny>=0 && ny<101){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
                if(nx==x2 && ny==y2){
                    answer = map[nx][ny]/ 2;
                }
            }
            
        }
    }
}