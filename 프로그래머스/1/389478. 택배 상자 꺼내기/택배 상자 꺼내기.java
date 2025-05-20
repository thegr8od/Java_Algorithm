class Solution {
    static int[][] data;
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h =0;
        if(n%w==0){
            h = n/w;
        }else{
            h = n/w+1;
        }
        data = new int[h][w];
        
        int now = 1;
        for(int i=0; i<h;i++){
            if(i%2 == 0){
                for(int j=0; j<w; j++){
                    if(now > n) break;
                    data[i][j] = now++; 
                }
            }
            else{
                for(int j=w-1; j>=0; j--){
                    if(now > n) break;
                    data[i][j] = now++;
                }
            }
        }
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(data[i][j] == num){
                    answer = find(i,j,h,0);
                }
            }
        }
        
        
      
        return answer;
    }
    
    static int find(int x, int y, int h, int cnt){
        for(int i=x; i<h; i++){
            if(data[i][y] != 0){
                cnt++;
            }
        }
        return cnt;
    }
}