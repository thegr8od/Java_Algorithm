import java.util.*;

class Solution {
    static int col, row, answer, sum;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public int solution(int[][] land) {
        row = land.length;
        col = land[0].length;
        int[] cnt = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 1) {
                    Set<Integer> set = new HashSet<>();
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[] {i,j});
                    set.add(j);
                    land[i][j] = 0;
                    int sum = 0;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        sum++;
                        int x = cur[0];
                        int y = cur[1];
                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx>=0 && nx<row && ny>= 0 && ny<col && land[nx][ny] == 1){
                                land[nx][ny] = 0;
                                queue.add(new int[] {nx,ny});
                                set.add(ny);
                            }
                        }

                    }
                    
                    for(int idx : set){
                        cnt[idx] += sum;
                        
                    }
                    
                }
            }
        }
        
        for(int num : cnt){
            answer = Math.max(num,answer);
        }

        return answer;
    }

    
}
