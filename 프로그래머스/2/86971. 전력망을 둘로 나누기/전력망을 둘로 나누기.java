import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 9999999;
        List<List<Integer>> lst = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            lst.add(new ArrayList<>());
        }
        
        for (int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        
        for (int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            lst.get(a).remove(Integer.valueOf(b));
            lst.get(b).remove(Integer.valueOf(a));
            boolean[] visited = new boolean[n+1];
            int first = dfs(a, lst, visited);
            int second = n - first;
            
            answer = Math.min(answer, Math.abs(first-second));
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        
        return answer;
    }
    
    public int dfs(int idx, List<List<Integer>> lst, boolean[] visited){
        visited[idx] = true;
        int cnt = 1;
        
        
        for(int next : lst.get(idx)){
            if(!visited[next]){
                cnt += dfs(next,lst,visited);
            }
        }
        
        
        return cnt;
    }
}