import java.util.*;

class Solution {
    static Queue<Integer> queue = new ArrayDeque<>();
    static int arr[];
    static ArrayList<Integer>[] lst;
    static boolean visited[];
    public int solution(int n, int[][] edge) {
        int answer = 0;
        arr = new int[n+1];
        visited = new boolean[n+1];
        lst = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
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
            int a = queue.poll();
            for(int b : lst[a]){
                if(visited[b]){
                    continue;
                }
                queue.add(b);
                visited[b] = true;
                arr[b] = arr[a]+1;
            }
        }
        
        Arrays.sort(arr);
        int cnt = 0;
        int max = arr[n];
        
        for(int i=n; i>=1; i--){
            if(max==arr[i]) cnt++;
            else {
                break;
            }
        }
        
        return cnt;
    }
}