import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int a : scoville){
            pq.add(a);
        }
        int min = pq.peek();
        
        while(min<K){
            if(pq.size()>=2){
                int firM = pq.poll();
                int secM = pq.poll();
                pq.add(firM + (secM * 2));
                min = pq.peek();
                answer++;
                
            }
            else{
                return -1;
            }
        }
        return answer;
    }
}