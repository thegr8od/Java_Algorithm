class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 0;
        for(int n : diffs){
            end = Math.max(end,n);
        }
       
        int timeCur = 0;
        
        while(start<=end){
            int mid = (start+end) / 2; // level임
            int timePrev = 0;
            long time = 0;
            
            for(int i =0; i<diffs.length; i++){
                int diff = diffs[i];
                if(diff <= mid){
                    time += times[i];
                    timePrev = times[i];
                }
                else{
                    time += (long) (timePrev+ times[i]) * (diff - mid) + times[i];
                    timePrev = times[i];
                }
                
            }
            
            if(time<=limit) {
                answer = mid;
                end = mid-1;
            }
            else if(time>limit){
                start = mid+1;
            }
            
            
            
        }
        
        System.out.print(end);

            
        return answer;
    }
}