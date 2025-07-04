class Solution {
    static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0,dungeons, k);
        return answer;
    }
    
    public void dfs(int d, int[][] dungeons, int k){
        
        answer = Math.max(answer,d);
        
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(d+1,dungeons, k-dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}