import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> emptySpace = new ArrayList<>();
        List<List<int[]>> blocks = new ArrayList<>();
        
        int row = game_board.length;
        int col = game_board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(game_board[i][j] == 0 && !visited[i][j]){
                    emptySpace.add(extractShape(i,j,row,col,game_board,visited,0));
                }
            }
        }
        
        row = table.length;
        col = table[0].length;
        
        visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(table[i][j] == 1 && !visited[i][j]){
                    blocks.add(extractShape(i,j,row,col,table,visited,1));
                }
            }
        }
        
        return match(emptySpace, blocks);
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static List<int[]> extractShape(int startX, int startY, int row, int col, int[][] board, boolean[][] visited, int target){
        List<int[]> result = new ArrayList<>();
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {startX, startY});
        
        visited[startX][startY] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            result.add(cur);
            
            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx <0 || ny <0 || nx >= row || ny >= col) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] != target) continue;
                
                visited[nx][ny] = true;
                que.add(new int[] {nx, ny});
            }
        }
        
        return normarlize(result);
    }
    
    static List<int[]> normarlize(List<int[]> data) {
        if(data == null || data.isEmpty()) return data;
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] d : data){
            minX = Math.min(minX, d[0]);
            minY = Math.min(minY, d[1]);
        }
        
        for(int[] d : data){
            d[0] -= minX;
            d[1] -= minY;
        }
        
        return data;
    }
    
    static int match(List<List<int[]>> emptySpace, List<List<int[]>> blocks){
        int result = 0;
        boolean[] used = new boolean[blocks.size()];
        
        for(int i=0; i<emptySpace.size(); i++){
            List<int[]> space = emptySpace.get(i);
            
            for(int j=0; j<blocks.size(); j++){
                if(used[j]) continue;
                
                List<int[]> block = blocks.get(j);
                if(rotateAndCompare(space, block)) {
                    result += block.size();
                    used[j] = true;
                    break;
                }
            }
        }
        
        return result;
    }
    
    static boolean rotateAndCompare(List<int []> space, List<int[]> block){
        if(space.size() != block.size()) return false;
        
        List<int []> rotated = block;
        for(int i=0; i<4; i++){
            if(compare(space, rotated)){
                return true;
            }
            
            if(i<3) {
                rotated = rotate(rotated);
            }
        }
        
        return false;
    }
    
    static List<int[]> rotate(List<int[]> block) {
        List<int[]> result = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] b : block){
            int x = b[1];
            int y = -b[0];
            
            result.add(new int[] {x,y});
            
            if(x<minX) minX = x;
            if(y<minY) minY = y;
        }
        
        for(int[] r : result) {
            r[0] -= minX;
            r[1] -= minY;
        }
        
        return result;
    }
    
    static boolean compare(List<int[]> space, List<int[]> block) {
        Collections.sort(space, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Collections.sort(block, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        for(int i=0; i<space.size(); i++){
            int[] s = space.get(i);
            int[] b = block.get(i);
            if(s[0]!=b[0] || s[1] != b[1]){
                return false;
            }
        }
        
        return true;
    }
}