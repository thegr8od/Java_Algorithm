import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int start = 1;
        int end = distance;
        
        while(start<=end){
            int mid = (start + end) / 2;
            
            int before = 0;
            int cnt = 0;
            for(int i=0; i<rocks.length; i++){
                if(rocks[i] - before < mid){
                    cnt++;
                    continue;
                }
                before = rocks[i];
            }
            
            if(distance - before < mid) cnt++;
            
            if(cnt<=n){
                answer = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        
        return answer;
    }
}