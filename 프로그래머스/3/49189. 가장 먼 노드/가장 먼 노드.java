import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] lst = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] arr = new int[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<n+1; i++){
            lst[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            lst[a].add(b);
            lst[b].add(a);
        }
        
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int next : lst[num]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    arr[next] = arr[num] + 1;
                }
            }
        }
        
        Arrays.sort(arr);
        int max = arr[n];
        
        for(int num : arr){
            if(num == max){
                answer++;
            }
        }
        
        
        return answer;
    }
}