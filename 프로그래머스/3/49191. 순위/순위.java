class Solution {
    int[][] grade;
    int N;
    public int solution(int n, int[][] results) {
        
        grade = new int[n+1][n+1];
        for(int i=0; i<results.length; i++){
            int winner = results[i][0];
            int losser = results[i][1];
            
            grade[winner][losser] = 1;
            grade[losser][winner] = -1;
        }
        
        for(int k=1; k<=n ; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(grade[i][k] == 1 && grade[k][j] == 1){
                        grade[i][j] = 1;
                        grade[j][i] = -1;
                    }
                    
                    if(grade[i][k] == -1 && grade[k][j] == -1){
                        grade[i][j] = -1;
                        grade[j][i] = 1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(grade[i][j]==0){
                    cnt++;
                }
            }
            if(cnt==1) answer++;
        }
        return answer;
    }
}