import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, W, S;
    static StringTokenizer st;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] dp2 = new int[N];
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(nums[i] > nums[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }

        int res = 0;
        for(int i=0; i<N; i++){
            res = Math.max(res, dp[i]+dp2[i]);
        }

        System.out.println(res-1);


    }



}


