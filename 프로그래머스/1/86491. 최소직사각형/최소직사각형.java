import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        
        for(int i =0; i<sizes.length; i++){
            if(sizes[i][1] > sizes[i][0]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int x = 0;
        int y = 0;
        for (int i =0; i<sizes.length; i++){
            x = Math.max(sizes[i][0], x);
            y = Math.max(sizes[i][1], y);
        }
        answer = x*y;
        return answer;
    }
}