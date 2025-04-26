import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(numbers,"",0);
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        return answer;
    }
    
    public static void dfs(String numbers, String s, int depth){
        
        if(depth > numbers.length()){
            return;
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(s+numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
            
        }
    }
    
    public static boolean isPrime(int n){
        if (n<2){
            return false;
        }
        
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0) {
                return false;
            }
        }
        
        return true;
    }
}