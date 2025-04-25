import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            boolean[] visited = new boolean[n+1];
            int countA = dfs(a, graph, visited);
            int countB = n - countA;
            
            answer = Math.min(answer, Math.abs(countA-countB));
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        
        return answer;
    }
    
    public int dfs(int node, List<List<Integer>> graph, boolean[] visited){
    
        visited[node] = true;
        int count = 1;
        
        for(int next : graph.get(node)){
            if (!visited[next]){
                count += dfs(next, graph, visited);
            }
        }
        
        return count;
    }
}