class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int idx, int[][] computers){
        visited[idx] = true;
        
        for(int i=0; i<computers.length; i++){
            if(computers[idx][i] == 1 && !visited[i]){
                dfs(i,computers);
            }
        }
    }
}