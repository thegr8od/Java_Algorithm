import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int task = 0;
        int end = 0;
        int count =0;
        Arrays.sort(jobs, (o1,o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        while(count<jobs.length){
            
            while(task<jobs.length && jobs[task][0] <= end){
                pq.add(jobs[task++]);
            }
            
            if(pq.isEmpty()){
                end = jobs[task][0];
            }
            else {
                int[] cur = pq.poll();
                answer += cur[1] - cur[0] + end;
                end += cur[1];
                count++;
            }
        }
        
        
        return answer/jobs.length;
    }
}