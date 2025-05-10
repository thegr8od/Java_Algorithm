import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<Integer> set;
    static int len;
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        visited = new boolean[len];
        set = new HashSet<>();
        dfs("",0,numbers);

        
        for(int num : set){
            if(isPrime(num)) answer++;
        }
        
        for(int num : set){
            System.out.println(num);
        }
        return answer;
        
    }
    
    public static void dfs(String str, int depth, String numbers){
        
        if(depth > len){
            return;
        }
        
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i] = true;
                String now = str + numbers.charAt(i);
                set.add(Integer.parseInt(now));
                dfs(now, depth+1, numbers);
                visited[i] = false;
            }
        }
        
    }
    
    
    
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }    
        
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        
        return true;
        
    }
    
}