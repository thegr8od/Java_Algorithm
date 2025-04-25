class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        int mod = 1000000007;
        
        for(int[] temp : puddles){
            dp[temp[1]][temp[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i =1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
                if(dp[i][j] == -1) continue;
                
                if(dp[i-1][j] > 0){
                    dp[i][j] += dp[i-1][j];
                    dp[i][j] %= mod;
                }
                if(dp[i][j-1] > 0){
                    dp[i][j] += dp[i][j-1];
                    dp[i][j] %= mod;
                }
            }
        }
        
        return dp[n][m];
    }
}