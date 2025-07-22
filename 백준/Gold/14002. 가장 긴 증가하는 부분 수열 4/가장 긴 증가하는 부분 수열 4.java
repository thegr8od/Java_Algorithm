import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, W, maxLen;
    static StringTokenizer st;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        maxLen = 1;

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        int[] ans = new int[maxLen];

        int idx = maxLen -1;
        int lastV = Integer.MAX_VALUE;

        for(int i=N-1; i>=0; i--){
            if (dp[i] == idx + 1 && nums[i] < lastV){
                ans[idx--] = nums[i];
                lastV = nums[i];
            }
            if (idx<0) break;
        }

        System.out.println(maxLen);
        for(int i=0; i<maxLen; i++){
            if(i!=maxLen-1)  System.out.print(ans[i] +" ");
            else System.out.print(ans[i]);
        }




    }



}


