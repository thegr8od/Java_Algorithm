import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scv : scoville){
            pq.add(scv);
        }
        
        while(true){            
            if(pq.peek() < K){
                if(pq.size() == 1){
                    return -1;
                }
                else{
                    int first = pq.poll();
                    int second = pq.poll();
                    pq.add(first + second*2);
                    answer++;
                }
            }
            else if(pq.peek() >= K){
                return answer;
            }
        }
    }
}