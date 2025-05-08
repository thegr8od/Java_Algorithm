import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[10001][4];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for(int i=4; i<=10000; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] +  dp[i-3][2] + dp[i-3][3];
        }

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
        }


    }


}
