import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int pos = routes[0][1];
        answer++;
        
        for(int[] route : routes){
            int start = route[0];
            int end = route[1];
            
            if(start > pos){
                pos = end;
                answer++;
            }
        }
        
        return answer;
    }
}