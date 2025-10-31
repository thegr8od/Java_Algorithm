import java.util.*;

class Solution {
    static boolean[] visited;
    static List<List<Integer>> lst;
    static int dist;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        lst = new ArrayList<>();
        
        for(int i=0; i<=n ;i++){
            lst.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            lst.get(a).remove(Integer.valueOf(b));
            lst.get(b).remove(Integer.valueOf(a));
            dist = 0;
            visited = new boolean[n+1];
            dfs(a);
            int v1 = dist;
            
            dist = 0;
            dfs(b);
            int v2 = dist;
            
            answer = Math.min(Math.abs(v1-v2), answer);
            lst.get(a).add(b);
            lst.get(b).add(a);
            
        }
        return answer;
    }
    
    static void dfs(int now){
        
        dist++;
        visited[now] = true;
        
        for(int a : lst.get(now)){
            if(!visited[a]){
                dfs(a);
            }
        }
    }
}