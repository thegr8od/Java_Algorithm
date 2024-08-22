
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean[][] isVisited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int T,N,ans, minV;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <=T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            ans = 0;
            minV = Integer.MAX_VALUE;
            isVisited = new boolean[N][N];
            for (int i =0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j =0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i =0; i<N; i++) {
            	for (int j=0; j<N; j++) {
            		int res = dfs(i,j,1);
            		if (res > ans) {
                        ans = res;
                        minV = map[i][j];
                    } else if (res == ans && map[i][j] < minV) {
                        minV = map[i][j];
                    }
            	}
            }
            System.out.println("#"+tc+" "+minV+" "+ans);
        }
    }
    
    static int dfs(int x, int y, int cnt) {

        isVisited[x][y] = true;
        int maxCnt = cnt;
        for(int i =0; i<4; i++) {
            int nx = x +dx[i];
            int ny = y +dy[i];
            if(nx >=0 && nx <N && ny>=0 && ny<N && !isVisited[nx][ny]) {
                if(map[nx][ny] == map[x][y]+1) {
                    maxCnt = Math.max(maxCnt,dfs(nx,ny,cnt+1));
                }
            }
        }
        isVisited[x][y] = false;
        return maxCnt;
    }
}
