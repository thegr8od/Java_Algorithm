import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n;
    static int res = 0;
    static int[][] req = new int[501][501];
    static int[][] dp = new int[501][501];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int x =0; x<n; x++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y=0; y<n; y++){
                req[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x =0; x<n; x++){
            for (int y=0; y<n; y++){
                int ans = dfs(x,y);
                res = Math.max(res, ans);
            }
        }

        System.out.println(res);
    }

    public static int dfs(int x, int y){
        if(dp[x][y] !=0) return dp[x][y];

        dp[x][y] = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y+ dy[i];
            if(nx>=0 && nx <n && ny>=0 && ny<n) {
                if (req[nx][ny] > req[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                }
            }

        }
        return dp[x][y];
    }
}
