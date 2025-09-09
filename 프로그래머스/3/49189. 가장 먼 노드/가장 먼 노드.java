import java.util.*;

class Solution {
    static int answer;
    static int maxNum;
    static List<Integer>[] lst;
    public int solution(int n, int[][] edge) {
        lst = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            lst[i] = new ArrayList<>();
        }
        for(int[] now : edge){
            int a = now[0];
            int b = now[1];
            lst[a].add(b);
            lst[b].add(a);
        }
        
        int[] dist = new int[n+1];
        bfs(dist, 0, 1);
        dist[1] = 0;
        
        for(int n1 : dist){
            maxNum = Math.max(n1, maxNum);
        }
        
        
        for(int n2: dist){
            if(n2 == maxNum) answer++;
        }
        return answer;
    }
    
    static void bfs (int[] dist, int d, int now){
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(now);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int num : lst[cur]){
                if(dist[num] == 0){
                    dist[num] = dist[cur] + 1;
                    queue.add(num);
                }
            }
        }
        
    }
    

}