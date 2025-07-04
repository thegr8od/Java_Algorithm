import java.util.*;

class Solution {
    static List<List<Integer>> lst;
    static boolean[] visited;
    static int d;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        lst = new ArrayList<>();
        for(int i=0; i<=n; i++){
            lst.add(new ArrayList<>());
        }
        
    
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];
            
            lst.get(a).remove(Integer.valueOf(b));
            lst.get(b).remove(Integer.valueOf(a));
            
            visited = new boolean[n+1];
            
            d = 0;
            dfs(a);
            int d1 = d;
            
            
            d = 0;
            dfs(b);
            int d2 = d;
            
            answer = Math.min(answer, Math.abs(d1-d2));
            
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        return answer;
    }
    
    public void dfs(int node){
       visited[node] = true;
        d++;
        
        for (int next : lst.get(node)){
            if(!visited[next]) {
                dfs(next);
            }
        }
        
    }
}