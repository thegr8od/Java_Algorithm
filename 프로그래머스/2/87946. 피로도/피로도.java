import java.util.*;

class Solution {
    static boolean[] visited;
    static int len, answer;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        dfs(0,k,dungeons);
        return answer;
    }
    
    static void dfs(int d, int power, int[][] dungeons){
        
        answer = Math.max(d, answer);
        
        for(int i=0; i<len; i++){
            if(!visited[i]){
                if(power >= dungeons[i][0]){
                    visited[i] = true;
                    dfs(d+1, power-dungeons[i][1], dungeons);
                    visited[i] = false;
                }
            }
        }
    }
    
    
}