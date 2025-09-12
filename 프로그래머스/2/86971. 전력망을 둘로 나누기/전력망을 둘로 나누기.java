import java.util.*;

class Solution {
    static List<List<Integer>> lst;
    static boolean[] visited;
    static int d;
    public int solution(int n, int[][] wires) {
        int answer = 999999;
        lst = new ArrayList<>();
        for(int i=0; i<=n; i++){
            lst.add(new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            lst.get(a).remove(Integer.valueOf(b));
            lst.get(b).remove(Integer.valueOf(a));
            
            visited = new boolean[n+1];
            
            d=0;
            dfs(a, n);
            int first = d;
            
            d=0;
            dfs(b, n);
            int second = d;
            
            answer = Math.min(answer,Math.abs(first-second));
            
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        
        
        return answer;
    }
    
    static void dfs(int now, int n){
        
        visited[now] = true;
        d++;
        
        for(int next : lst.get(now)){
            if(!visited[next]){
                dfs(next, n);
            }
        }
        
    }
}