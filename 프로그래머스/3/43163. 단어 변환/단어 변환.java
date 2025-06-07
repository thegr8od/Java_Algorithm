import java.util.*;


class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        answer = answer == Integer.MAX_VALUE  ? 0 : answer;
        return answer;
    }
    
    static void dfs(String now, String target, String[] words, int d){
        
        
        
        if(now.equals(target)){
            answer = Math.min(answer,d);
            return;
        }
        
        
        for(int i=0; i<words.length; i++){
            int cnt = 0;
            for(int j=0; j<now.length(); j++){
                if(now.charAt(j)==words[i].charAt(j)) cnt++;
                if(cnt == now.length()-1 && !visited[i]){
                    visited[i] = true;
                    dfs(words[i], target, words, d+1);
                    visited[i] = false;
                    
                }
            }
            
        }
    }
}