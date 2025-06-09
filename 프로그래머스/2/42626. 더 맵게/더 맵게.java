import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : scoville){
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            if(pq.size() == 1 && pq.peek() < K){
                break;
            }
            else if(pq.peek() < K){
                int first = pq.poll();
                int second = pq.poll();
                int now = first + (second * 2);
                pq.add(now);
                count++;
            }
            else{
                return count;
            }
        }
        
        count = -1;
        return count;
        
        
    }
}