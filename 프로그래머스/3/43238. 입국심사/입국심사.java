import java.util.*;

class Solution {
    static long answer = 0;
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = times[0];
        long end = times[times.length-1] * (long)n;
        binarySearch(times, n, start,end);
        
        return answer;
    }
    
     public void binarySearch(int[] times, int target, long start, long end) {
         
        while (start <= end) {
            long mid = (start + end) / 2;
            long num = 0;
            
            for(int i =0; i<times.length; i++){
                num += (mid/times[i]);
            }
            
            if (num < target) {
                start = mid + 1;
            }
            // 중간 값보다 target이 큰 경우 오른쪽 확인
            else {
                answer = mid;
                end = mid - 1;
            }
        }
    }
}
