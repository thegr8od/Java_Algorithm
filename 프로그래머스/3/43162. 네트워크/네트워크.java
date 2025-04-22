class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                answer++;
                dfs(i, visited, computers);
            }            
        }
        
        return answer;
    }
    
    public void dfs(int idx, boolean[] visited, int[][] computers){
        visited[idx] = true;
        
        for(int i =0; i<computers.length; i++){
            if(!visited[i] && computers[idx][i] == 1){
                dfs(i, visited, computers);
            }
        }
    }
}