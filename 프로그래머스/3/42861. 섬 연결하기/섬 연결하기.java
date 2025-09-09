import java.util.*;

class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);
        
        parents = new int[n];
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            if(union(costs[i][0], costs[i][1])) {
                answer += costs[i][2];
            }
        }
        
        return answer;
        
    }
    
    static boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);
        
        if (root1 == root2) return false;
        
        if (root1 > root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
        
        return true;
    }
    
    static int find(int a){
        if (a == parents[a]){
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}