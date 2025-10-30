class Solution {
    public int[] solution(int n) {
        int max = n*(n+1)/2;
        int[] answer = new int[max];
        int[][] map = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;
        for(int i=0; i<n;i++){
            for(int j=i; j<n; j++){
                if(i%3 == 0){
                    map[++x][y] = num++;
                }
                else if(i%3 ==1){
                    map[x][++y] = num++;
                }
                else if(i%3 == 2){
                    map[--x][--y] = num++;
                }
            }
        }
        
        int idx = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx] = map[i][j];
                idx++;
            }
        }
        return answer;
    }
}