import java.util.*;

class Solution {
    static int cnt;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        cnt = words.length;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if(cnt == words.length){
            answer = 0;
        } else{
            answer = cnt;
        }
        return answer;
    }
    
    
    static void dfs(String now, String target, String[] words, int d){
        
        
        
        if(now.equals(target)){
            cnt = Math.min(cnt,d);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i]){
                int cor = 0;
                for(int j=0; j<words[i].length(); j++){
                    if(now.charAt(j) == words[i].charAt(j)){
                        cor++;
                    }
                }
                if(words[i].length() - cor == 1){
                    visited[i] = true;
                    dfs(words[i], target, words, d+1);
                    visited[i] = false;
                    
                }
            }
        }
        
    }
}