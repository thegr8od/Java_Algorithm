class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,n,computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int now, int n, int[][] computers){
        visited[now] = true;
        
        for(int i=0; i<n; i++){
                if(!visited[i] && computers[now][i] == 1){
                    dfs(i,n, computers);
                }
        }
    }
        
    
}