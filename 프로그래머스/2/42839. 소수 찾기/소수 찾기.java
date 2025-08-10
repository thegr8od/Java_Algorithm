import java.util.*;

class Solution {
    static Set<Integer> set;
    static int answer;
    static boolean[] visited;
    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        dfs(0, numbers, "");
        for(int i : set){
            if(i>1) isPrime(i);
        }
    
        
        return answer;
    }
    
    public void dfs(int idx, String numbers, String now){
        
        if(now.length()>0) set.add(Integer.parseInt(now));
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, numbers, now + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public void isPrime(int n){
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return;
            }
        }
        
        answer++;
    }
}