class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = 0;
        if(n%w == 0){
            h = n/w;
        }else{
            h = n/w + 1;
        }
        int[][] map = new int[h][w];
        int idx = 1;
        for(int i=h-1; i>=0; i--){
            
            
            if(h%2 == 0){
                if(i%2 == 1){
                   for(int j=0; j<w; j++){
                       map[i][j] = idx++;
                       if(idx > n) break;
                   } 
                }
                else{
                    for(int j=w-1; j>=0; j--){
                        map[i][j] = idx++;
                        if(idx > n) break;
                    }
                }
                
            }
            else{
                if(i%2 == 0){
                   for(int j=0; j<w; j++){
                       map[i][j] = idx++;
                       if(idx > n) break;
                   } 
                }
                else{
                    for(int j=w-1; j>=0; j--){
                        map[i][j] = idx++;
                        if(idx > n) break;
                    }
                }
            }
           
            
        
        }
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == num){
                    for(int k=i; k>=0; k--){
                        if(map[k][j] !=0) answer++;
                    }
                    
                }
            }
        }
        return answer;
    }
}