import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for(int i=0; i<sizes.length; i++){
            if(sizes[i][1] > sizes[i][0]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        int a = 0;
        int b = 0;
        for(int i=0; i<sizes.length; i++){
            a = Math.max(a, sizes[i][0]);
            b = Math.max(b, sizes[i][1]);
        }
        return a*b;
    }
}