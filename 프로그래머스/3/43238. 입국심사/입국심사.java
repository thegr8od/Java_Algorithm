class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long maxTime = 0;
        
        for(int time : times){
            if(time>maxTime){
                maxTime = time;
            }
        }
        
        long end = maxTime * n;
        
        while(start<=end){
            long mid = (start + end)/2;
            long sum = 0;
            for(int time : times){
                long count = mid/time;
                sum += count;
            }
            
            if(sum>=n){
                end = mid-1;
                answer = mid;
            }
            else{
                start = mid+1;
            }
        }
        
        
        return answer;
        
    
    }
    
    
}